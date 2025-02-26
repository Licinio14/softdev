package Views;

import java.util.Scanner;

public class CostumerView {
    public CostumerView() {
    }

    public void customerMenu(){


        Scanner input = new Scanner(System.in);

        int menuOption;

        do {
            System.out.println("Hello! Nice to see you.");
            System.out.println("1. Available Products");
            System.out.println("2. Products by Category");
            System.out.println("3. Most Expensive/Cheapest Product");
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
                case 0:

                    break;
                default: // invalid option
                    System.out.println("Invalid option!");
                    break;
            }
        }while (menuOption != 0);


    }
}
