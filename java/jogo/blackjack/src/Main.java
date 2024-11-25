import com.sun.security.jgss.GSSUtil;

import java.util.concurrent.ThreadLocalRandom;
import javax.xml.transform.Source;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int[] baralho = new int[417];
    static int countcartas = 1;

    public static void main(String[] args) throws InterruptedException, IOException {
        int resposta = 0;

        do {
            System.out.println("Bem-Vindo ao BlackJack\n1 - Jogar\n2 - sair");
            resposta = sc.nextInt();

            switch (resposta) {
                case 1:
                    Blackjack();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Resposta invalida! Insira uma opção valida!");
            }
        } while (resposta != 2);

        System.out.println("Obrigado por jogar. By Licinio Sousa");
        for (int i = 0; i < 100; i++) {
            System.out.print(".");
            Thread.sleep(20);

        }


    }

    private static void Blackjack() throws InterruptedException {
        boolean validacao = true, validacao2 = true;

        CriarBaralho();
        Clear();
        System.out.println("Vamos iniciar a rodada\nBaralhando as cartas\n");

        for (int i = 0; i < 150; i++) {
            System.out.print("_");
            Thread.sleep(10);

        }
        System.out.println("\n");


        do {
            int resposta, somadealer = 0, somajogador = 0, carta = 0, countjogador = 1, countdealer = 3, parar = 0, dealerparar = 0;
            int[] cartasjogador = new int[20];
            int[] cartasdealer = new int[20];


            // primeiras duas cartas do dealer
            do {
                carta = ThreadLocalRandom.current().nextInt(0, 417);

                if (carta == 0 || carta == 417) {
                    validacao2 = true;
                } else {
                    cartasdealer[1] = baralho[carta];
                    if (cartasdealer[1] == 0) {
                        validacao2 = true;
                    } else if (cartasdealer[1] > 0 && cartasdealer[1] < 11) {
                        if (cartasdealer[1] == 1) {
                            baralho[carta] = 0;
                            somadealer = 11;
                            validacao2 = false;
                        } else {
                            baralho[carta] = 0;
                            somadealer = cartasdealer[1];
                            validacao2 = false;
                        }

                    }

                }
            } while (validacao2);

            do {
                carta = ThreadLocalRandom.current().nextInt(0, 417);

                if (carta == 0 || carta == 417) {
                    validacao2 = true;
                } else {
                    cartasdealer[2] = baralho[carta];
                    if (cartasdealer[2] == 0) {
                        validacao2 = true;
                    } else if (cartasdealer[2] > 0 && cartasdealer[2] < 11) {
                        if (cartasdealer[2] == 1) {
                            if ((somadealer + 11) < 22) {
                                baralho[carta] = 0;
                                somadealer += 11;
                                validacao2 = false;
                            }
                        } else {
                            baralho[carta] = 0;
                            somadealer += cartasdealer[2];
                            validacao2 = false;
                        }
                    }

                }
            } while (validacao2);

            // Mostra apenas uma carta
            System.out.println("Cartas do dealer: ");
            System.out.println(" |*| " + cartasdealer[2]);

            do {


                // cartas do jogador
                do {
                    carta = ThreadLocalRandom.current().nextInt(0, 417);

                    if (carta == 0 || carta == 417) {
                        validacao2 = true;
                    } else {
                        cartasjogador[countjogador] = baralho[carta];
                        if (cartasjogador[countjogador] == 0) {
                            validacao2 = true;
                        } else if (cartasjogador[countjogador] > 0 && cartasjogador[countjogador] < 11) {
                            baralho[carta] = 0;
                            somajogador += cartasjogador[countjogador];
                            validacao2 = false;
                            countjogador++;
                        }

                    }

                } while (validacao2);

                switch (countjogador) {
                    case 2:
                        System.out.print(cartasjogador[countjogador - 1]);
                        parar = 1;
                        break;
                    case 3:
                        System.out.print(" + " + cartasjogador[countjogador - 1]);
                        System.out.println("\nContagem atual: " + somajogador);
                        do {
                            System.out.println("1 - Pedir mais 1 carta  || 2 - Parar ");
                            parar = sc.nextInt();
                        } while (parar != 1 && parar != 2);

                        break;
                    default:
                        System.out.println("Minhas cartas: ");
                        for (int i = 1; i <= countjogador - 1; i++) {
                            System.out.print(" |" + cartasjogador[i] + "| ");
                        }

                        if (somajogador > 21) {
                            System.out.println("Contagem atual: " + somajogador);
                            System.out.println("Passou de 21!! Perdeu o jogo!!");
                            parar = 2;
                        } else if (somajogador == 21) {
                            System.out.println("Contagem atual: " + somajogador);
                            parar = 2;

                        }else {
                            System.out.println("Contagem atual: " + somajogador);
                            do {
                                System.out.println("1 - Pedir mais 1 carta  || 2 - Parar ");
                                parar = sc.nextInt();
                            } while (parar != 1 && parar != 2);

                        }

                        break;
                }


            } while (parar == 1);

            if (somajogador < 21) {

                // Mostra as cartas do dealer
                System.out.println("Cartas do dealer: ");
                System.out.print("\n |" + cartasdealer[1] + "| |" + cartasdealer[2] + "| ");


                if (somadealer <= 16) {
                    do {

                        //pedir nova carta para o dealer

                        carta = ThreadLocalRandom.current().nextInt(0, 417);

                        if (carta == 0 || carta == 417) {
                            validacao2 = true;
                        } else {
                            cartasdealer[countdealer] = baralho[carta];
                            if (cartasdealer[countdealer] == 0) {
                                break;
                            } else if (cartasdealer[countdealer] > 0 && cartasdealer[2] < 11) {
                                if (cartasdealer[countdealer] == 1) {
                                    if ((somadealer + 11) < 22) {
                                        baralho[carta] = 0;
                                        somadealer += 11;
                                    } else {
                                        baralho[carta] = 0;
                                        somadealer += 1;
                                    }
                                    countdealer++;
                                    System.out.println("|" + cartasdealer[countdealer - 1] + "| ");
                                } else {
                                    baralho[carta] = 0;
                                    somadealer += cartasdealer[countdealer];
                                    countdealer++;
                                    System.out.println("|" + cartasdealer[countdealer - 1] + "| ");
                                }
                            }

                        }
                        if (somadealer >= 17) {
                            dealerparar = 1;
                        } else {
                            dealerparar = 0;
                        }
                    } while (dealerparar == 0);


                }
                if (somadealer >= 17 && somadealer < 22) {
                    //mostrar final do jogo
                    System.out.println("A contagem do dealer é: " + somadealer);
                    if (somadealer > somajogador) {
                        System.out.println("O dealer ganhou, mais sorte para a proxima!");
                    } else if (somadealer < somajogador) {
                        System.out.println("Ganhas-te ao dealer, PARABENS!!! Ganhaste o jogo!!!");
                    }
                    dealerparar = 1;
                } else {
                    System.out.println("A contagem do dealer é: " + somadealer);
                    System.out.println("O dealer arrebentou! PARABENS!!! Ganhaste o jogo!!!");
                }
            }

            System.out.println("Jogar novamente?\n 1 - Sim\n 2 - Nao");
            resposta = sc.nextInt();
            if (resposta == 2) {
                validacao = false;
            }


        } while (validacao);

        Clear();


    }

    private static void Clear() {

        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

    }

    private static void CriarBaralho() {


        // fazer um for para inserir 8 baralhos
        for (int b = 1; b <= 8; b++) {
            //adicionar os 4 ases
            for (int a = 1; a <= 4; a++) {

                baralho[countcartas] = 1;
                countcartas++;


            }
            // adicionar as cartas numericas de 2 a 9
            for (int a = 2; a <= 9; a++) {

                for (int c = 0; c < 4; c++) {

                    baralho[countcartas] = a;
                    countcartas++;
                }


            }
            // adicionar as cartas valor 10 (16 total)
            for (int a = 1; a <= 16; a++) {

                baralho[countcartas] = 10;
                countcartas++;


            }


        }

        countcartas = 1;


    }


}