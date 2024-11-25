import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int resposta = 0, resultado = 0;

        System.out.println("Insira o número de bytes: ");
        resposta = in.nextInt();
        resultado = resposta * 8;
        System.out.println(resposta + " bytes é iquivalente a " + resultado + " bits");

    }
}