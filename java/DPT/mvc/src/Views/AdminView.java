package Views;

import Controllers.AdminController;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class AdminView {

    AdminController adminController;

    public AdminView() throws FileNotFoundException {
        adminController = new AdminController();
    }

    public void adminMenu() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        int menuOption;

        do {
            System.out.println("Hello Dear Admin. Nice to see you.");
            System.out.println("1. Most Sold Product (By Units)");
            System.out.println("2. Most Sold Product (By Value)");
            System.out.println("3. Best Sale (By Units)");
            System.out.println("4. Best Sale (By Value)");
            System.out.println("5. Total Sales");
            System.out.println("6. Avarage Sales");
            System.out.println("7. Coffe Time");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            menuOption = input.nextInt();

            switch (menuOption){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    double totalSales = this.adminController.getTotalSales();
                    System.out.println("********* Total Sales ************");
                    System.out.println(totalSales + " €");
                    break;
                case 6:

                    break;
                case 7:
                    coffeTime();
                    break;
                case 0:

                    break;
                default: // invalid option
                    System.out.println("Invalid option!");
                    break;
            }
        }while (menuOption != 0);
    }

    private  void coffeTime() throws InterruptedException {
        System.out.println("Awaiting coffe");

        System.out.println("__________________________");
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);
        System.out.println("|");
        sleep(300);



    }
}
