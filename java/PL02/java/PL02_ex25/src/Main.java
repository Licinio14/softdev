import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ano = 0, resp = 0;

        System.out.println("Insira o ano: ");
        resp = in.nextInt();

        if ((resp % 4) != 0){
            System.out.println("O ano não é bissexto");
        } else if ((resp % 100) != 0) {
            System.out.println("O ano é bissexto");
        } else if ((resp % 400) == 0) {
            System.out.println("O ano é bissexto");
        } else {
            System.out.println("Erro!");
        }

    }
}