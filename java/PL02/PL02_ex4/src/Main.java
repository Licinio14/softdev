import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Pretende-se lendo a base e a altura de um triângulo calcular a sua área
        Scanner in = new Scanner(System.in);

        double base, altura, area;
        System.out.println("Qual é a altura do triângulo? ");
        altura = in.nextDouble();

        System.out.println("Qual é a base do triângulo? ");
        base = in.nextDouble();

        area = base * altura / 2;


        System.out.println("A area do triângulo é: " + area);

    }
}