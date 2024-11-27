import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = 0, numero1 = 0, numero2 = 0, resultado = 0, teste = 0;

        System.out.println("Insira o primeiro número: ");
        numero1 = in.nextInt();
        System.out.println("Insira o segundo número: ");
        numero2 = in.nextInt();


        if (numero1 < numero2) {
            teste = numero1;
            numero1 = numero2;
            numero2 = teste;
        }

        for (i = 0; i < numero2; i++) {
            resultado += numero1;
        }

        System.out.println("A multiplicação de " + numero1 + " por " + numero2 + " é " + resultado);

    }
}