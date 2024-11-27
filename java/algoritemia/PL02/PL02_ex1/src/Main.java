import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Programa que pede o nome do utilizador e o cumprimenta

        /* Comentar
        varias
        linhas
         */

        System.out.println("Qual é o seu nome?");
        String nome = in.nextLine();
        System.out.println("Ola " + nome);

        // System.out.println("Ola " + in.nextLine());

    }
}