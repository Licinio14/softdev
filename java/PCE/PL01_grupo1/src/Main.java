import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    static String[] ex1 = new String[10];
    static int maxlistaalunos = 0;
    static Random rnd = new Random();


    public static void main(String[] args) {

        int op = 0;

        while (op == 0) {
            System.out.print("|1-ex01|");
            System.out.print("\t|2-ex02|");
            System.out.print("\t|3-ex03|");
            System.out.print("\t|4-ex04|");
            System.out.print("\t|5-ex05|");
            System.out.print("\t|6-ex06|");
            System.out.print("\t|7-ex07|");
            System.out.print("\t|8-ex08|");
            System.out.print("\t|0-Sair|");
            System.out.println();
            op = in.nextInt();

            switch (op) {
                case 0:

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
                case 6:
                    Clear();
                    Ex6();
                    break;
                case 7:
                    Clear();
                    Ex7();
                    break;
                case 8:
                    Clear();
                    Ex8();
                    break;
                default:
                    System.out.println("Opção invalida:");
            }


        }


    }

    private static void Ex8() {
        //Altere o exercício anterior ordenando os vetores.

        boolean vali = true, inserido = false;
        int menu = 0, maxnomes = 0;
        String[] vetor = new String[10];
        char[] vetor2 = new char[10];
        String[] vetor1ordenar = new String[10];
        char[] vetor2ordenar = new char[10];
        String testeletras = "abcdefghijklmnopqrstuvwxyz"; // 26

        do {
            System.out.println("|1 - Inserir nomes|\t|2 - Listar nomes|\t|3 - Listar letras|\t|0 - Sair|");
            menu = in.nextInt();
            switch (menu) {
                case 0:
                    vali = false;
                    break;
                case 1:
                    Clear();
                    do {
                        System.out.println("quantos nomes quer inserir?");
                        maxnomes = in.nextInt();
                        if (maxnomes <= 0) {
                            System.out.println("Escolha um valor superior a 0");
                        }
                    } while (maxnomes <= 0);

                    vetor = new String[maxnomes];
                    vetor2 = new char[maxnomes];
                    vetor1ordenar = new String[maxnomes];
                    vetor2ordenar = new char[maxnomes];
                    in = new Scanner(System.in);

                    for (int i = 0; i < maxnomes; i++) {
                        System.out.println("Insira o " + (i + 1) + "ª nome:");
                        vetor[i] = in.nextLine();
                        vetor2[i] = vetor[i].charAt(0);
                    }
                    inserido = true;
                    break;
                case 2:
                    if (inserido) {
                        /*ordena apenas a primeira letra
                        int count = 0;
                        for (int a = 0; a < 26;a++){

                                for (int i = 0; i < maxnomes; i++){
                                    if (vetor[i].charAt(0) == testeletras.charAt(a)){
                                        vetor1ordenar[count] = vetor[i];
                                        count++;
                                    }
                                }

                        }*/


                        //ordenar arrays
                        Arrays.sort(vetor);
                        for (int i = 0; i < maxnomes; i++) {
                            //System.out.println(vetor1ordenar[i]);
                            System.out.println(vetor[i]);
                        }
                    } else {
                        System.out.println("Ainda nao foram inseridos nomes!");
                    }
                    break;
                case 3:
                    if (inserido) {
                        /*ordena apenas a primeira letra
                        int count = 0;
                        for (int a = 0; a < 26;a++){
                            for (int i = 0; i < maxnomes; i++){
                                if (vetor2[i] == testeletras.charAt(a)){
                                    vetor2ordenar[count] = vetor2[i];
                                    count++;
                                }
                            }
                        }*/

                        //ordenar arrays
                        Arrays.sort(vetor2);
                        for (int i = 0; i < maxnomes; i++) {
                            //System.out.println(vetor2ordenar[i]);
                            System.out.println(vetor2[i]);
                        }
                    } else {
                        System.out.println("Ainda nao foram inseridos nomes!");
                    }
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (vali);
    }

    private static void Ex7() {
        // Faça um programa que peça ao utilizador um conjunto de nomes. Sempre que o utilizador insere um nome deve
        //  inserir num outro vetor a 1ª letra de cada nome. Permita ao utilizador escrever o conteúdo de cada vetor. Sugere-se a utilização de um menu.
        boolean vali = true, inserido = false;
        int menu = 0, maxnomes = 0;
        String[] vetor = new String[10];
        char[] vetor2 = new char[10];

        do {

            do {
                System.out.println("|1 - Inserir nomes|\t|2 - Listar nomes|\t|3 - Listar letras|\t|0 - Sair|");
                try {
                    menu = in.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros");
                    in = new Scanner(System.in);
                } //catch (Exception e) {
                    //tenta apanhar de uma forma variada
                //}
            }while (menu != 0 && menu != 1 && menu != 2);

            switch (menu) {
                case 0:
                    vali = false;
                    break;
                case 1:
                    Clear();
                    do {
                        System.out.println("quantos nomes quer inserir?");
                        maxnomes = in.nextInt();
                        if (maxnomes <= 0) {
                            System.out.println("Escolha um valor superior a 0");
                        }
                    } while (maxnomes <= 0);

                    vetor = new String[maxnomes];
                    vetor2 = new char[maxnomes];
                    in = new Scanner(System.in);

                    for (int i = 0; i < maxnomes; i++) {
                        System.out.println("Insira o " + (i + 1) + "ª nome:");
                        vetor[i] = in.nextLine();
                        vetor2[i] = vetor[i].charAt(0);
                    }
                    inserido = true;
                    break;
                case 2:
                    if (inserido) {
                        for (int i = 0; i < maxnomes; i++) {
                            System.out.println(vetor[i]);
                        }
                    } else {
                        try {
                            System.out.println("Ainda nao foram inseridos nomes!");
                        }catch (NullPointerException e){
                            System.out.println("Array ainda nao preenchido");
                        }
                    }
                    break;
                case 3:
                    if (inserido) {
                        for (int i = 0; i < maxnomes; i++) {
                            System.out.println(vetor2[i]);
                        }
                    } else {
                        System.out.println("Ainda nao foram inseridos nomes!");
                    }
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (vali);


    }

    private static void Ex6() {
        //Faça um programa que peça ao utilizador um conjunto de nomes e os guarda num vetor. De seguida sorteie uma
        //posição do vetor e escreva o nome que está nessa posição.
        String nome;
        int maxnomes = 0;

        do {
            System.out.println("quantos nomes quer inserir?");
            maxnomes = in.nextInt();
            if (maxnomes <= 0) {
                System.out.println("Escolha um valor superior a 0");
            }
        } while (maxnomes <= 0);

        String[] vetor = new String[maxnomes];
        in = new Scanner(System.in);

        for (int i = 0; i < maxnomes; i++) {
            System.out.println("Insira o " + (i + 1) + "ª nome: ");
            vetor[i] = in.nextLine();
        }

        int sorte = rnd.nextInt(maxnomes);
        System.out.println("O nomer sorteado é: " + vetor[sorte]);


    }

    private static void Ex5() {
        //Faça um programa que ordene de forma crescente e decrescente um vetor. Sugere-se pesquisa na internet pelo
        //tópico: “java bubble sort”.
        int[] vetor = new int[10];
        int num;

        for (int i = 0; i < 10; i++) {
            vetor[i] = rnd.nextInt(1, 11);
        }
        System.out.print("Array: ");
        for (int i = 0; i < 10; i++) {
            System.out.print("|" + vetor[i] + "|\t");
        }

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int a = i + 1; a < vetor.length; a++) {
                if (vetor[i] > vetor[a]) {
                    num = vetor[a];
                    vetor[a] = vetor[i];
                    vetor[i] = num;
                }
            }
        }

        System.out.print("\nArray crescente: ");
        for (int i = 0; i < 10; i++) {
            System.out.print("|" + vetor[i] + "|\t");
        }


        //Arrays.sort(vetor, );

        System.out.print("\nArray decrescente: ");
        for (int i = 9; i >= 0; i--) {
            System.out.print("|" + vetor[i] + "|\t");
        }


    }

    private static void Ex4() {
        //Faça um programa que utilize uma estrutura de repetição para ler 50 números armazenando-os em um vetor e
        //calcule e exiba a média aritmética deles. Em seguida o programa deve apresentar todos os valores armazenados
        //no vetor que sejam menores que a média.
        int[] repeticao = new int[50];
        double media = 0;


        for (int i = 0; i < 50; i++) {
            //System.out.println("Insira o " + (i+1) + "ª numero: ");
            //repeticao[i] = in.nextInt();
            repeticao[i] = rnd.nextInt(1, 101);
            media += repeticao[i];
        }
        media /= 50;
        System.out.println("A media é: " + media);
        System.out.println("Os números menores que a media sao:\n");

        for (int i = 0; i < 50; i++) {
            if (repeticao[i] < media) {
                System.out.print("|" + (repeticao[i]) + "|\t");
            }

        }


    }

    private static void Ex3() {
        //Faça um programa que receba 10 valores inteiros e os coloque em um vetor. Em seguida exiba-os em ordem
        //inversa à ordem de entrada.
        boolean vali = true;
        int[] valores = new int[10];


        for (int i = 0; i < 10; i++) {
            System.out.println("Insira o " + (i + 1) + "ª:");
            valores[i] = in.nextInt();
        }


        for (int i = 9; i >= 0; i--) {
            System.out.println(valores[i]);
        }


    }

    private static void Ex2() {
        // Faça um programa que guarde num vetor os nomes de pelo menos 10 alunos da turma. Deve permitir ao
        // utilizador ao inserir o número do aluno (índice do vetor) indicar qual o nome do mesmo.
        int resposta = 0;
        boolean vali = true, vali2 = true, vali3 = true;

        do {
            System.out.println("|1 - Inserir alunos|\t\t\t|2 - Ver alunos|\t\t\t|0 - Sair|");
            resposta = in.nextInt();
            if (resposta == 1) {
                do {
                    System.out.println("Quantos alunos quer inserir? |Min: 1|\t|Max: 10|");
                    resposta = in.nextInt();
                    if (resposta < 1 || resposta > 10) {
                        System.out.println("Resposta invalida");
                    } else {
                        vali2 = false;
                    }
                } while (vali2);
                Clear();
                maxlistaalunos = resposta;
                InserirAlunos(maxlistaalunos);
            } else if (resposta == 2) {
                do {
                    System.out.println("Quantos alunos quer ver? |1 - Todos|\t|2 -Apenas 1|");
                    resposta = in.nextInt();
                    if (resposta != 1 && resposta != 2) {
                        System.out.println("Resposta invalida");
                    } else {
                        vali2 = false;
                    }
                } while (vali2);
                if (resposta == 1) {
                    Clear();
                    VerAlunos();
                } else {
                    if (maxlistaalunos != 0) {
                        do {
                            System.out.println("Qual é o id do aluno que pretende ver? |1| -> |10|");
                            resposta = in.nextInt();

                            if (resposta < 1 || resposta > maxlistaalunos) {
                                System.out.println("Resposta invalida");
                            } else {
                                vali3 = false;
                            }
                        } while (vali3);

                        System.out.println("É o aluno: " + ex1[resposta - 1]);
                    } else {
                        System.out.println("Ainda nao exitem alunos inseridos");

                    }


                }


            } else if (resposta == 0) {
                vali = false;
            } else {
                System.out.println("Resposta invalida!");
            }
        } while (vali);


    }

    private static void VerAlunos() {
        if (maxlistaalunos < 1) {
            System.out.println("Ainda nao foram inseridos alunos na lista");
        } else {
            for (int i = 0; i < maxlistaalunos; i++) {
                System.out.println("Aluno " + (i + 1) + " é o " + ex1[i]);
            }
        }


    }

    private static void InserirAlunos(int max) {
        in = new Scanner(System.in);
        String resposta;
        boolean vali = true;

        for (int i = 0; i < max; i++) {
            System.out.println("Insira o nome do " + (i + 1) + "ª aluno: ");
            ex1[i] = in.nextLine();
        }
    }

    private static void Clear() {
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
    }

    private static void Ex1() {


        double[] notas = new double[3];

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Insira uma nota");
            notas[i] = in.nextDouble();
        }

        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        double media = soma / notas.length;
        System.out.println("A media é: " + media);

    }
}