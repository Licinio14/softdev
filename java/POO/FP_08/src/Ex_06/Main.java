package Ex_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean vali = true;
        int x = 0, y = 0, op = 0;

        Calculadora calc = new Calculadora();

        do{
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Adiçao");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("0 - Sair");

            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Digite o 1ª valor: ");
                    x = in.nextInt();
                    System.out.println("Digite o 2ª valor: ");
                    y = in.nextInt();
                    calc.Adicao(x,y);
                    break;
                case 2:
                    System.out.println("Digite o 1ª valor: ");
                    x = in.nextInt();
                    System.out.println("Digite o 2ª valor: ");
                    y = in.nextInt();
                    calc.Subtracao(x,y);
                    break;
                case 3:
                    System.out.println("Digite o 1ª valor: ");
                    x = in.nextInt();
                    System.out.println("Digite o 2ª valor: ");
                    y = in.nextInt();
                    calc.Multiplicacao(x,y);
                    break;
                case 4:
                    System.out.println("Digite o 1ª valor: ");
                    x = in.nextInt();
                    System.out.println("Digite o 2ª valor: ");
                    y = in.nextInt();
                    calc.Divisao(x,y);
                    break;
                case 0:
                    vali = false;
                    break;
                default:
                    System.out.println("Escolha invalida");
            }

        }while(vali);
    }
}
