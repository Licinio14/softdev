import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int resposta = 0, soma = 0, verificacao = 0, resultado = 0, count = 0;
        double media = 0;

        System.out.println("Insira o número 0 para terminar o programa!");

        do {

            System.out.println("Insira um número: ");
            resposta = in.nextInt();

            if (resposta >= 4) {
                soma = soma + resposta;
                count++;
            }

            if (resposta == 0) {
                verificacao = 1;
            }

        } while (verificacao == 0);

        if (count == 0) {

            System.out.println("Não fora inseridos números maiores que 4.");

        } else {
            media = soma / count;
            System.out.println("Foram inseridos " + count + " números maiores que 4, sendo que a média desses números é: " + media);
        }


    }
}