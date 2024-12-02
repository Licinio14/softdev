import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static int linha = 0, colunas = 0;


    public static void main(String[] args) {
        int op = 0;

        while (op == 0) {
            System.out.print("|1-ex01|");
            System.out.print("\t|2-ex02|");
            System.out.print("\t|3-ex03|");
            System.out.print("\t|4-ex04|");
            System.out.print("\t|5-ex05|");
            System.out.print("\t|0-Sair|");
            System.out.println();
            op = in.nextInt();

            switch (op) {
                case 0:
                    return;
                case 1:
                    Clear();
                    Ex1();
                    break;
                case 2:
                    Clear();
                    Ex2();
                    break;
                case 3:
                    Clear();
                    Ex3();
                    break;
                case 4:
                    Clear();
                    Ex4();
                    break;
                case 5:
                    Clear();
                    Ex5();
                    break;
                default:
                    System.out.println("Opção invalida:");
            }


        }


    }

    private static void Ex5() {
        //Acrescente a possibilidade de o utilizador calcular a soma e a média dos valores do array por linha, por coluna e
        //no total.

        System.out.println("Quantas linhas quer no array");
        linha = in.nextInt();
        System.out.println("Quantas colunas quer no array");
        colunas = in.nextInt();

        int[][] arraw = new int[linha][colunas];

        for (int b = 0; b < linha; b++) {
            for (int a = 0; a < colunas; a++) {
                System.out.println("Insira o valor para a posisao: " + b + " : " + a);
                arraw[b][a] = in.nextInt();

            }
        }

        for (int b = 0; b < linha; b++) {
            for (int a = 0; a < colunas; a++) {

                System.out.print("| " + arraw[b][a] + " |\t");

            }
            System.out.println();
        }

        boolean vali = true;
        int op = 0;

        do {

            System.out.print("|1-Somar|");
            System.out.print("\t|2-Media|");
            System.out.print("\t|0-Sair|");
            System.out.println();
            op = in.nextInt();

            switch (op) {
                case 0:
                    vali = false;
                    Clear();
                    break;
                case 1:
                    Clear();
                    Somar(arraw);
                    break;
                case 2:
                    Clear();
                    Media(arraw);
                    break;
                default:
                    System.out.println("Opção invalida:");
                    break;
            }

        } while (vali);


    }

    private static void Media(int[][] arraw) {
        boolean vali = true;
        int op = 0;
        double soma = 0;
        double media = 0;

        do {

            System.out.print("|1-Media por linha|");
            System.out.print("\t|2-Media por coluna|");
            System.out.print("\t|2-Media de tudo|");
            System.out.print("\t|0-Sair|");
            System.out.println();
            op = in.nextInt();

            switch (op) {
                case 0:
                    vali = false;
                    Clear();
                    break;
                case 1:
                    Clear();

                    for (int b = 0; b < linha; b++) {
                        for (int a = 0; a < colunas; a++) {

                            soma += arraw[b][a];

                        }
                        media = soma / linha;
                        System.out.println("A media da " + b + "ª linha é: " + media);
                        soma = 0;
                    }


                    break;
                case 2:
                    Clear();
                    for (int b = 0; b < colunas; b++) {
                        for (int a = 0; a < linha; a++) {

                            soma += arraw[a][b];

                        }
                        media = soma / linha;
                        System.out.println("A media da " + b + "ª linha é: " + media);
                        soma = 0;
                    }

                    break;
                case 3:
                    int total = 0;
                    for (int b = 0; b < linha; b++) {
                        for (int a = 0; a < colunas; a++) {

                            soma += arraw[b][a];
                            total++;

                        }
                    }
                    media = soma / total;
                    System.out.println("A media de tudo é: " + media);
                    soma = 0;
                    break;
                default:
                    System.out.println("Opção invalida:");
                    break;
            }

        } while (vali);


    }

    private static void Somar(int[][] arraw) {
        boolean vali = true;
        int op = 0, soma = 0;

        do {

            System.out.print("|1-Somar por linha|");
            System.out.print("\t|2-Somar por coluna|");
            System.out.print("\t|2-Somar tudo|");
            System.out.print("\t|0-Sair|");
            System.out.println();
            op = in.nextInt();

            switch (op) {
                case 0:
                    vali = false;
                    Clear();
                    break;
                case 1:
                    Clear();

                    for (int b = 0; b < linha; b++) {
                        for (int a = 0; a < colunas; a++) {

                            soma += arraw[b][a];

                        }
                        System.out.println("A soma da " + b + "ª linha é: " + soma);
                        soma = 0;
                    }


                    break;
                case 2:
                    Clear();

                    for (int b = 0; b < linha; b++){
                        for (int a = 0; a < colunas; a++){
                            if (a == (colunas - 1)){
                                soma += arraw[b][a];
                                System.out.println("A soma da " + b + "ª coluna é: " + soma);
                                soma = 0;
                            }else {
                                soma += arraw[b][a];
                            }
                        }

                    }

                    break;
                case 3:
                    for (int b = 0; b < linha; b++) {
                        for (int a = 0; a < colunas; a++) {

                            soma += arraw[b][a];

                        }
                    }
                    System.out.println("A soma de tudo é: " + soma);
                    soma = 0;
                    break;
                default:
                    System.out.println("Opção invalida:");
                    break;
            }

        } while (vali);


    }

    private static void Ex4() {
        //Altere a aplicação anterior permitindo ao utilizador escolher o número de linhas e colunas do array.
        int linha = 0, colunas = 0;

        System.out.println("Quantas linhas quer no array");
        linha = in.nextInt();
        System.out.println("Quantas colunas quer no array");
        colunas = in.nextInt();


        int[][] arraw = new int[linha][colunas];
        for (int b = 0; b < linha; b++) {
            for (int a = 0; a < colunas; a++) {
                System.out.println("Insira o valor para a posisao: " + b + " : " + a);
                arraw[b][a] = in.nextInt();

            }
        }

        for (int b = 0; b < linha; b++) {
            for (int a = 0; a < colunas; a++) {

                System.out.print("| " + arraw[b][a] + " |\t");

            }
            System.out.println();
        }

    }

    private static void Ex3() {
        //Altere a aplicação anterior permitindo ao utilizador preencher o array com os valores que pretender.

        int[][] arraw = new int[3][3];
        for (int b = 0; b < 3; b++) {
            for (int a = 0; a < 3; a++) {
                System.out.println("Insira o valor para a posisao: " + b + " : " + a);
                arraw[b][a] = in.nextInt();

            }
        }

        for (int b = 0; b < 3; b++) {
            for (int a = 0; a < 3; a++) {

                System.out.print("| " + arraw[b][a] + " |\t");

            }
            System.out.println();
        }

    }

    private static void Ex2() {
        //Faça um programa que guarde um array multidimensional de 3x3 com números aleatórios e o apresente no ecrã.
        int[][] arraw = new int[3][3];
        for (int b = 0; b < 3; b++) {
            for (int a = 0; a < 3; a++) {

                arraw[b][a] = rnd.nextInt(1, 101);

            }
        }

        for (int b = 0; b < 3; b++) {
            for (int a = 0; a < 3; a++) {

                System.out.print("| " + arraw[b][a] + " |\t");

            }
            System.out.println();
        }

    }

    private static void Ex1() {
        //Crie um programa que utilize um array multidimensional que simule a tabuada de 10x10. Deve utilizar ciclos para
        //preenchimento do array e aquando da execução da aplicação escrever a todo o array.


        System.out.println("quantas linhas quer?");
        int linha = in.nextInt();
        System.out.println("quantas colunas quer?");
        int coluna = in.nextInt();

        int[][] tabuada = new int[linha][coluna];

        for (int b = 0; b < linha; b++) {
            for (int a = 0; a < coluna; a++) {

                tabuada[b][a] = (b + 1) * (a + 1);

            }
        }


        for (int b = 0; b < linha; b++) {
            for (int a = 0; a < coluna; a++) {

                System.out.print("| " + tabuada[b][a] + " |\t");

            }
            System.out.println();
        }


    }

    private static void Clear() {
        for (int i = 0; i < 70; i++) {
            System.out.println();
        }
    }
}