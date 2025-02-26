package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {

    LoginController loginController;

    public LoginView(LoginController loginController) {
        this.loginController = loginController;
    }

    public LoginView() {
    }

    public void entryView(){
        Scanner input = new Scanner(System.in);
        int loginOption;

        do {



            System.out.println("Welcome to Big Business Grocery Store");
            System.out.println("1. Customer");
            System.out.println("2. Staff Member");
            System.out.println("0. Exit");
            System.out.print("Choose:");

            loginOption = input.nextInt();

            switch (loginOption){
                case 1: // Customer
                    CostumerView customerView = new CostumerView();
                    customerView.customerMenu();
                    break;
                case 2: // staff Member

                    System.out.println("\nLogin with your cradentials");
                    System.out.print("Username: ");
                    String usernameInput = input.next();

                    System.out.print("Password: ");
                    String passwordInput = input.next();

                    break;
                case 0:

                    break;
                default: // invalid option
                    System.out.println("Invalid option!");
                    break;
            }
        }while (loginOption != 0);
    }

    private void validateLogin(String usernameInput, String passwordInput) throws InterruptedException, FileNotFoundException {
        String access = loginController.accessType(usernameInput,passwordInput);

        switch (access){
            case "ADMIN":
                AdminView adminView = new AdminView();
                adminView.adminMenu();
                break;
            case  "FUNC":
                CrewView crewView = new CrewView();
                crewView.crewMenu();
                break;
            case  "ERROR":
                System.out.println("Invalid Credentials");
                break;
        }
    }
}
