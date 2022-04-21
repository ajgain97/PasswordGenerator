import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        userInfo user = new userInfo();
        passGen pass = new passGen();

        user.setUserName();
        System.out.printf("This is your username: %s\n", user.getUserName());

        user.setFirstName();
        user.setLastName();
        user.setAnswer();

        pass.setPassword(user.getFirstName(), user.getLastName(), user.getAnswer());
        System.out.printf("This is your password: %s\n", pass.getPassword());
        System.out.print("Would you like to change your password? (Y/N): ");
        char choice = input.next().charAt(0);
        pass.appendPassword(choice, user.getFirstName(), user.getLastName(), user.getAnswer());
        System.out.printf("This is your password: %s\n", pass.getPassword());
        input.close();
    }
}