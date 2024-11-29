import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    static String nome = "estevalortavazio";
    static int contacorrent = 100, cuslotaria = 5, cusraspadinha = 2, saldovali = 0;
    static Random rnd = new Random();


    public static void main(String[] args) throws InterruptedException {
        int menu;
        boolean vali = true;

        if (nome.equals("estevalortavazio")) {
            System.out.println("Bem vindo");
        } else {
            System.out.println("Bem vindo " + nome + ".");
        }

        do {

            if (nome.equals("estevalortavazio")) {
                System.out.println("Qual jogo pretende jogar?\t\t\t\t\t|Conta corrente: " + contacorrent + "|");
                System.out.println("|1 - Lotaria| \t |2 - Raspadinhas| \t |3 - conta| \t |0 - sair|");
            } else {
                System.out.println(nome + " qual jogo pretende jogar?\t\t\t\t\t|Conta corrente: " + contacorrent + "|");
                System.out.println("|1 - Lotaria| \t |2 - Raspadinhas| \t |3 - conta| \t |0 - sair|");
            }
            menu = in.nextInt();

            switch (menu) {
                case 0:
                    Clear();
                    System.out.println("Obrigado por jogar\n\n");
                    Carregar(20);
                    vali = false;
                    break;
                case 1:
                    Verificar(5);
                    if (saldovali == 1) {
                        Lotaria();
                    } else {
                        System.out.println("\nNão tem saldo suficiente para jogar! Carregue primeiro!");
                    }
                    break;
                case 2:
                    Verificar(2);
                    if (saldovali == 1) {
                        Raspadinha();
                    } else {
                        System.out.println("\nNão tem saldo suficiente para jogar! Carregue primeiro!");
                    }
                    break;
                case 3:
                    Conta();
                    break;
                default:
                    System.out.println("Insira uma opção valida!");
                    break;

            }
        } while (vali);


    }

    private static void Verificar(int teste) {
        if (contacorrent >= teste) {
            saldovali = 1;
        } else {
            saldovali = 0;
        }


    }

    private static void Conta() throws InterruptedException {
        int levantamento = 0, deposito = 0, resposta = 0;
        boolean vali = true;


        do {
            Clear();

            if (nome.equals("estevalortavazio")) {
                System.out.println("Bem vindo a sua conta.\t\t\t\t\t\t\tConta corrente: " + contacorrent + "€");
                System.out.println("|1 - Levantamento|\t|2 - Depositos|\t|3 - Inserir Nome|\t|0 - Voltar|");
            } else {
                System.out.println("Bem vindo " + nome + ".\t\t\t\t\t\t\tConta corrente: " + contacorrent + "€");
                System.out.println("|1 - Levantamento|\t|2 - Depositos|\t|3 - Inserir Nome|\t|0 - Voltar|");
            }


            resposta = in.nextInt();
            switch (resposta) {
                case 0:
                    vali = false;
                    break;
                case 1:
                    Levantamentos();
                    break;
                case 2:
                    Depositos();
                    break;
                case 3:
                    Nome();
                    break;
                default:
                    System.out.println("Insira um resposta valida!");
                    break;

            }

        } while (vali);

        Clear();


    }

    private static void Nome() throws InterruptedException {
        in = new Scanner(System.in);
        System.out.println("Qual é o seu nome?");
        nome = in.nextLine();


        if (nome.equals("estevalortavazio")) {
            System.out.println("Nome adicionado com sucesso!");
            Carregar(20);
        } else {
            System.out.println("Nome alterado com sucesso!");
            Carregar(20);
        }


    }

    private static void Depositos() throws InterruptedException {
        int resposta = 0;
        Clear();
        System.out.println("Qual é o valor que deseja depositar? Valor Maximo de 10000€. Insira 0 para cancelar" + "\t\t\t\t Conta corrente: " + contacorrent + "€");
        resposta = in.nextInt();

        if (resposta > 0 && resposta <= 10000) {
            System.out.println("Deposito bem sucedido!");
            contacorrent += resposta;
            Carregar(30);
        } else if (resposta > 10000) {
            System.out.println("Valor de deposito maximo atingido!");
            Carregar(30);
        } else if (resposta < 0) {
            System.out.println("Não pode devantar valores negativos");
            Carregar(30);
        }
    }

    private static void Levantamentos() throws InterruptedException {
        int resposta = 0;
        Clear();
        System.out.println("Qual é o valor que deseja levantar? Insira 0 para cancelar" + "\t\t\t\t Conta corrente: " + contacorrent + "€");
        resposta = in.nextInt();

        if (resposta > 0 && resposta <= contacorrent) {
            System.out.println("Levantamento bem sucedido!");
            contacorrent -= resposta;
            Carregar(30);
        } else if (resposta > contacorrent) {
            System.out.println("Não tem dinheiro suficiente para o levantamento");
            Carregar(30);
        } else if (resposta < 0) {
            System.out.println("Não pode levantar valores negativos");
            Carregar(30);
        }

    }

    private static void Raspadinha() throws InterruptedException {
        int menu = 0;
        boolean vali = true;

        do {
            Verificar(2);
            if (saldovali == 0) {
                System.out.println("\nNão tem saldo suficiente para jogar! Carregue primeiro!");
                return;
            } else {


                Clear();
                System.out.println("Escolha o tipo de raspadinha:\t\t\t\t|Conta corrente: " + contacorrent + "|");
                System.out.println("|1 - Raspadina tipo 1| \t |2 - Raspadinha tipo 2| \t |0 - sair|");
                menu = in.nextInt();

                switch (menu) {
                    case 0:
                        vali = false;
                        Clear();
                        break;
                    case 1:
                        Raspadinha1();
                        break;
                    case 2:
                        Raspadinha2();
                        break;
                    case 3:

                        break;
                    default:
                        System.out.println("Insira uma opção valida!");
                        break;

                }
            }
        } while (vali);

    }

    private static void Raspadinha1() throws InterruptedException {
        int resposta = 0, valor = 0, soma = 0, count = 0;
        int[][] premio = new int[8][2];

        //retira o valor da raspadinha a conta
        contacorrent -= cusraspadinha;

        //limpar ecra anterior
        Clear();
        //esolher o numero principal
        resposta = rnd.nextInt(1, 11);
        System.out.println("\nNumero principal: |" + resposta + "| ");

        //escolher os numeros premiados
        for (int i = 1; i <= 5; i++) {
            premio[i][0] = rnd.nextInt(1, 11);

        }
        //escolher os valores de cada numero
        for (int i = 1; i <= 5; i++) {
            valor = rnd.nextInt(1, 6);

            premio[i][1] = switch (valor) {
                case 1 -> 1;
                case 2 -> 5;
                case 3 -> 10;
                case 4 -> 50;
                case 5 -> 100;
                default -> 25;
            };

        }

        //compara os numeros e soma os premios ganhos
        for (int i = 1; i <= 5; i++) {
            if (resposta == premio[i][0]) {
                soma += premio[i][1];
                count++;
            }

        }

        for (int i = 1; i <= 5; i++) {
            System.out.print("---\t|" + premio[i][0] + "| = " + "|" + premio[i][1] + "€|\t");
        }
        System.out.println("\n\n");


        if (count == 0) {
            System.out.println("Infelizmente nao tem numeros iguais");
        } else {
            System.out.println("Parabens!!! Ganhou " + soma + "€");
            contacorrent += soma;
        }

        Carregar(80);
        Clear();

    }

    private static void Raspadinha2() throws InterruptedException {
        int resposta = 0, valor = 0, soma = 0, count = 0;
        int[][] premio = new int[15][2];

        //retira o valor da raspadinha a conta
        contacorrent -= cusraspadinha;

        //limpar ecra anterior
        Clear();
        //esolher o numero principal
        resposta = rnd.nextInt(1, 11);
        System.out.println("\nNumero principal: |" + resposta + "| ");

        //escolher os numeros premiados
        for (int i = 1; i <= 9; i++) {
            premio[i][0] = rnd.nextInt(1, 11);

        }
        //escolher os valores de cada numero
        for (int i = 1; i <= 9; i++) {

            premio[i][1] = rnd.nextInt(1, 11);

        }

        //compara os numeros e soma os premios ganhos
        for (int i = 1; i <= 9; i++) {
            if (resposta == premio[i][0]) {
                count++;
                soma += premio[i][1];
            }
        }

        for (int i = 1; i <= 9; i++) {
            System.out.print("\t|" + premio[i][0] + "| = " + "|" + premio[i][1] + "€|\t\t");
        }
        System.out.println("\n");


        if (count < 3) {
            System.out.println("Infelizmente nao tem premio");
        } else {
            System.out.println("Parabens!!! Ganhou " + soma + "€");
            contacorrent += soma;
        }

        Carregar(80);

    }

    private static void Lotaria() throws InterruptedException {
        boolean vali2 = true;
        int resposta = 0, premio = 0;
        Clear();

        if (nome.equals("estevalortavazio")) {
            System.out.println("Bem vindo a Lotaria:\n");
            System.out.println("Prémios:\n1ª - 1000€\t2ª - 500€\t3ª - 250€");
        } else {
            System.out.println("Bem vindo a Lotaria " + nome + ":\n");
            System.out.println("Prémios:\n1ª - 1000€\t2ª - 500€\t3ª - 250€");
        }


        // verifica se o numero escolhido é valido, se for deduz o custo da loteria na conta corrente
        do {
            System.out.println("Escolha o numero desejado ente 1000 e 9999");
            resposta = in.nextInt();
            if (resposta >= 1000 && resposta <= 9999) {
                contacorrent -= cuslotaria;
                vali2 = false;
            } else {
                System.out.println("Resposta invalida!!!\n");
            }

        } while (vali2);

        //escolhendo o numero premiado
        premio = rnd.nextInt(1000, 10000);

        System.out.println("O número premiado é " + premio);

        if (resposta == premio) {
            System.out.println("PARABENS!!! Tem o número premiado! Ganhou 1000€\n");
            contacorrent += 1000;
        } else if ((resposta % 1000) == (premio % 1000)) {
            System.out.println("PARABENS!!! Ganho o 2ª Premio! Ganhou 500€\n");
            contacorrent += 500;
        } else if ((resposta % 100) == (premio % 100)) {
            System.out.println("PARABENS!!! Ganho o 3ª Premio! Ganhou 250€\n");
            contacorrent += 250;
        } else {
            System.out.println("Bilhete não premiado!\n");
        }

        Carregar(80);
        Clear();
    }

    private static void Carregar(int tempo) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.print("||");
            Thread.sleep(tempo);
        }
    }

    private static void Clear() {
        for (int i = 0; i < 80; i++) {
            System.out.println("\n");
        }
    }
}