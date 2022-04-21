public class passGen extends userInfo {

    final static String symbols = "~`!@#$%^&*()_-+={[}]|:;<,>.?/";

    private String newPass;
    private String modPass;
    private int num;
    
    public passGen() {}

    public char[] getPasswordArray(String firstname, String lastname, String answer) {
        char[] firstNameArray = firstname.toCharArray();
        char[] lastNameArray = lastname.toCharArray();
        char[] answerArray = answer.toCharArray();
        char[] symbolArray = symbols.toCharArray();
        int randChoice = 0;
        int arrayLength = firstNameArray.length + lastNameArray.length + answerArray.length + symbolArray.length;
        char[] passwordArray = new char[arrayLength];
        for (int i = 0; i < passwordArray.length; i++) {
            int num = (int) (Math.random() * 4);
            switch (num) {
                case 0:
                    randChoice = (int) (Math.random() * firstNameArray.length);
                    passwordArray[i] = firstNameArray[randChoice];
                    num = (int) (Math.random() * 4);
                    break;
                case 1:
                    randChoice = (int) (Math.random() * lastNameArray.length);
                    passwordArray[i] = lastNameArray[randChoice];
                    num = (int) (Math.random() * 4);
                    break;
                case 2:
                    randChoice = (int) (Math.random() * answerArray.length);
                    passwordArray[i] = answerArray[randChoice];
                    num = (int) (Math.random() * 4);
                    break;
                case 3:
                    randChoice = (int) (Math.random() * symbolArray.length);
                    passwordArray[i] = symbolArray[randChoice];
                    num = (int) (Math.random() * 4);
                    break;
            }
        }
        return passwordArray; 
    }

    public String modPassword(String password) {
        newPass =  password.substring(0, 5) + (int) (Math.random() * 1001) + password.substring(10, 15) + (int) (Math.random() * 1001) + password.substring(20, 25) + (int) (Math.random() * 1001);
        return newPass;
    }

    public void setPassword(String firstname, String lastname, String answer) {
        modPass = modPassword(String.valueOf(getPasswordArray(firstname, lastname, answer)));
    }

    public String getPassword() {
        return modPass;
    }

    public void appendPassword(char choice, String firstname, String lastname, String answer) {
        while (choice == 'Y') {
            System.out.print("Would you like to change any info? (Y/N): ");
            char inner_choice = input.next().charAt(0);
            if (inner_choice == 'Y') {
                System.out.println("1. First Name\n2. Last Name\n3. Answer");
                System.out.print("What would you like to change? (Please choose from menu): ");
                num = input.nextInt();
            }
            else {
                break;
            }
            while (inner_choice == 'Y') {
                switch (num) {
                    case 1:
                        setFirstName();
                        firstname = getFirstName();
                        System.out.print("Would you like to change any info? (Y/N): ");
                        inner_choice = input.next().charAt(0);
                        if (inner_choice != 'Y') {
                            choice = ' ';
                            break;
                        }
                        System.out.println("1. First Name\n2. Last Name\n3. Answer");
                        System.out.print("What would you like to change? (Please choose from menu): ");
                        num = input.nextInt();
                        break;
                    case 2:
                        setLastName();
                        lastname = getLastName();
                        System.out.print("Would you like to change any info? (Y/N): ");
                        inner_choice = input.next().charAt(0);
                        if (inner_choice != 'Y') {
                            choice = ' ';
                            break;
                        }
                        System.out.println("1. First Name\n2. Last Name\n3. Answer");
                        System.out.print("What would you like to change? (Please choose from menu): ");
                        num = input.nextInt();
                        break;
                    case 3:
                        setAnswer();
                        answer = getAnswer();
                        System.out.print("Would you like to change any info? (Y/N): ");
                        inner_choice = input.next().charAt(0);
                        if (inner_choice != 'Y') {
                            choice = ' ';
                            break;
                        }
                        System.out.println("1. First Name\n2. Last Name\n3. Answer");
                        System.out.print("What would you like to change? (Please choose from menu): ");
                        num = input.nextInt();
                        break;
                }
            }
        }
        setPassword(firstname, lastname, answer);
    }
}