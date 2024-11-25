import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 1, soma = 0, resp = 0;
        double resultado = 0;
        while (count <= 5) {

            System.out.println("Insira o numero nª" + count + ": ");
            resp = in.nextInt();
            soma = soma + resp;

            count++;
        }
        count--;
        resultado = soma / count;
        System.out.println("A média dos " + count + " é: " + resultado);


    }
}