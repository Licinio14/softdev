import com.sun.source.tree.IfTree;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int lado1, lado2, lado3, resposta1, resposta2, resposta3, verificacao1, som1, som2, som3;


        verificacao1 = 1;
        resposta1 = 0;
        resposta2 = 0;
        resposta3 = 0;
        lado1 = 0;
        lado2 = 0;
        lado3 = 0;


        while (verificacao1 == 1) {

            while (resposta1 == 0) {
                System.out.println("Tamanho do primeiro lado?");
                lado1 = in.nextInt();
                if (lado1 <= 0) {
                    System.out.println("Insira um numero maior que zero!");
                    resposta1 = 0;
                } else {
                    resposta1 = 1;
                }
            }

            while (resposta2 == 0) {
                System.out.println("Tamanho do segundo lado?");
                lado2 = in.nextInt();
                if (lado2 <= 0) {
                    System.out.println("Insira um numero maior que zero!");
                    resposta2 = 0;
                } else {
                    resposta2 = 1;
                }
            }

            while (resposta3 == 0) {
                System.out.println("Tamanho do terceiro lado?");
                lado3 = in.nextInt();
                if (lado3 <= 0) {
                    System.out.println("Insira um numero maior que zero!");
                    resposta3 = 0;
                } else {
                    resposta3 = 1;
                }
            }

            som1 = lado1 + lado2;
            som2 = lado2 + lado3;
            som3 = lado3 + lado1;


            if (lado1 > som2) {
                System.out.println("O primeiro lado nao pode ser maior que a soma dos outros dois!");
                verificacao1 = 1;
                resposta1 = 0;
            } else if (lado2 > som3) {
                System.out.println("O segundo lado nao pode ser maior que a soma dos outros dois!");
                verificacao1 = 1;
                resposta2 = 0;
            } else if (lado3 > som1) {
                System.out.println("O terceiro lado nao pode ser maior que a soma dos outros dois!");
                verificacao1 = 1;
                resposta3 = 0;
            } else {
                verificacao1 = 0;
            }


        }

        if (lado1 == lado2 && lado1 == lado3) {
            System.out.println("O triangulo é Equilátero");
        } else if (lado1 == lado2 || lado1 == lado3) {
            System.out.println("O triangulo é Isósceles");
        } else if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
            System.out.println("O triandulo é Escaleno");
        } else if (lado2 == lado3) {
            System.out.println("O triangulo é Isósceles");
        } else {
            System.out.println("Ocorreu um erro no programa!");
        }


    }
}