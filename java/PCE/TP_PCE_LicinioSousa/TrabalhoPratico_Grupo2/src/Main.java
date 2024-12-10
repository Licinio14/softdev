import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Variaveis globais
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<Integer> jogadas = new ArrayList<>();
    static ArrayList<Integer> acertadas = new ArrayList<>();
    

    //variaveis para mudar a cor do texto
    static final String RED = "\033[0;31m";
    static final String GREEN = "\033[0;32m";
    static final String BLUE = "\033[0;34m";
    static final String YELLOW = "\033[0;33m";
    static final String RESET = "\033[0m";

    public static void main(String[] args) {
        boolean vali = true, vali2 = true;
        int menu = 0;
        
        //preencher os array com os dados
        PreencherArraysComDados();

        do {
            System.out.printf(BLUE + "%-35s" + RESET,"|2 - Ver ranking|" );
            System.out.println();
            System.out.printf(BLUE + "%-35s %-35s %-35s %-35s" + RESET, "|1 - Adicionar ou Remover ouvintes|", "|2 - Ver ranking|" , "|3 - Jogar|", "|0 - Sair|" );
            //quebra de linha
            System.out.println();

            // valida se inserio apenas numeros
            try{
                menu = in.nextInt();
                //valida se a escolha é valida
                switch (menu){
                    case 0:
                        System.out.println(RED + "Terminando o programa" + RESET);
                        vali = false;
                        break;
                    case 1:

                        //ciclo para fazer validaçoes no submenu

                        do {
                            System.out.printf(BLUE + "%-35s %-35s %-35s" + RESET, "|1 - Adicionar ouvintes|", "|2 - Remover ouvintes|","|0 - Sair|");
                            //quebra de linha
                            System.out.println();

                            //valida se so inserio numeros
                            try{
                                menu = in.nextInt();
                                if (menu == 1) AdicionarOuvintes();
                                else if (menu == 2) RemoverOuvintes();
                                else if (menu == 0) vali2 = false;
                                else System.out.println(RED + "Insira uma opção valida" + RESET);
                            }catch (InputMismatchException e){
                                System.out.println(RED + "Insira apenas números!" + RESET);
                            }
                        }while (vali2);



                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    default:
                        System.out.println(RED + "Insira uma opção valida" + RESET);
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(RED + "Insira apenas números!" + RESET);
            }


        }while (vali);

    }

    private static void RemoverOuvintes() {
        boolean vali = true;
        int escolha = 0;

        //Mostrar a lista de nomes
        MostrarOuvintes();

        do {
            System.out.println(RED + "Qual o ouvinte que quer remover?" + RESET);
            try{
                escolha = in.nextInt();
                if (escolha >= 1 && escolha <= nomes.size()){
                    escolha--;
                    //retira todos os dados referentes ao ouvinte escolhido
                    nomes.remove(escolha);
                    jogadas.remove(escolha);
                    acertadas.remove(escolha);
                    //mostra ao utilizador que foi removido
                    System.out.println(GREEN + "Ouvinte removido com sucesso!" + RESET);
                    //termina o loop
                    vali = false;
                }else {
                    System.out.println(RED + "Escolha um ouvinte valido!" + RESET);
                }
            }catch (InputMismatchException e){
                System.out.println(RED + "Insira apenas números!");
            }
        }while (vali);


        //guardar as informações no ficheiro para nao perder
        EscreverArraysNaBaseDados();

    }


    private static void AdicionarOuvintes() {
        //pergunta o nome do novo ouvinte e atribui as tentativas e acertos a 0
        String nome;

        System.out.println(BLUE + "Qual é o nome do ouvinte?" + RESET);
        in = new Scanner(System.in);
        nome = in.nextLine();
        // adiciona aos arrays
        nomes.add(nome);
        jogadas.add(0);
        acertadas.add(0);

        System.out.println(GREEN + "Ouvinte adicionado com sucesso!" + RESET);

        //guardar as informações no ficheiro para nao perder
        EscreverArraysNaBaseDados();

    }

    private static void Clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    private static void MostrarOuvintes() {
        //quebra de linha
        System.out.println();
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(BLUE + (i + 1) + "ª ouvinte: " + nomes.get(i) + RESET);
        }
    }

    private static void EscreverArraysNaBaseDados() {
        ArrayList<String> tem = new ArrayList<>();
        for (int i = 0; i < nomes.size(); i++) {
            tem.add(nomes.get(i) + ";" + jogadas.get(i) + ";" + acertadas.get(i));
        }
        try{
            Files.write(Path.of("nomes.txt"),tem);
        }catch (IOException e){
            System.out.println("Erro a escrever no ficheiro!");
        }
    }

    private static void PreencherArraysComDados() {
        String linha;
        // preenche os arrays com as informações do ficheiro
        try {
            List<String> texto = Files.readAllLines(Path.of("basededados.txt"), StandardCharsets.UTF_8);
            for (int i = 0; i < texto.size(); i++) {
                linha = texto.get(i);
                String[] temp = linha.split(";");
                nomes.add(temp[0]);
                jogadas.add(Integer.valueOf(temp[1]));
                acertadas.add(Integer.valueOf(temp[2]));
            }
        } catch (IOException e) {
            System.out.println(RED + "Erro ao ler a Base de Dados" + RESET);
        }
        
    }
}