import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int dias = 0, semanas = 0, anos = 0, resposta = 0, teste = 0;
        String an, di, se;

        System.out.println("Insira o número de dias: ");
        resposta = in.nextInt();
        teste = resposta;


        /*
            int anos = totaldias / 365;
            int resto = totaldias % 365;
            int semanas = resto / 7;
            int dias = semanas % 7;

         */

        if (teste > 0){
            while (teste >= 365) {
                teste = teste - 365;
                anos++;
            }
            while (teste >= 7) {
                teste = teste - 7;
                semanas++;
            }
            while (teste > 0) {
                teste = teste - 1;
                dias++;
            }
        }else {
            System.out.println("Resposta invaliada!");
            return;
        }

        if (anos == 1){
            an = " ano ";
        }else {
            an = " anos ";
        }
        if (semanas == 1){
            se = " semana ";
        }else {
            se = " semanas ";
        }
        if (dias == 1){
            di = " dia.";
        }else {
            di = " dias.";
        }


        System.out.println(resposta + " dias são " + anos + an + semanas + se + dias + di);

    }
}