import java.io.*;
import java.util.*;

public class writeFile {

    userInfo user = new userInfo();
    passGen pass = new passGen();

    String firstname = user.getFirstName();
    String lastname = user.getLastName();
    String answer = user.getAnswer();

    public writeFile() {}

    public void outputPassWord() throws IOException {
        PrintWriter writer = new PrintWriter(new FileOutputStream("C:/PasswordDoc.txt", true));
        writer.printf("This is your new password: %s\n", pass.modPassword(String.valueOf(pass.getPasswordArray(firstname, lastname, answer))));
        writer.close();
    }
}
