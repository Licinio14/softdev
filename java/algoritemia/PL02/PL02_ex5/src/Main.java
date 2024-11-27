import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // receber valor pago, valor do produto e dar o troco

        Scanner in = new Scanner(System.in);

        double rec, preco, troco;

        System.out.println("Qual é o valor recebido?");
        rec = in.nextDouble();

        System.out.println("Qual é o valor do produto?");
        preco = in.nextDouble();

        troco = rec - preco;

        if ( troco < 0 ) {
            // System.out.println("Falta pagar: " + troco * -1);
            System.out.println("Falta pagar: " + Math.abs(troco));
        } else if ( troco > 0 ) {
            System.out.println("O troco é: " + troco);
        }else {
            System.out.println("Não tem troco");
        }




    }
}