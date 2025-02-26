package Views;

import java.util.Scanner;

public class CrewView {

    public CrewView() {
    }

    public void crewMenu(){


        Scanner input = new Scanner(System.in);

        int menuOption;

        do {

            System.out.println("Hello! Get to Work.");
            System.out.println("1. Add New Sale");
            System.out.println("2. Check Product Stock");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            menuOption = input.nextInt();

            switch (menuOption){
                case 1:

                    break;
                case 2:

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
