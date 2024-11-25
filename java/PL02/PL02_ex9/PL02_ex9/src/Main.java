import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o 1ª número");
        int n1 = in.nextInt();

        System.out.println("Insira o 1ª número");
        int n2 = in.nextInt();

        System.out.println("Insira o 1ª número");
        int n3 = in.nextInt();

        System.out.println("Insira o 1ª número");
        int n4 = in.nextInt();

        if (n1 < n2 && n1 < n3 && n1 < n4) {
            System.out.println("O menor é o " + n1);
        } else if ( n2 < n3 && n2 < n4) {
            System.out.println("O menor é o " + n2);
        }else if ( n3 < n4 ) {
            System.out.println("O menor é o " + n3);
        }else {
            System.out.println("O menor é o " + n4);
        }


    }
}