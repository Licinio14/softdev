import javax.lang.model.element.NestingKind;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //2. Crie um algoritmo que apos ler dois numeros inteiros apresenta a sua soma

        Scanner in = new Scanner(System.in);

        System.out.println("Insira um numero: ");
        //String num1 = in.nextLine();
        // converter para int
        //int n1 = Integer.parseInt(num1);

        double n1 = in.nextDouble();

        System.out.println("Insira outro numero: ");
        double n2 = in.nextDouble();

        double soma = n1 + n2;
        // ficar com a parte inteira
        // int s = (int)soma;
        System.out.println("A soma é: " + soma);


    }
}