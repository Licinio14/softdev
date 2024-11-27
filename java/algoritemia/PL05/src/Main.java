import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        boolean vali = true;
        int menu = 0;

        do {
            System.out.println("\n\nQual o jogo que pretende jogar?\n|1 - Quente ou frio|\t|2 - Adivinha o numero|\t|3 - 21 Fósforos|\t|0 - Sair|");
            menu = in.nextInt();

            switch (menu) {
                case 0:
                    System.out.println("Saindo...");
                    vali = false;
                    break;
                case 1:
                    QuenteFrio(51);
                    break;
                case 2:
                    Adivinha();
                    break;
                case 3:
                    Fosforos();
                default:
                    System.out.println("Insira uma opção valida!!");
                    break;
            }

        } while (vali);


    }

    private static void Fosforos() {
        boolean vali = true;
        int menu = 0;

        do {
            System.out.println("\n\nQual o modo que pretende jogar?\n|1 - Sozinho|\t|2 - 2 Jogadores|\t|0 - Sair|");
            menu = in.nextInt();

            switch (menu) {
                case 0:
                    System.out.println("Saindo...");
                    vali = false;
                    break;
                case 1:
                    Sozinho(0);
                    break;
                case 2:
                    Sozinho(1);
                    break;
                default:
                    System.out.println("Insira uma opção valida!!");
                    break;
            }

        } while (vali);

    }

    private static void Sozinho(int multi) {
        int jogo = 21, resposta = 0, escolha = 0, ai = 0, max = 0;
        boolean vali = true, vali2 = true, acabou = false;

        if (multi != 1){
            System.out.println("Pretender:\n |1 - Jogar primeiro|\t|2 - Jogar em segundo|");
            escolha = in.nextInt();
        }


        do {
            // se o jogador sozinho quiser ser o segundo
            if (escolha == 2) {
                escolha = 0;
                ai = rnd.nextInt(1, 5);
                System.out.println("Total de fósforos: " + jogo);
                System.out.println("Computador: " + ai);
                jogo -= ai;
            }


            //escolha do jogador
            if (jogo <= 0) {

                if (multi == 1){
                    System.out.println("Parabens 2ª jogador, o 1ª jogador ficou com o ultimo fósforo");
                    break;
                }else{
                    System.out.println("Parabens, o computador ficou com o ultimo fósforo");
                    break;
                }

            } else {

                do {
                    if (multi == 1){
                        System.out.println("Jogador 1: ");
                    }
                    System.out.println("Total de fósforos: " + jogo);
                    System.out.println("Escolha uma opção entre 1 e 4");
                    System.out.println("Quantos deseja pegar?");
                    resposta = in.nextInt();

                    if (resposta > 0 && resposta <= 4) {
                        jogo -= resposta;
                        vali2 = false;
                    } else {
                        vali2 = true;
                    }

                } while (vali2);

            }


            if (multi == 1){
                //escolha segundo jogador
                if (jogo <= 0) {
                    System.out.println("Parabens 1ª jogador, o 2ª jogador ficou com o ultimo fósforo");
                    break;
                } else {

                    do {
                        System.out.println("Jogador 2: ");
                        System.out.println("Total de fósforos: " + jogo);
                        System.out.println("Escolha uma opção entre 1 e 4");
                        System.out.println("Quantos deseja pegar?");
                        resposta = in.nextInt();

                        if (resposta > 0 && resposta <= 4) {
                            jogo -= resposta;
                            vali2 = false;
                        } else {
                            vali2 = true;
                        }

                    } while (vali2);

                }

            }else{

                //escolha do computador
                if (jogo <= 0) {
                    System.out.println("Perdeste, ficas-te com o ultimo fósforo!");
                    vali = false;
                } else {
                        System.out.println("Total de fósforos: " + jogo);

                    if (jogo > 4){
                        ai = rnd.nextInt(1, 5);
                    }else {
                        max = jogo;
                        ai = rnd.nextInt(1, max + 1);
                    }

                    System.out.println("Computador: " + ai);
                    jogo -= ai;
                    if (jogo < 1){
                        System.out.println("Total de fósforos: " + 0);
                    }else {
                        System.out.println("Total de fósforos: " + jogo);
                    }

                }
            }



        } while (vali);

    }

    private static void Adivinha() {

        boolean vali = true;
        int menu = 0;

        do {
            System.out.println("\n\nQual o nivel que pretende jogar?\n|1 - Ajuda nivel facil|\t|2 - Ajuda nivel media e 3 tentativas|\t|3 - Ajuda dificil|\t|0 - Sair|");
            menu = in.nextInt();

            switch (menu) {
                case 0:
                    System.out.println("\n\nSaindo...\n");
                    vali = false;
                    break;
                case 1:
                    QuenteFrio(21);
                    break;
                case 2:
                    Ajuda2();
                    break;
                case 3:
                    Ajuda3();
                    break;
                default:
                    System.out.println("Insira uma opção valida!!");
                    break;
            }

        } while (vali);

    }

    private static void Ajuda3() {
        int numero = 0, resposta = 0, count = 1, conta = 0;
        numero = rnd.nextInt(1, 21);

        do {
            System.out.println("\nAdivivhe o número entre 1 e 20");
            System.out.println("Insira a " + count + "ª tentativa: ");
            resposta = in.nextInt();

            if (resposta > 0 && resposta < 21) {
                conta = numero - resposta;
                if (conta < 0) {
                    if (conta >= -2) {
                        System.out.println("Está perto! Ja tentou " + count + " vezes.");
                        count++;
                    } else if (conta >= -5) {
                        System.out.println("Não esta perto nem longe! Ja tentou " + count + " vezes.");
                        count++;
                    } else {
                        System.out.println("Está longe! Ja tentou " + count + " vezes.");
                        count++;
                    }
                } else if (conta > 0) {
                    if (conta <= 2) {
                        System.out.println("Está perto! Ja tentou " + count + " vezes.");
                        count++;
                    } else if (conta <= 5) {
                        System.out.println("Não esta perto nem longe! Ja tentou " + count + " vezes.");
                        count++;
                    } else {
                        System.out.println("Está longe! Ja tentou " + count + " vezes.");
                        count++;
                    }
                } else {
                    System.out.println("Parabens acertou na " + count + "ª tentativa.");
                    System.out.println("O número é: " + numero);
                }
            } else {
                System.out.println("Resposta fora dos valores aceites!");
            }

        } while (resposta != numero);

    }

    private static void Ajuda2() {
        int numero = 0, resposta = 0;
        numero = rnd.nextInt(1, 21);

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nAdivivhe o número entre 1 e 20");
            System.out.println("Tem 3 tentativas.");
            System.out.println("Insira a " + i + "ª tentativa: ");
            resposta = in.nextInt();

            if (i == 3) {
                System.out.println("Acabaram as 3 tentativas, mais sorte para a proxima.");
                System.out.println("O número era: " + numero);
            } else {
                if (resposta == numero) {

                    System.out.println("Parabens acertou na " + i + "ª tentativa.");
                    System.out.println("O número é: " + numero);
                    break;

                } else if (resposta < numero && resposta > 0) {

                    System.out.println("Tente um número maior. Tem " + (3 - i) + " tentativas.");

                } else if (resposta > numero && resposta < 21) {

                    System.out.println("Tente um número menor. Tem " + (3 - i) + " tentativas.");

                } else {
                    System.out.println("Resposta fora dos valores aceites!");
                }

            }


        }


    }

    private static void QuenteFrio(int max) {

        int numero = 0, resposta = 0, count = 1;
        numero = rnd.nextInt(1, max);

        do {
            System.out.println("\nAdivivhe o número entre 1 e " + (max - 1));
            System.out.println("Insira a " + count + "ª tentativa: ");
            resposta = in.nextInt();
            if (resposta == numero) {

                System.out.println("Parabens acertou na " + count + "ª tentativa.");
                System.out.println("O número é: " + numero);

            } else if (resposta < numero && resposta > 0) {

                System.out.println("Tente um número maior. Ja tentou " + count + " vezes.");
                count++;

            } else if (resposta > numero && resposta < 51) {

                System.out.println("Tente um número menor. Ja tentou " + count + " vezes.");
                count++;

            } else {
                System.out.println("Resposta fora dos valores aceites!");
            }

        } while (resposta != numero);

    }
}