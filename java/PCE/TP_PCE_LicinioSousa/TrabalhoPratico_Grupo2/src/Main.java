import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    //Variaveis globais
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<Integer> jogadas = new ArrayList<>();
    static ArrayList<Integer> acertadas = new ArrayList<>();

    //variaveis para o jogo
    static ArrayList<Integer> ouvintes = new ArrayList<>();
    static int maxouvintes;
    static double pesodosaco, menorpeso, maiorpeso;
    static ArrayList<Double> apostas = new ArrayList<>();

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
            System.out.printf(GREEN + "%-35s" + RESET, "\n\n|Jogo do saco|");
            System.out.println();
            System.out.printf(BLUE + "%-35s %-35s %-35s %-35s" + RESET, "|1 - Adicionar ou Remover ouvintes|", "|2 - Ver ranking|", "|3 - Jogar|", "|0 - Sair|");
            //quebra de linha
            System.out.println();

            // valida se inserio apenas numeros
            try {
                //dar reset ao scanner
                in = new Scanner(System.in);

                menu = in.nextInt();
                //valida se a escolha é valida
                switch (menu) {
                    case 0:
                        System.out.println(RED + "Terminando o programa" + RESET);

                        //atualizar a base de dados
                        EscreverArraysNaBaseDados();

                        vali = false;
                        break;
                    case 1:
                        //ciclo para fazer validaçoes no submenu
                        do {
                            System.out.printf(BLUE + "%-35s %-35s %-35s" + RESET, "|1 - Adicionar ouvintes|", "|2 - Remover ouvintes|", "|0 - Sair|");
                            //quebra de linha
                            System.out.println();

                            //valida se so inserio numeros
                            try {
                                //dar reset ao scanner
                                in = new Scanner(System.in);

                                menu = in.nextInt();
                                if (menu == 1) AdicionarOuvintes();
                                else if (menu == 2) RemoverOuvintes();
                                else if (menu == 0) vali2 = false;
                                else System.out.println(RED + "Insira uma opção valida" + RESET);
                            } catch (InputMismatchException e) {
                                System.out.println(RED + "Insira apenas números!" + RESET);
                            }
                        } while (vali2);

                        break;
                    case 2:
                        //chama a função para calcular, escrever no ficheiro e apresentar ao utilizador o ranking atualizado
                        VerRanking();
                        break;
                    case 3:
                        //chama a função para jogar o jogo
                        Jogar();
                        break;
                    default:
                        System.out.println(RED + "Insira uma opção valida" + RESET);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "Insira apenas números!" + RESET);
            }


        } while (vali);

    }

    private static void Jogar() {
        int max = nomes.size(), index = 0, ganhadores = 0;
        int[][] diferenca;
        double aposta;
        boolean resposta = true;

        //verifica se existe ouvintes para jogar, caso nao exista sai do jogo e avisa o utilizador
        if (nomes.isEmpty()) {
            System.out.println(RED + "\nNão existe ouvintes para poder jogar, adicione ouvintes primeiro!" + RESET);
            return;
        }


        // numero aleatorio de ouvintes que vao jogar
        maxouvintes = rnd.nextInt(2, max + 1);


        //limpa a lista de index
        ouvintes.clear();

        //cria a lista de ouvintes que vao jogar
        for (int i = 0; i < maxouvintes; i++) {
            index = rnd.nextInt(0, max);
            if (!ouvintes.contains(index)) {
                ouvintes.add(index);
            } else {
                i--;
            }

        }

        //determina o peso do saco
        CriarSaco();

        //declarar o tamanho do array diferenca
        diferenca = new int[maxouvintes][2];

        //preencher as apostas
        for (int i = 0; i < maxouvintes; i++) {

            //para nao tar sempre a mostrar a lista se errar a resposta
            if (resposta) {
                //mostra a lista de ouvintes que vao jogar
                MostrarOuvintesParaJogar(i, maxouvintes - i);
            }

            //mostra o intervalo em que o saco se encontra
            System.out.println(YELLOW + "O saco tem entre " + menorpeso + "kg e " + maiorpeso + " kg!" + RESET);

            //apresenta a verde o ouvinte que esta a jogar
            System.out.println(GREEN + "Ouvinte em jogo: " + nomes.get(ouvintes.get(i)) + RESET);

            //pede a aposta do utilizador
            System.out.println(BLUE + "Qual é a sua aposta?" + RESET);

            //dar reset ao scanner
            in = new Scanner(System.in);

            //valida se a resposta é um numero
            try {
                aposta = in.nextDouble();
                //valida se a resposta esta dentro dos parametros fornecidos
                if (aposta >= menorpeso && aposta <= maiorpeso) {

                    //verifica se ja apostaram o mesmo valor
                    if (apostas.contains(aposta)) {
                        System.out.println(RED + "Já apostaram esse valor!" + RESET);
                        i--;

                        //para nao mostrar a lista em espera
                        resposta = false;
                    } else {
                        apostas.add(aposta);

                        //adicionar os user e o quao perto estao do peso
                        diferenca[i][0] = ouvintes.get(i);
                        diferenca[i][1] = (int) Math.round(Math.abs(aposta - pesodosaco) * 1000);

                        //para mostrar a lista em espera
                        resposta = true;
                    }

                } else {
                    System.out.println(RED + "Aposta invalida!" + RESET);
                    i--;

                    //para nao mostrar a lista em espera
                    resposta = false;
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "Insira apenas números e uma virgula!" + RESET);
            }

        }

        //mostra a lista completa com as apostas
        MostrarOuvintesParaJogar(-1, 0);

        //ordenar o array para ver quem esta mais perto
        Arrays.sort(diferenca, (a, b) -> Integer.compare(a[1], b[1]));

        //contar quantos ganharam
        for (int i = 0; i < maxouvintes; i++) {

            if (diferenca[i][1] == diferenca[0][1]) {
                ganhadores++;
            }

        }

        if (ganhadores == 1) {
            System.out.println(GREEN + "\nExiste " + ganhadores + " vencedor." + RESET);
            System.out.print(BLUE + "O vencedor é:  " + RESET);
        } else {
            System.out.println(GREEN + "\nExistem " + ganhadores + " vencedores." + RESET);
            System.out.print(BLUE + "Os vencedores são:  " + RESET);
        }


        //mostrar o(s) vencedor(s) e acrescentar as jogadas
        for (int i = 0; i < maxouvintes; i++) {

            if (diferenca[i][1] == diferenca[0][1]) {
                jogadas.set(diferenca[i][0], jogadas.get(diferenca[i][0]) + 1);
                acertadas.set(diferenca[i][0], acertadas.get(diferenca[i][0]) + 1);
                System.out.print(GREEN + nomes.get(diferenca[i][0]) + "\t" + RESET);
            } else {
                jogadas.set(diferenca[i][0], jogadas.get(diferenca[i][0]) + 1);
            }

        }

        //quebra de linha
        System.out.println();

        //atualizar a base de dados
        EscreverArraysNaBaseDados();
    }

    private static void CriarSaco() {
        int margem = rnd.nextInt(1, 151);
        //gerar um peso aleatorio entre 1kg e 10kg
        pesodosaco = rnd.nextInt(1000, 10001);

        //calcula a margem aleatoria para que nao seja sempre o numero do meio o premiado
        menorpeso = pesodosaco - margem;
        maiorpeso = pesodosaco + (150 - margem);

        //transforma em kilos
        pesodosaco /= 1000;
        menorpeso /= 1000;
        maiorpeso /= 1000;

    }

    private static void MostrarOuvintesParaJogar(int opcao, int max) {

        if (opcao >= 0) {
            //quebra de linha
            System.out.println();

            System.out.println(YELLOW + "Estão " + (max - 1) + " ouvintes na fila!" + RESET);
            //quebra de linha
            System.out.println();

            //para nao dar print quando nao existir ninguem na lista de espera
            if (max - 1 != 0) {
                //da print a lista
                System.out.println(YELLOW + "Lista de espera:" + RESET);
                for (int i = opcao + 1; i < maxouvintes; i++) {
                    System.out.println(BLUE + (i + 1) + "ª: " + nomes.get(ouvintes.get(i)) + RESET);
                }
                //quebra de linha
                System.out.println();
            }


        } else if (opcao == -1) {
            //quebra de linha
            System.out.println();

            //Mostrar o valor do saco antes da listagem de jogadores
            System.out.println(BLUE + "O peso do saco é: " + GREEN + pesodosaco + RESET);

            //quebra de linha
            System.out.println();

            System.out.printf(YELLOW + " %-30s %-30s \n" + RESET, "Nomes", "Apostas");
            for (int i = 0; i < maxouvintes; i++) {
                System.out.printf(BLUE + " %-30s %-30s \n" + RESET, nomes.get(ouvintes.get(i)), apostas.get(i));
            }

            //quebra de linha
            System.out.println();
        }


    }

    private static void VerRanking() {
        // mostrar os ouvintes e ordenar por classificação
        int count = 0, max = nomes.size(), contadortemporario = 0, maxtemp = 0, posicaotemporaria = 0;
        ArrayList<Integer> acertostemporario = new ArrayList<>();
        String[][] outputFinal = new String[max][3];

        //verifica se existe ouvintes para montar o ranking, caso nao exista sai e avisa o utilizador
        if (nomes.isEmpty()) {
            System.out.println(RED + "\nNão existe ouvintes para mostrar um ranking, adicione ouvintes primeiro!" + RESET);
            return;
        }


        // insere o numero de acertos diferentes para dar sort mais a frente
        for (int i = 0; i < nomes.size(); i++) {
            // se o numero nao estiver no temporario, adiciona
            if (!acertostemporario.contains(acertadas.get(i))) {
                acertostemporario.add(acertadas.get(i));
            }
        }

        //colocar ja em ordem decrescente para facilitar
        acertostemporario.sort(Collections.reverseOrder());

        // ir buscar todos os que tem os acertos iguais para ordenar pelas tentativas
        do {
            //inicializar dentro do loop para que sempre comece a 0
            ArrayList<Integer> index = new ArrayList<>();
            // vai buscar os index de quem tem os mesmos acertos
            for (int i = 0; i < nomes.size(); i++) {
                if (Objects.equals(acertadas.get(i), acertostemporario.get(contadortemporario))) {
                    index.add(i);
                }
            }
            contadortemporario++;

            // cria o array temporario com o numero correcto de linhas para poder dar sort mais a frente
            String[][] temporario = new String[index.size()][3];

            //preencho um array temporario para dar sort pelas tentativas ja que tem os mesmos acertos
            for (int i = 0; i < index.size(); i++) {
                temporario[i][0] = nomes.get(index.get(i));
                temporario[i][1] = String.valueOf(jogadas.get(index.get(i)));
                temporario[i][2] = String.valueOf(acertadas.get(index.get(i)));
            }

            if (temporario.length > 0) {
                // da sort ao array temporario para na frente inserir ja na ordem no array final
                Arrays.sort(temporario, (a, b) -> {
                    int num1 = Integer.parseInt(a[1]);
                    int num2 = Integer.parseInt(b[1]);
                    return Integer.compare(num1, num2);
                });
            }

            maxtemp = count + temporario.length;
            //passar os ouvintes ja ordenados para o array final
            for (int i = count; i < maxtemp; i++) {
                outputFinal[i][0] = temporario[posicaotemporaria][0];
                outputFinal[i][1] = temporario[posicaotemporaria][1];
                outputFinal[i][2] = temporario[posicaotemporaria][2];
                count++;
                posicaotemporaria++;
            }

            //reseta a variavel para a proxima vez do loop
            posicaotemporaria = 0;


        } while (count < max);

        //array de strings temporario para escrever no ficheiro
        ArrayList<String> output = new ArrayList<>();
        //adicionar o conteudo ao array para escrever no ficheiro
        output.add(GREEN + "Classificação dos ouvintes" + RESET);
        //escrever o rank no array temporario
        for (int i = 0; i < outputFinal.length; i++) {
            output.add((i + 1) + "ª classificado: " + outputFinal[i][0] + " com " + outputFinal[i][2] + " vitorias e " + outputFinal[i][1] + " jogadas.");
        }

        //escrever no ficheiro ranking
        try {
            Files.write(Path.of("ranking.txt"), output);
        } catch (IOException e) {
            System.out.println(RED + "Erro ao escrever no ranking!" + RESET);
        }

        //quebra de linha
        System.out.println();

        for (int i = 0; i <= outputFinal.length; i++) {
            System.out.println(BLUE + output.get(i) + RESET);
        }

        //quebra de linha
        System.out.println();

    }

    private static void RemoverOuvintes() {
        boolean vali = true;
        int escolha = 0;

        //verifica se existe ouvintes para remover, caso nao exista sai e avisa o utilizador
        if (nomes.isEmpty()) {
            System.out.println(RED + "\nNão existe ouvintes para remover, adicione ouvintes primeiro!" + RESET);
            return;
        }


        //Mostrar a lista de nomes
        MostrarOuvintes();

        do {
            System.out.println(RED + "Qual o ouvinte que quer remover?\t\t| 0 - Para cancelar |" + RESET);
            try {
                //dar reset ao scanner
                in = new Scanner(System.in);

                escolha = in.nextInt();
                if (escolha >= 1 && escolha <= nomes.size()) {
                    escolha--;
                    //retira todos os dados referentes ao ouvinte escolhido
                    nomes.remove(escolha);
                    jogadas.remove(escolha);
                    acertadas.remove(escolha);
                    //mostra ao utilizador que foi removido
                    System.out.println(GREEN + "Ouvinte removido com sucesso!" + RESET);
                    //termina o loop
                    vali = false;
                } else if (escolha == 0) {
                    System.out.println(RED + "Cancelado!" + RESET);
                    return;
                } else {
                    System.out.println(RED + "Escolha um ouvinte valido!" + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "Insira apenas números!");
            }
        } while (vali);


        //guardar as informações no ficheiro para nao perder
        EscreverArraysNaBaseDados();

    }

    private static void AdicionarOuvintes() {
        //pergunta o nome do novo ouvinte e atribui as tentativas e acertos a 0
        String nome;

        System.out.println(BLUE + "Qual é o nome do ouvinte?\t\t| Digite 0 para cancelar |" + RESET);

        //dar reset ao scanner
        in = new Scanner(System.in);

        nome = in.nextLine();
        if (nome.equals("0")) {
            System.out.println(RED + "Cancelado!" + RESET);
            return;
        } else {
            // adiciona aos arrays
            nomes.add(nome);
            jogadas.add(0);
            acertadas.add(0);

            System.out.println(GREEN + "Ouvinte adicionado com sucesso!" + RESET);

            //guardar as informações no ficheiro para nao perder
            EscreverArraysNaBaseDados();
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
        try {
            Files.write(Path.of("basededados.txt"), tem);
        } catch (IOException e) {
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
            System.out.println(RED + "Erro, Base de Dados não encontrada!" + RESET);
            System.out.println(BLUE + "Sera criada uma nova base de dados em branco!" + RESET);
            EscreverArraysNaBaseDados();

        }

    }
}