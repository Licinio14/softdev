import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //contar o characteres teste.length()
        String teste, teste2;
        int comprimento, soma, resultado = 0, count, ulti = 2, num, testeint;

        System.out.println("Insira o numero binário: ");
        teste = in.nextLine();
        comprimento = teste.length();
        count = teste.length();

        /*
            notas:

            123 / 10 = 12
            123 % 10 = 3


        // resposta do utilizador:
        int binario;
        int dec = 0, pos = 0;
        int ultimoDigito;

        System.out.println("Digite o valor: ");
        binario = in.nextInt();
        while (binario > 0){
            ultimoDigito = binario % 10;
            if (ultimoDigito != 0 && ultimoDigito != 1) {
                System.out.println("Valor inserido invalido!");
                return;
            }
            dec += ultimoDigito * Math.pow(2, pos);
            pos++;
            binario /=10;
        }
        System.out.println("o número é " + dec);

         */

        for (int i = 0; i < comprimento; i++) {
            teste2 = String.valueOf(teste.charAt(i));
            testeint = Integer.parseInt(teste2);
            if (testeint != 0 && testeint != 1) {
                System.out.println("O valor inserido é invalido!");
                return;
            }
        }

        for (int i = 0; i < comprimento; i++) {

            if (count >= 2) {
                for (int a = 1; a < (count - 1); a++) {

                    ulti *= 2;

                }
            } else if (count == 1) {

                ulti = 0;

            }

            teste2 = String.valueOf(teste.charAt(i));
            num = Integer.parseInt(teste2);

            if (i == (comprimento - 1)) {
                ulti = 1;
            }

            soma = num * ulti;
            count--;
            resultado += soma;
            ulti = 2;
            
        }

        System.out.println(teste + " é o número: " + resultado);

    }
}