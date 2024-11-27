import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Crie um algoritmo que apos ler dois numeros inteiros apresenta a sua diferenca

        Scanner in = new Scanner(System.in);
        int n1, n2, n3;
        System.out.println("Insira o primeiro número: ");
        n1 = in.nextInt();

        //sout
        System.out.println("Insira o primeiro número: ");
        n2 = in.nextInt();

        System.out.println("A difenrença entre os dois números é: ");

        /* manter o resultado positivo
        int n3;
        if (n1 > n2) {
            n3 = n1 - n2;
        }else {
            n3 = n2 - n1;
        }
        */

        n3 = n1 - n2;

        //Math.abs(variavel) - mostra o numero sempre positivo
        System.out.println(Math.abs(n3));

    }
}