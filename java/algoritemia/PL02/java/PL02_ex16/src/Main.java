import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = 1, resp = 0, soma = 0, resultado = 0;


        for (i = 1; i <= 20; i++) {

            System.out.println("Insira o numero nª" + i + ": ");
            resp = in.nextInt();
            soma = soma + resp;

        }

        i--;
        resultado = soma / i;
        System.out.println("A média dos " + i + " números é: " + resultado);

    }
}