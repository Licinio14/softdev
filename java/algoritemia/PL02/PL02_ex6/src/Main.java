import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // receber o valor do quilo, quantidade de quilos consumidos e mostrar o valor a pagar

        Scanner in = new Scanner(System.in);

        double valor, quilos, precof;

        System.out.println("Quanto que é o valor do quilo?");
        valor = in.nextDouble();
        System.out.println("Quantos quilos foram consumidos?");
        quilos = in.nextDouble();
        precof = quilos * valor;
        System.out.println("O valor a pagar é de: " + precof + " €");


    }
}