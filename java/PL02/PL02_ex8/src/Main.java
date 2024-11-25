import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n1, n2;

        System.out.println("Insira um número");
        n1 = in.nextInt();

        System.out.println("Insira outro número");
        n2 = in.nextInt();

        if ( n1 > n2 ) {
            System.out.println("O " + n1 + " é maior que " + n2);
        }else if ( n1 < n2 ) {
            System.out.println("O " + n2 + " é maior que " + n1);
        }else {
            System.out.println("Os números sao iguais.");
        }

    }
}