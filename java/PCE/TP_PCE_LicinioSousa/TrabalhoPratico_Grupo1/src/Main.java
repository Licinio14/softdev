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
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String BLUE = "\033[0;34m";
    public static final String YELLOW = "\033[0;33m";
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
        do {
            System.out.println(GREEN + "\n\nBem-vindo ao EuroMilhões" + RESET);
            System.out.println("O que pretende fazer?\n|1 - Simular chave|\t|2 - Inserir Boletim|\t|3- Boletim automatico|\t|4 - Simulação|\t|0 - Sair|");
            try {
                in = new Scanner(System.in);
                resp = in.nextInt();
                switch (resp) {
                    case 0:
                        System.out.println(RED + "Terminando o programa!" + RESET);
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
                        //limpar o ecra primeiro
                        Clear();
                        //chamar a função para preencher o boletim automaticamente
                        PreencherChaveAutomatico();
                        break;
                    case 4:
                        //limpar o ecra primeiro
                        Clear();
                        //chamar a função para preencher o boletim automaticamente
                        SimilarPrimeiroPremio();
                        break;
                    default:
                        //limpar o ecra
                        Clear();
                        System.out.println("Insira uma opção valida!");
                        break;
                }
            } catch (InputMismatchException e) {
                //limpar o ecra
                Clear();
                System.out.println("Insira apenas números!");
            }
        } while (vali);


    }

    private static void SimilarPrimeiroPremio() {
        int contadordetentativas = 0, numeroescolhido = 0,  i = 0, countestrelas = 0, countnumeros = 0;
        boolean vali = true, vali2 = true;

        //limpar antigas chaves que possam existir
        LimparChavesAntigas();

        // preencher a chave pelo utilizador
        for (int j = 0; j < 7; j++) {

            //Mostra o boletim para facilitar a inserção
            MostrarBoletim(i);

            //executa se for a vez dos numeros
            if (j < 5) {
                //escolher os 5 numeros
                do {
                    System.out.println((countnumeros + 1) + "º numero?");
                    // verifica se insere apenas numeros
                    try {
                        //da reset ao scanner e pede o numero ao utilizador
                        in = new Scanner(System.in);
                        numeroescolhido = in.nextInt();
                        //valida se ta dentro dos parametros a resposta
                        if (numeroescolhido >= 1 && numeroescolhido <= 50) {
                            //verifica se ja escolheu o mesmo numero
                            if (chaveutilizador[0][i] == numeroescolhido || chaveutilizador[1][i] == numeroescolhido || chaveutilizador[2][i] == numeroescolhido || chaveutilizador[3][i] == numeroescolhido || chaveutilizador[4][i] == numeroescolhido) {
                                System.out.println("Nao pode repetir números!");
                            } else {
                                // atribui o numero caso seja diferente dos ja escolhidos
                                chaveutilizador[j][i] = numeroescolhido;
                                // termina o loop
                                vali = false;
                                //incrementa o contador
                                countnumeros++;
                            }
                        } else {
                            System.out.println("Escolha um número entre 1 e 50 inclusive!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Insira apenas números!");
                        ;
                    }

                } while (vali);
                // da reset a variavel do loop
                vali = true;
            }
            //executa se for a vez das estrelas
            else {
                //escolher as 2 estrelas
                do {
                    System.out.println((countestrelas + 1) + "º estrala?");
                    // verifica se insere apenas numeros
                    try {
                        in = new Scanner(System.in);
                        numeroescolhido = in.nextInt();

                        //valida se ta dentro dos parametros a resposta
                        if (numeroescolhido >= 1 && numeroescolhido <= 12) {
                            //verifica se ja escolheu o mesmo numero
                            if (chaveutilizador[5][i] == numeroescolhido || chaveutilizador[6][i] == numeroescolhido) {
                                System.out.println("Nao pode repetir números!");
                            } else {
                                // atribui o numero caso seja diferente dos ja escolhidos
                                chaveutilizador[j][i] = numeroescolhido;
                                // termina o loop
                                vali = false;
                                //incrementa o contador
                                countestrelas++;
                            }
                        } else {
                            System.out.println("Escolha um número entre 1 e 12 inclusive!");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Insira apenas números!");
                        ;
                    }

                } while (vali);
                // da reset a variavel do loop
                vali = true;
            }
        }


        System.out.println(GREEN + "Começando a simulação!" + RESET);

        do {

            //Cria a chave premiada
            SimualrChave();

            //comparar com a chave premiada
            int numacertados = 0, estacerdadas = 0;

            //verificar quantos acertou

                //testa os numeros
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (chaveutilizador[j][i] == premiada[k]) numacertados++;
                    }
                }
                //testa as estrelas
                for (int j = 5; j < 7; j++) {
                    for (int k = 5; k < 7; k++) {
                        if (chaveutilizador[j][i] == premiada[k]) estacerdadas++;
                    }
                }

                //Verifica quantos numeros acertou
                if (numacertados == 5 && estacerdadas == 2){
                    System.out.println(GREEN + "Acertou a " + contadordetentativas + "º tentativa" + RESET);
                    vali2 = false;
                }else {
                    contadordetentativas++;
                    if ((contadordetentativas % 5000000) == 0){
                        System.out.println(BLUE + "Já tentou " + contadordetentativas + " vezes!" + RESET);
                    }
                }



        }while (vali2);

    }

    private static void PreencherChaveAutomatico() {
        // criar ate 5 chaves aleatorias
        boolean vali = true;
        int numeroescolhido = 0, n1 = 0;
        totalchaves = 0;

        //limpa o array caso ja tenha chaves antigas
        LimparChavesAntigas();

        //cria uma chave premiada
        SimualrChave();


        //deixar o utilizador escolher quantas chaves quer preencher
        do {
            System.out.println("Quantas chaves pretende preencher?\n |1 - 5 chaves|\t\t\t|0 - Cancelar|");
            //verifica se o utilizador inserio apenas numeros
            try {
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

            } catch (InputMismatchException e) {
                System.out.println("Insira apenas números!!!");
            }
        } while (vali);
        //resetar a variavel
        vali = true;

        //preencher as chaves aleatoriamente
        for (int i = 0; i < totalchaves; i++) {

            // preencher a chave aleatoriamente
            for (int j = 0; j < 7; j++) {

                //executa se for a vez dos numeros
                if (j < 5) {
                    //escolher os 5 numeros

                    //vai buscar um numero aleatorio
                    numeroescolhido = rnd.nextInt(1, 51);

                    do {

                        //verifica se ja escolheu o mesmo numero
                        if (chaveutilizador[0][i] == numeroescolhido || chaveutilizador[1][i] == numeroescolhido || chaveutilizador[2][i] == numeroescolhido || chaveutilizador[3][i] == numeroescolhido || chaveutilizador[4][i] == numeroescolhido) {
                            //vai buscar um novo numero
                            numeroescolhido = rnd.nextInt(1, 51);
                        } else {
                            // atribui o numero caso seja diferente dos ja escolhidos
                            chaveutilizador[j][i] = numeroescolhido;
                            // termina o loop
                            vali = false;
                        }

                    } while (vali);
                    // da reset a variavel do loop
                    vali = true;
                }
                //executa se for a vez das estrelas
                else {
                    //escolher as 2 estrelas

                    //vai buscar um numero aleatorio
                    numeroescolhido = rnd.nextInt(1, 13);

                    do {

                        //verifica se ja escolheu o mesmo numero
                        if (chaveutilizador[5][i] == numeroescolhido || chaveutilizador[6][i] == numeroescolhido ) {
                            //vai buscar um novo numero
                            numeroescolhido = rnd.nextInt(1, 13);
                        } else {
                            // atribui o numero caso seja diferente dos ja escolhidos
                            chaveutilizador[j][i] = numeroescolhido;
                            // termina o loop
                            vali = false;
                        }

                    } while (vali);
                    // da reset a variavel do loop
                    vali = true;
                }
            }
        }

        //ordenar as chaves do utilizador
        for (int j = 0; j < totalchaves; j++) {

            // ordenar o array nos numeros
            for (int i = 0; i < 5 - 1; i++) {
                for (int a = i + 1; a < 5; a++) {
                    if (chaveutilizador[i][j] > chaveutilizador[a][j]) {
                        n1 = chaveutilizador[a][j];
                        chaveutilizador[a][j] = chaveutilizador[i][j];
                        chaveutilizador[i][j] = n1;
                    }
                }
            }

            // ordenar o array nas estrelas
            for (int i = 5; i < 7 - 1; i++) {
                for (int a = i + 1; a < 7; a++) {
                    if (chaveutilizador[i][j] > chaveutilizador[a][j]) {
                        n1 = chaveutilizador[a][j];
                        chaveutilizador[a][j] = chaveutilizador[i][j];
                        chaveutilizador[i][j] = n1;
                    }
                }
            }

        }

        //Mostra a chave premiada
        MostrarChavePremiada();

        //Verifica e mostra se o utilizador tem premio
        VerificarPremio();



    }

    private static void PreencherChave() {
        // o utilizador preenche ate 5 chaves e compara
        boolean vali = true;
        int n1, countnumeros = 0, countestrelas = 0, numeroescolhido = 0, estrelaescolhida = 0;
        totalchaves = 0;

        //limpa o array caso ja tenha chaves antigas
        LimparChavesAntigas();

        //cria uma chave premiada
        SimualrChave();


        //deixar o utilizador escolher quantas chaves quer preencher
        do {
            System.out.println("Quantas chaves pretende preencher?\n |1 - 5 chaves|\t\t\t|0 - Cancelar|");
            //verifica se o utilizador inserio apenas numeros
            try {
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

            } catch (InputMismatchException e) {
                System.out.println("Insira apenas números!!!");
            }
        } while (vali);
        //resetar a variavel
        vali = true;


        //Para o utilizador preencher as chaves
        for (int i = 0; i < totalchaves; i++) {

            //Informar o utilizador de qual é o boletim que esta a jogar
            System.out.println(BLUE + (i + 1) + "ª Boletim:\n" + RESET);

            // preencher a chave pelo utilizador
            for (int j = 0; j < 7; j++) {

                //Mostra o boletim para facilitar a inserção
                MostrarBoletim(i);

                //executa se for a vez dos numeros
                if (j < 5) {
                    //escolher os 5 numeros
                    do {
                        System.out.println((countnumeros + 1) + "º numero?");
                        // verifica se insere apenas numeros
                        try {
                            //da reset ao scanner e pede o numero ao utilizador
                            in = new Scanner(System.in);
                            numeroescolhido = in.nextInt();
                            //valida se ta dentro dos parametros a resposta
                            if (numeroescolhido >= 1 && numeroescolhido <= 50) {
                                //verifica se ja escolheu o mesmo numero
                                if (chaveutilizador[0][i] == numeroescolhido || chaveutilizador[1][i] == numeroescolhido || chaveutilizador[2][i] == numeroescolhido || chaveutilizador[3][i] == numeroescolhido || chaveutilizador[4][i] == numeroescolhido) {
                                    System.out.println("Nao pode repetir números!");
                                } else {
                                    // atribui o numero caso seja diferente dos ja escolhidos
                                    chaveutilizador[j][i] = numeroescolhido;
                                    // termina o loop
                                    vali = false;
                                    //incrementa o contador
                                    countnumeros++;
                                }
                            } else {
                                System.out.println("Escolha um número entre 1 e 50 inclusive!");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Insira apenas números!");
                            ;
                        }

                    } while (vali);
                    // da reset a variavel do loop
                    vali = true;
                }
                //executa se for a vez das estrelas
                else {
                    //escolher as 2 estrelas
                    do {
                        System.out.println((countestrelas + 1) + "º estrala?");
                        // verifica se insere apenas numeros
                        try {
                            in = new Scanner(System.in);
                            numeroescolhido = in.nextInt();

                            //valida se ta dentro dos parametros a resposta
                            if (numeroescolhido >= 1 && numeroescolhido <= 12) {
                                //verifica se ja escolheu o mesmo numero
                                if (chaveutilizador[5][i] == numeroescolhido || chaveutilizador[6][i] == numeroescolhido) {
                                    System.out.println("Nao pode repetir números!");
                                } else {
                                    // atribui o numero caso seja diferente dos ja escolhidos
                                    chaveutilizador[j][i] = numeroescolhido;
                                    // termina o loop
                                    vali = false;
                                    //incrementa o contador
                                    countestrelas++;
                                }
                            } else {
                                System.out.println("Escolha um número entre 1 e 12 inclusive!");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Insira apenas números!");
                            ;
                        }

                    } while (vali);
                    // da reset a variavel do loop
                    vali = true;
                }
            }

            //Mostra o boletim para facilitar a inserção
            MostrarBoletim(i);

            //dar indicação ao utilizador de que o boletim foi preenchido
            System.out.println(BLUE + "Boletim preenchido com sucesso!\n\n" + RESET);

            //resetar os counter para o proximo boletim
            countnumeros = 0;
            countestrelas = 0;
        }

        //ordenar as chaves do utilizador
        for (int j = 0; j < totalchaves; j++) {

            // ordenar o array nos numeros
            for (int i = 0; i < 5 - 1; i++) {
                for (int a = i + 1; a < 5; a++) {
                    if (chaveutilizador[i][j] > chaveutilizador[a][j]) {
                        n1 = chaveutilizador[a][j];
                        chaveutilizador[a][j] = chaveutilizador[i][j];
                        chaveutilizador[i][j] = n1;
                    }
                }
            }

            // ordenar o array nas estrelas
            for (int i = 5; i < 7 - 1; i++) {
                for (int a = i + 1; a < 7; a++) {
                    if (chaveutilizador[i][j] > chaveutilizador[a][j]) {
                        n1 = chaveutilizador[a][j];
                        chaveutilizador[a][j] = chaveutilizador[i][j];
                        chaveutilizador[i][j] = n1;
                    }
                }
            }

        }

        //Mostra a chave premiada
        MostrarChavePremiada();

        //Verifica e mostra se o utilizador tem premio
        VerificarPremio();


    }

    private static void LimparChavesAntigas() {
        //para garantir que as validações e os boletims mostrados funcionam direito
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                chaveutilizador[j][i] = 0;
            }
        }
    }

    private static void VerificarPremio() {
        int numacertados = 0, estacerdadas = 0;

        //obter o index para a chave a verificar
        for (int i = 0; i < totalchaves; i++) {
            //testa os numeros
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (chaveutilizador[j][i] == premiada[k]) numacertados++;
                }
            }
            //testa as estrelas
            for (int j = 5; j < 7; j++) {
                for (int k = 5; k < 7; k++) {
                    if (chaveutilizador[j][i] == premiada[k]) estacerdadas++;
                }
            }

            //Mostra as chaves do utilizador
            MostrarChaveUtilizador(i);

            //Verifica quantos numeros acertou
            switch (numacertados) {
                case 0:
                    System.out.println(RED + "A chave nao contem nenhum premio!" + RESET);
                    break;
                case 1:
                    if (estacerdadas == 2) {
                        System.out.println(GREEN + "Parabens! Ganhou o 11ª prémio no valor de 7.77€" + RESET);
                    } else {
                        System.out.println(RED + "A chave nao contem nenhum premio!" + RESET);
                    }
                    break;
                case 2:
                    if (estacerdadas == 0) {
                        System.out.println(GREEN + "Parabens! Ganhou o 13ª prémio no valor de 4.31€" + RESET);
                    } else if (estacerdadas == 1) {
                        System.out.println(GREEN + "Parabens! Ganhou o 12ª prémio no valor de 6.44€" + RESET);
                    } else if (estacerdadas == 2) {
                        System.out.println(GREEN + "Parabens! Ganhou o 8ª prémio no valor de 16.73€" + RESET);
                    }
                    break;
                case 3:
                    if (estacerdadas == 0) {
                        System.out.println(GREEN + "Parabens! Ganhou o 10ª prémio no valor de 10.41€" + RESET);
                    } else if (estacerdadas == 1) {
                        System.out.println(GREEN + "Parabens! Ganhou o 9ª prémio no valor de 13.51€" + RESET);
                    } else if (estacerdadas == 2) {
                        System.out.println(GREEN + "Parabens! Ganhou o 6ª prémio no valor de 69.80€" + RESET);
                    }
                    break;
                case 4:
                    if (estacerdadas == 0) {
                        System.out.println(GREEN + "Parabens! Ganhou o 7ª prémio no valor de 46.93€" + RESET);
                    } else if (estacerdadas == 1) {
                        System.out.println(GREEN + "Parabens! Ganhou o 5ª prémio no valor de 153.68€" + RESET);
                    } else if (estacerdadas == 2) {
                        System.out.println(GREEN + "Parabens! Ganhou o 4ª prémio no valor de 1300.64€" + RESET);
                    }
                    break;
                case 5:
                    if (estacerdadas == 0) {
                        System.out.println(GREEN + "Parabens! Ganhou o 3ª prémio no valor de 78150.96€" + RESET);
                    } else if (estacerdadas == 1) {
                        System.out.println(GREEN + "Parabens! Ganhou o 2ª prémio no valor de 184395.87€" + RESET);
                    } else if (estacerdadas == 2) {
                        System.out.println(GREEN + "Parabens! Ganhou o 1ª prémio no valor de 50000000.00€" + RESET);
                    }
                    break;
            }

        }
    }

    private static void MostrarChaveUtilizador(int index) {

        System.out.println(BLUE + "\nA sua chave n" + (index + 1) + "ª é:" + RESET);

        //quebra de linha
        System.out.println();

        for (int i = 0; i < 7; i++) {
            if (i < 5) System.out.printf(BLUE + "| %2d |" + RESET, chaveutilizador[i][index]);
            else System.out.printf(YELLOW + "{ %2d }" + RESET, chaveutilizador[i][index]);

        }
        //quebra de linha
        System.out.println();

    }

    private static void MostrarBoletim(int index) {
        //quebra de linha
        System.out.println();
        //mostrar boletim dos numeros de 10 em 10
        for (int i = 1; i < 51; i++) {
            //mostra os numeros ja escolhidos a vermelho
            if (i == chaveutilizador[0][index] || i == chaveutilizador[1][index] || i == chaveutilizador[2][index] || i == chaveutilizador[3][index] || i == chaveutilizador[4][index]) {
                System.out.printf(RED + "| %2d |" + RESET, i);
            } else {
                System.out.printf(GREEN + "| %2d |" + RESET, i);
            }
            // quebra de linha a cada 10
            if ((i % 10) == 0) {
                System.out.println();
            }

        }

        for (int i = 1; i < 13; i++) {
            //mostra as estrelas ja escolhidas a vermelho
            if (i == chaveutilizador[5][index] || i == chaveutilizador[6][index]) {
                System.out.printf(RED + "| %2d |" + RESET, i);
            } else {
                System.out.printf(YELLOW + "{ %2d }" + RESET, i);
            }
            // quebra de linha a cada 6
            if ((i % 6) == 0) {
                System.out.println();
            }

        }
        //quebra de linha
        System.out.println();
    }

    private static void MostrarChavePremiada() {
        //quebra de linha
        System.out.println();

        System.out.println("\nA chave premiada é:");
        for (int i = 0; i < premiada.length; i++) {
            if (i < 5) System.out.printf(BLUE + "| %2d |" + RESET, premiada[i]);
            else System.out.printf(YELLOW + "{ %2d }" + RESET, premiada[i]);

        }

        //quebra de linha
        System.out.println();
    }

    private static void SimualrChave() {
        // vou precisar de 5 numeros diferentes de 1 - 50 e 2 de 1 - 12
        boolean vali = true;
        int n1;

        for (int i = 0; i < 7; i++) {

            if (i < 5) {
                // gera um numero aleatorio
                int temp = rnd.nextInt(1, 51);

                //verifica se o numero nao é repetido
                do {
                    if (premiada[0] == temp || premiada[1] == temp || premiada[2] == temp || premiada[3] == temp || premiada[4] == temp)
                        temp = rnd.nextInt(1, 51);
                    else vali = false;
                } while (vali);

                // atribui o valor
                premiada[i] = temp;

                // reseta a variavel para os loops
                vali = true;
            } else {
                // gera um numero aleatorio
                int temp = rnd.nextInt(1, 13);

                //verifica se o numero nao é repetido
                do {
                    if (premiada[5] == temp || premiada[6] == temp) temp = rnd.nextInt(1, 13);
                    else vali = false;
                } while (vali);

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