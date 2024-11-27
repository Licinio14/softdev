import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int resposta = 0, segundos = 0;

        System.out.println("Insira o número de horas:");
        resposta = in.nextInt();
        segundos = resposta * 60 * 60;
        System.out.println(resposta + " horas são " + segundos + " segundos.");

    }
}