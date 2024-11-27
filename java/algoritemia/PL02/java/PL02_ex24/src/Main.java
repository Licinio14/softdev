import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0, validacao = 0, numresp = 1;
        double media = 0, menor = 0, maior = 0, resp = 0;
        String resposta = "q";


        do {
            System.out.println("Insira o " + numresp + "ª número, ou Q para terminar!");
            resposta = in.nextLine();


            if (Objects.equals(resposta, "Q") || Objects.equals(resposta, "q")) {


                validacao = 1;


            } else {
                numresp++;
                count++;
                resp = Double.parseDouble(resposta);
                if (count == 1) {
                    resp = Integer.parseInt(resposta);
                    menor = resp;
                    maior = resp;
                    media = resp;
                } else if (count > 1) {
                    if (menor > resp) {
                        menor = resp;
                    }
                    if (maior < resp) {
                        maior = resp;
                    }
                    media += resp;
                } else {
                    validacao = 1;
                }

            }


        } while (validacao == 0);

        if (count == 0) {
            System.out.println("Não foram adicionados valores!");
        } else {
            media /= count;
            System.out.println("O maior número é: " + maior);
            System.out.println("O maior menor é: " + menor);
            System.out.println("A média de " + count + " números é: " + media);
        }


    }
}