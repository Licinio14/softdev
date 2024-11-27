import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        int menu1;
        System.out.println("Bem-vindo");

        do {
            System.out.println("\nEscolha uma opção:\n1 - Calculadora\n2 - lista de números\n0 - Sair");
            menu1 = in.nextInt();

            switch (menu1) {
                case 0:
                    break;
                case 1:
                    Calculadora();
                    break;
                case 2:
                    Lista();
                    break;
                default:
                    System.out.println("Insira uma opção válida!!!");
                    break;

            }

        } while (menu1 != 0);


    }

    private static void Calculadora() {
        int menu2;

        do {
            System.out.println("\nAplicação 1: Calculadora\n1 - Somar\n2 - Subtrair\n0 - Voltar ao menu anterior");
            menu2 = in.nextInt();

            switch (menu2) {
                case 0:
                    break;
                case 1:
                    Somar();
                    break;
                case 2:
                    Subtrair();
                    break;
                default:
                    System.out.println("Insira uma opção válida!!!");
            }

        } while (menu2 != 0);
    }
    private static void Somar() {
        double soma, num1, num2;
        System.out.println("Insira os dois números para somar");
        System.out.println("Insira o 1º número: ");
        num1 = in.nextDouble();
        System.out.println("Insira o 2º número: ");
        num2 = in.nextDouble();
        soma = num1 + num2;
        System.out.println("A soma dos números " + num1 + " + " + num2 + " é " + soma);
    }
    private static void Subtrair() {
        double soma, num1, num2;
        System.out.println("Insira os dois números para subtrair");
        System.out.println("Insira o 1º número: ");
        num1 = in.nextDouble();
        System.out.println("Insira o 2º número: ");
        num2 = in.nextDouble();
        soma = num1 - num2;
        System.out.println("A subtração dos números " + num1 + " - " + num2 + " é " + soma);
    }

    private static void Lista() {

        int num1, num2;

        System.out.println("\nDigites o primeiro e ultimo número da lista: ");
        System.out.println("Número para começar: ");
        num1 = in.nextInt();
        System.out.println("Número para terminar: ");
        num2 = in.nextInt();

        if (num1 < num2) {
            for (int i = num1; i <= num2; i++) {
                System.out.println(i);
            }
        } else if (num1 == num2) {
            System.out.println("Os números sao iguais");
        } else {
            for (int i = num1; i >= num2; i--) {
                System.out.println(i);
            }
        }
    }
}