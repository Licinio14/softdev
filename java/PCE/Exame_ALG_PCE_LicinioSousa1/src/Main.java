import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static ArrayList<String> compras = new ArrayList<>();

    //variaveis para mudar a cor do texto
    static final String RED = "\033[0;31m";
    static final String GREEN = "\033[0;32m";
    static final String BLUE = "\033[0;34m";
    static final String YELLOW = "\033[0;33m";
    static final String RESET = "\033[0m";

    public static void main(String[] args) {
        int escolha = 0;
        boolean vali = true;

        //menu para escolher o exercicio
        do {
            System.out.println(BLUE + "\nQual é o exercicio que pretente executar?" + RED + " |0 - Sair|" + RESET);
            System.out.println(BLUE + "|1 - ex1|\t|2 - ex2|\t|3 - ex3|\t|4 - ex4|");
            System.out.println("|5 - ex5|\t|6 - ex6|\t|7 - ex7|\t|8 - ex8|" + RESET);
            try {
                //resetar o scanner
                in = new Scanner(System.in);
                escolha = in.nextInt();
                switch (escolha) {
                    case 0:
                        //limpar o ecra
                        Clear();
                        System.out.println(RED + "Terminando o programa!" + RESET);
                        vali = false;
                        break;
                    case 1:
                        //limpar o ecra
                        Clear();
                        //chamar o ex1
                        Ex1();
                        break;
                    case 2:
                        //limpar o ecra
                        Clear();
                        //chamar o ex2
                        Ex2();
                        break;
                    case 3:
                        //limpar o ecra
                        Clear();
                        //chamar o ex3
                        Ex3();
                        break;
                    case 4:
                        //limpar o ecra
                        Clear();
                        //chamar o ex4
                        Ex4();
                        break;
                    case 5:
                        //limpar o ecra
                        Clear();
                        //chamar o ex5
                        Ex5();
                        break;
                    case 6:
                        //limpar o ecra
                        Clear();
                        //chamar o ex6
                        Ex6();
                        break;
                    case 7:
                        //limpar o ecra
                        Clear();
                        //chamar o ex7
                        Ex7();
                        break;
                    case 8:
                        //limpar o ecra
                        Clear();
                        //chamar o ex8
                        Ex8();
                        break;
                    default:
                        System.out.println("Insira uma opção valida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira apenas números!");
            }


        } while (vali);


    }

    private static void Ex8() {
        int random = 0, resposta = 0, contador = 0;
        boolean vali = true;

        //gera o numero aleatorio
        random = rnd.nextInt(1, 51);

        //ciclo para efetuar as tentativas
        do {
            System.out.println("Escolha um numero entre 1 e 50 inclusive");
            try{
                //resetar o scanner
                in = new Scanner(System.in);
                resposta = in.nextInt();
                if (resposta > 0 && resposta < 51){
                    if (resposta < random){
                        System.out.println(BLUE + "Tente um número maior" + RESET);
                        contador++;
                    }else if (resposta > random){
                        System.out.println(BLUE + "Tente um número menor" + RESET);
                        contador++;
                    }else {
                        contador++;
                        System.out.println(GREEN + "Parabens, acertou na tentativa: " + contador);
                        vali = false;
                    }
                }else {
                    System.out.println(RED + "Insira um valor dentro dos parametros!" + RESET);
                }
            }catch (InputMismatchException e){
                System.out.println(RED + "Insira apenas números!!!" + RESET);
            }
        }while (vali);


    }

    private static void Ex7() {
        int quantidade = 0, num1 = 0, num2 = 1, num3 = 0;
        boolean vali = true;

        do{
            System.out.println(BLUE + "\nQuantos números pretende ver?" + RED + "\t 0 - Sair" + RESET);
            try{
                //reset ao scanner
                in = new Scanner(System.in);
                quantidade = in.nextInt();
                if (quantidade == 0){
                    //termina o ciclo
                    vali = false;
                } else if (quantidade > 0) {
                    //ciclo para mostrar os numeros
                    for (int i = 0; i < quantidade; i++) {
                        //faz a conta e substitui os numeros
                        if (i == 0){
                            System.out.print(GREEN + "| " + num1 + " |\t" );
                        } else if (i == 1) {
                            System.out.print(GREEN + "| "+ num2 +" |\t" );
                        } else {
                            num3 = num1 + num2;
                            System.out.print(GREEN + "| " + num3 + " |\t" );
                            num1 = num2;
                            num2 = num3;
                        }

                    }
                    //reseta as variaveis para a proxima jogada
                    num1 = 0;
                    num2 = 1;
                }else {
                    System.out.println(RED + "Insira números positivos!");
                }
            }catch (InputMismatchException e){
                System.out.println(RED + "Insira apenas números!");
            }
        }while (vali);



    }

    private static void Ex6() {
        boolean vali = true;
        int valor = 0;

        do {
            System.out.println(BLUE + "Insira um numero entre 0 e 100, que seja par!" + RESET);
            //valida se inserio apenas numeros
            try{
                //reset ao scanner
                in = new Scanner(System.in);
                valor = in.nextInt();
                //vlida se a resposta esta dentro dos parametros
                if (valor > 0 && valor < 5 ){
                    //verifica se é par ou nao
                    if ((valor % 2) == 0){
                        System.out.println(GREEN + "Não existe valores a serem apresentados!" + RESET);
                        vali = false;
                    }else {
                        System.out.println(RED + "Insira um valor par!" + RESET);
                    }
                } else if (valor >= 5 && valor <= 100) {
                    //verifica se é par ou nao
                    if ((valor % 2) == 0){
                        //ciclo para mostrar os numeros
                        for (int i = 0; i <= valor; i++) {
                            //verifica se é multiplo de 5
                            if ((i % 5) == 0){
                                System.out.print(GREEN + "| " + i + " |" + RESET);
                            }
                        }
                        vali = false;
                    }else {
                        System.out.println(RED + "Insira um valor par!" + RESET);
                    }
                }else {
                    System.out.println(RED + "Insira um valor valido" + RESET);
                }

            }catch (InputMismatchException e){
                System.out.println(RED + "Insira apenas números!!!");
            }
        }while (vali);


    }

    private static void Ex5() {
        boolean vali = true;
        int menu = 0;

        //ciclo para o menu
        do {
            System.out.println(GREEN + "Lista de Compras" + RESET);
            System.out.println(BLUE + "|1 - Adicionar|\t|2 - Editar|\t|3 - Eliminar|\t|4 - Mostrar lista|\t|0 - Sair|" + RESET);
            //valida se inserio apenas numeros
            try{
                //reset do scanner
                in = new Scanner(System.in);
                menu = in.nextInt();
                //valida a escolha
                switch (menu){
                    case 0:
                        System.out.println(RED + "Saindo" + RESET);
                        vali = false;
                        break;
                    case 1:
                        //limpa a tela
                        Clear();
                        //inserir item na lista
                        Ex5Inserir();
                        break;
                    case 2:
                        //limpa a tela
                        Clear();
                        //valida se a lista nao esta vazia
                        if (compras.size() == 0){
                            System.out.println(RED + "A lista encontra-se vazia!" + RESET);
                        }else {
                            //Editar items
                            Ex5Editar();
                        }

                        break;
                    case 3:
                        //limpa a tela
                        Clear();
                        //valida se a lista nao esta vazia
                        if (compras.size() == 0){
                            System.out.println(RED + "A lista encontra-se vazia!" + RESET);
                        }else {
                            //eliminar items
                            Ex5eliminar();
                        }
                        break;
                    case 4:
                        //limpa a tela
                        Clear();
                        //valida se a lista nao esta vazia
                        if (compras.size() == 0){
                            System.out.println(RED + "A lista encontra-se vazia!" + RESET);
                        }else {
                            //mostrar items
                            Ex5MostrarLista();
                        }
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(RED + "Insira apenas números!" + RESET);
            }
        }while (vali);


    }

    private static void Ex5eliminar() {
        int index = 0, max = compras.size();

        //Mostra a lista
        Ex5MostrarLista();

        System.out.println(BLUE + "Qual é o item que pretende eliminar? 1 - "+ max+ RED + "\tInsira 0 para cancelar" + RESET);
        try{
            index = in.nextInt();
            //baixa o index por mostrar index + 1 na lista
            index--;
            //valida a escolha
            if (index == -1){
                System.out.println(RED + "Cancelando" + RESET);
            } else if (index >= 0 && index <= max) {
                //elimina da lista
                compras.remove(index);
                //informa o utilizador
                System.out.println(GREEN + "Item eliminado com sucesso!" + RESET);
            }else {
                System.out.println(RED + "Insira uma opção valida!" + RESET);
            }
        }catch (InputMismatchException e){
            System.out.println(RED + "Insira apenas números!" + RESET);
        }
    }

    private static void Ex5Editar() {
        int index = 0, max = compras.size();
        //Mostra a lista
        Ex5MostrarLista();

        System.out.println(BLUE + "Qual é o item que pretende editar? 1 - " + max + RED + "\tInsira 0 para cancelar!" + RESET);
        try{
            index = in.nextInt();
            //diminui o index por usar index + 1 ao apresentar a lista
            index--;
            //valida a escolha
            if (index == -1){
                System.out.println(RED + "Cancelando" + RESET);
            } else if ( index >= 0 && index <= max) {
                System.out.println(BLUE + "Qual é o novo item?" + RESET);
                //reset ao scanner
                in = new Scanner(System.in);
                //altera o valor
                compras.set(index, in.nextLine());
                //informa o sucesso
                System.out.println(GREEN + "Item adicionado com sucesso!" + RESET);
            }else {
                System.out.println(RED + "Insira um valor dentro dos parametros!" + RESET);
            }



        }catch (InputMismatchException e){
            System.out.println(RED + "Insira apenas números" + RESET);
        }

    }

    private static void Ex5Inserir() {
        System.out.println(BLUE + "Qual é o item que pretende adicionar?" + RESET);
        //reset ao scanner
        in = new Scanner(System.in);
        compras.add(in.nextLine());
        System.out.println(GREEN + "Item adicionado com sucesso!" + RESET);
    }

    private static void Ex5MostrarLista() {
        for (int i = 0; i < compras.size(); i++) {
            System.out.println((i + 1) + "ª: " + compras.get(i));
        }
    }

    private static void Ex4() {
        int[] numeros = new int[5];
        int resposta = 0, count = 0;
        boolean vali = true;

        //ciclo para pedir 5 numeros
        for (int i = 0; i < 5; i++) {
            System.out.println(YELLOW + "Digite o " + (i + 1) + "ª número: " + RESET);
            //valida se inserio apenas numeros
            try{
                //guarda a resposta no array
                numeros[i] = in.nextInt();
            }catch (InputMismatchException e){
                System.out.println(RED + "Insira apenas números!!!" + RESET);
                //caso de erro diminui o i
                i--;
            }
        }

        //ciclo para o utilizador poder verificar se o numero esta no array
        do{
            System.out.println(BLUE + "Qual é o número para verificar se esta no array?\t" + RED + "Escreva uma letra para sair" + RESET);
            try{
                resposta = in.nextInt();
                //ciclo para verificar todo o array
                for (int i = 0; i < numeros.length; i++) {
                    if (numeros[i] == resposta){
                        count++;
                    }
                }
                //informa o utilizador
                if (count == 0){
                    System.out.println(RED + "O " + resposta + " não se encontra no array" + RESET);
                }else if (count == 1){
                    System.out.println(GREEN + "O " + resposta + " encontra-se 1 vez no array");
                }else {
                    System.out.println(GREEN + "O " + resposta + " encontra-se " + count + " vezes no array");
                }
                //resetar a variavel caso o utilizador quera comparar mais numeros
                count = 0;
            }catch (InputMismatchException e){
                System.out.println(RED + "Terminando" + RESET);
                vali = false;
            }
        }while (vali);

    }

    private static void Ex3() {
        int countImportante = 0;

        try {
            //passa o conteudo do txt por linha para a list
            List<String> texto = Files.readAllLines(Path.of("entrada.txt"), StandardCharsets.UTF_8);
            //vai percorrer toda a lista
            for (int i = 0; i < texto.size(); i++) {
                //procura se a palavra importante existe na linha
                if ( texto.get(i).contains("importante") ){
                    try {
                        //conta a quantidade de linhas
                        countImportante++;
                        //escreve a linha que contem importante no novo txt
                        BufferedWriter bw = new BufferedWriter(new FileWriter("saida.txt", true));
                        bw.write(texto.get(i));
                        //muda de linha
                        bw.newLine();
                        //grava as alterações
                        bw.close();
                    } catch (IOException e) {
                        System.out.println(RED + "Erro ao escrever no ficheiro saida.txt" + RESET);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(RED + "Erro ao ler no ficheiro entrada.txt" + RESET);
        }

        //informa o utilizador de quantas linhas contem "importante"
        System.out.println(GREEN + "A palavra importante aparece em " + countImportante + " linhas" + RESET);


    }

    private static void Ex2() {
        ArrayList<Integer> numeros = new ArrayList<>();
        int resposta = 0;
        boolean vali = true;

        //ciclo para intruduzir n numeros
        do {
            System.out.println(YELLOW + "Insira um número negativo para terminar" + RESET);
            System.out.println(BLUE + "Qual é o número que pretende inserir?" + RESET);
            //valida se inserio apenas numeros
            try{
                resposta = in.nextInt();
                //verifica se o utilizador quer parar ou guardar o numero
                if (resposta < 0){
                    //termina o ciclo
                    vali = false;
                    System.out.println(GREEN + "Inserção terminada" + RESET);
                }else {
                    //adiciona o numero ao array
                    numeros.add(resposta);
                }
            }catch (InputMismatchException e){
                System.out.println(RED + "Insira apenas números!" + RESET);
            }
        }while (vali);

        //mostra que vai começar a mostrar
        System.out.println("\nOs números inseridos em ordem contraria são:");

        //ciclo para mostrar os numeros em ordem contraria a inserida pelo utilizador
        for (int i = numeros.size() - 1; i >= 0; i--) {
            System.out.print(YELLOW + "| " + numeros.get(i) + " |\t" + RESET);
        }

        //quebra de linha
        System.out.println();
    }

    private static void Ex1() {
        //quantidade de numeros a serem inseridos
        int max = 10;

        int respostas = 0, impares = 0, pares = 0, soma = 0;
        double media;

        //ler os 10 numeros
        for (int i = 0; i < max; i++) {
            System.out.println((i + 1) + "ª número: ");
            try {
                respostas = in.nextInt();

                //contar os pares e os impares
                if ((respostas % 2) == 0) {
                    pares++;
                } else {
                    impares++;
                }

                // somar todos os numeros
                soma += respostas;


            } catch (InputMismatchException e) {
                System.out.println("Insira apenas numeros!");
                i--;
            }
        }

        //calcular a media
        media = (double) soma / max;

        //da print da informação
        System.out.println(GREEN + "\n" + pares + " sao pares.");
        System.out.println(impares + " sao ímpares.");
        System.out.println("A soma total é: " + soma);
        System.out.println("A media é: " + media + RESET);

    }

    private static void Clear() {
        //escreve 100 linhas em branco para limpar o ecra
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}