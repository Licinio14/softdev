import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //verificar se o numero é par

        Scanner in = new Scanner(System.in);

        System.out.println("Insira um número: ");
        int numero = in.nextInt();

        if (numero%2 == 0) {
            System.out.println(numero + " é par.");
        }else if (numero%2 == 1){
            System.out.println(numero + " é impar.");
        }else {
            System.out.println("erro!");
        }



    }
}