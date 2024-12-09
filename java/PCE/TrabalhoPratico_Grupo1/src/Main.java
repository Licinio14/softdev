import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //variaveis globais
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    //array para a chave premiada
    static int[] premiada = new int[7];
    //array para o utilizador poder inserir ate 5 chaves
    static int[][] chaveutilizador = new int[7][5];

    static int totalchaves = 0;

    //variaveis para mudar a cor do texto
    public static final String RED = "\033[0;31m";    // Red
    public static final String GREEN = "\033[0;32m";  // Green
    public static final String BLUE = "\033[0;34m";   // Blue
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {

        /* O Euromilhões é um jogo de sorte ou azar no qual o jogador deve preencher uma chave composta por 5 números de 1 a
            50 e 2 estrelas (números) de 1 a 12. Crie uma aplicação que permita ao utilizador:
            1. Simular um sorteio (sortear uma chave vencedora que deve ser apresentada ao utilizador de forma ordenada).
            2. Criar um boletim com 1 a 5 chaves (inseridas pelo utilizador) e comparar com a chave vencedora desse sorteio.
            3. Criar um boletim com 1 a 5 chaves (criadas aleatoriamente) e comparar com a chave vencedora desse sorteio.
            4. Simular quantas vezes seria necessário jogar (sempre com a mesma chave) de forma a conseguir ganhar o 1º
            prémio (5 números e 2 estrelas)*/
        // variaveis
        boolean vali = true;
        int resp = 0;

        //limpar o ecra
        Clear();

        // loop do menu principal
        do{
            System.out.println(GREEN + "\n\nBem-vindo ao EuroMilhões" + RESET);
            System.out.println("O que pretende fazer?\n|1 - Simular chave|\t|2 - Inserir Boletim|\t|3- Boletim automatico|\t|4 - Simulação|\t|0 - Sair|");
            try{
                in = new Scanner(System.in);
                resp = in.nextInt();
                switch (resp){
                    case 0:
                        System.out.println("Terminando o programa!");
                        //termina o loop
                        vali = false;
                        break;
                    case 1:
                        //limpar o ecra primeiro
                        Clear();
                        //chamar a função para simular a chave
                        SimualrChave();
                        //mostra a chave premiada
                        MostrarChavePremiada();
                        break;
                    case 2:
                        //limpar o ecra primeiro
                        Clear();
                        //chamar a função para preencher o boletim
                        PreencherChave();

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        //limpar o ecra
                        Clear();
                        System.out.println("Insira uma opção valida!");
                        break;
                }
            }catch (InputMismatchException e){
                //limpar o ecra
                Clear();
                System.out.println("Insira apenas números!");
            }
        }while (vali);




    }

    private static void PreencherChave() {
        // o utilizador preenche ate 5 chaves e compara
        boolean vali = true;
        int n1;
        totalchaves = 0;


        //deixar o utilizador escolher quantas chaves quer preencher
        do {
            System.out.println("Quantas chaves pretende preencher?\n |1 - 5 chaves|\t\t\t|0 - Cancelar|");
            //verifica se o utilizador inserio apenas numeros
            try{
                in = new Scanner(System.in);
                totalchaves = in.nextInt();
                // se inserio dentro dos parametros fecha o loop
                if (totalchaves <= 5 && totalchaves >= 1) vali = false;
                //se inserir 0 limpa o ecra e retorna ao menu principal
                else if (totalchaves == 0) {
                    Clear();
                    return;
                }
                //se inserio fora dos parametros continua o loop
                else System.out.println("Insira uma opção valida!");

            }catch (InputMismatchException e){
                System.out.println("Insira apenas números!!!");
            }
        }while (vali);
        //resetar a variavel
        vali = true;



        //Para o utilizador preencher as chaves
        for (int i = 0; i < totalchaves; i++) {


            // preencher a chave pelo utilizador
            for (int j = 0; j < 7; j++) {
                //Mostra o boletim para facilitar a inserção
                MostrarBoletim(i);



            }
        }



        for (int i = 0; i < 7; i++) {

            if (i < 5){
                // gera um numero aleatorio
                int temp = rnd.nextInt(1,51);

                //verifica se o numero nao é repetido
                do {
                    if (premiada[0] == temp || premiada[1] == temp || premiada[2] == temp || premiada[3] == temp || premiada[4] == temp) temp = rnd.nextInt(1,51);
                    else vali = false;
                }while (vali);

                // atribui o valor
                premiada[i] = temp;

                // reseta a variavel para os loops
                vali = true;
            }else {
                // gera um numero aleatorio
                int temp = rnd.nextInt(1,13);

                //verifica se o numero nao é repetido
                do {
                    if (premiada[5] == temp || premiada[6] == temp ) temp = rnd.nextInt(1,13);
                    else vali = false;
                }while (vali);

                // atribui o valor
                premiada[i] = temp;

                // reseta a variavel para os loops
                vali = true;
            }

        }



        // ordenar o array nos numeros
        for (int i = 0; i < 5 - 1; i++) {
            for (int a = i + 1; a < 5; a++) {
                if (premiada[i] > premiada[a]) {
                    n1 = premiada[a];
                    premiada[a] = premiada[i];
                    premiada[i] = n1;
                }
            }
        }

        // ordenar o array nas estrelas
        for (int i = 5; i < 7 - 1; i++) {
            for (int a = i + 1; a < 7; a++) {
                if (premiada[i] > premiada[a]) {
                    n1 = premiada[a];
                    premiada[a] = premiada[i];
                    premiada[i] = n1;
                }
            }
        }
    }

    private static void MostrarBoletim(int index) {
        //mostrar boletim dos numeros de 10 em 10
        for (int i = 1; i < 51; i++) {

            System.out.printf(GREEN + "| %2d |"+ RESET, i);

            if ((i % 10) == 0){
                System.out.println();
            }

        }

        for (int i = 1; i < 13; i++) {

            System.out.printf(GREEN + "{ %2d }" + RESET, i);

            if ((i % 6) == 0){
                System.out.println();
            }

        }
    }

    private static void MostrarChavePremiada() {
        System.out.println("\nA chave premiada é:");
        for (int i = 0; i < premiada.length; i++) {
            if (i < 5) System.out.print("|" + premiada[i] + "|\t");
            else System.out.print("{" + premiada[i] + "}\t");

        }
    }

    private static void SimualrChave() {
        // vou precisar de 5 numeros diferentes de 1 - 50 e 2 de 1 - 12
        boolean vali = true;
        int n1;

        for (int i = 0; i < 7; i++) {

            if (i < 5){
                // gera um numero aleatorio
                int temp = rnd.nextInt(1,51);

                //verifica se o numero nao é repetido
                do {
                    if (premiada[0] == temp || premiada[1] == temp || premiada[2] == temp || premiada[3] == temp || premiada[4] == temp) temp = rnd.nextInt(1,51);
                    else vali = false;
                }while (vali);

                // atribui o valor
                premiada[i] = temp;

                // reseta a variavel para os loops
                vali = true;
            }else {
                // gera um numero aleatorio
                int temp = rnd.nextInt(1,13);

                //verifica se o numero nao é repetido
                do {
                    if (premiada[5] == temp || premiada[6] == temp ) temp = rnd.nextInt(1,13);
                    else vali = false;
                }while (vali);

                // atribui o valor
                premiada[i] = temp;

                // reseta a variavel para os loops
                vali = true;
            }

        }



        // ordenar o array nos numeros
        for (int i = 0; i < 5 - 1; i++) {
            for (int a = i + 1; a < 5; a++) {
                if (premiada[i] > premiada[a]) {
                    n1 = premiada[a];
                    premiada[a] = premiada[i];
                    premiada[i] = n1;
                }
            }
        }

        // ordenar o array nas estrelas
        for (int i = 5; i < 7 - 1; i++) {
            for (int a = i + 1; a < 7; a++) {
                if (premiada[i] > premiada[a]) {
                    n1 = premiada[a];
                    premiada[a] = premiada[i];
                    premiada[i] = n1;
                }
            }
        }


    }

    // função para "limpar" o ecra
    private static void Clear() {
        //escreve linhas em branco para limpar o ecra
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}