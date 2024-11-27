import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Qual é o codigo do produto?");
        int codigo = in.nextInt();

        switch (codigo){
            case 1:
                System.out.println("É um parafuso");
                break;

            case 2:
                System.out.println("É um parafuso");
                break;

            case 3:
                System.out.println("É um parafuso");
                break;

            default:
                System.out.println("O codigo nao existe!");
                break;
        }
    }
}