import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class displayInfo extends Application {
    userInfo user = new userInfo();
    passGen pass = new passGen();

    protected Text text = new Text(50, 50, "Display Password");
    protected Text username = new Text(50, 50, "This is your username: " + user.getUserName());
    protected Text password = new Text(50, 50, "This is your password: " + pass.getPassword());

    protected BorderPane getPane() {
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Set Username");
        Button btRight = new Button("Set Password");
        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: blue");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeft.setOnAction(
            e -> {
                user.setUserName();
                paneForText.getChildren().add(username);
                pane.setLeft(paneForText);
            }
        );

        btRight.setOnAction(
            e -> {
                user.setFirstName();
                user.setLastName();
                user.setAnswer();
                pass.setPassword(user.getFirstName(), user.getLastName(), user.getAnswer());
                paneForText.getChildren().add(password);
                pane.setRight(paneForText);
            }
        );

        return pane;
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("Password Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}