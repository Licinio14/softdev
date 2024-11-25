import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // como verificar se escreveu um número na string
        Scanner in = new Scanner(System.in);

        String resposta;
        boolean resultado;

        System.out.println("Digite algo: ");
        resposta = in.nextLine();

        resultado = result(resposta);

        if (resultado == true){

            System.out.println("é um número");

        }else {

            System.out.println("nao é um número");

        }







    }


    public static boolean result(String teste){
        if (teste == null) {
            return false;
        }
        try {
            Double.parseDouble(teste);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}