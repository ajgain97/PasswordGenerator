import java.util.*;

public class userInfo {

    private String firstname;
    private String lastname;
    private String answer;
    private String username;

    Scanner input = new Scanner(System.in);

    public userInfo() {}

    public void setFirstName() {
        System.out.print("Enter your first name: ");
        firstname = input.next();
    }

    public String getFirstName() {
        return firstname;
    }

    public void setLastName() {
        System.out.print("Enter your last name: ");
        lastname = input.next();
    }

    public String getLastName() {
        return lastname;
    }

    public void setAnswer() {
        System.out.print("Enter an option for security question (1-3): ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.print("What is the name of your first pet?: ");
                answer = input.next();
                break;
            case 2:
                System.out.print("What is the model of your first car?: ");
                answer = input.next();
                break;
            case 3:
                System.out.print("What is the name of your high school?: ");
                answer = input.next();
                break;
        }
    }
 
    public String getAnswer() {
        return answer;
    }

    public void setUserName() {
        System.out.println("Menu\n1. Standard Username\n2. Custom Username");
        System.out.print("Choose From The Menu: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                setFirstName();
                setLastName();
                System.out.print("Enter your birth year: ");
                String year = input.next();
                username = getFirstName().toLowerCase() + "." + getLastName().toLowerCase() + "." + year.substring(2, 4);
                break;
            case 2:
                System.out.print("Enter your new username: ");
                username = input.next();
                break;
        }
    }

    public String getUserName() {
        return username;
    }
}