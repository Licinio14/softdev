import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // ler nome do automovel, ler preço de fabrica, calcular o preço final (45% impostos e 28% do revendedor), mostrar o nome e preço final

        Scanner in = new Scanner(System.in);

        double fabrica, imp, reve, preco;

        System.out.println("Qual é o nome do automovel?");
        String nome = in.nextLine();
        System.out.println("Qual é o preço de fabrica?");
        fabrica = in.nextDouble();

        imp = fabrica * 0.45;
        reve = fabrica * 0.28;
        preco = fabrica + imp + reve;

        System.out.println("O valor do " + nome + " é " + preco + " €");


    }
}