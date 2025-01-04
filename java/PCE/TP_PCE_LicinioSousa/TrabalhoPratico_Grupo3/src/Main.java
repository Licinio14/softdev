import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    //Variaveis globais
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> distritos = new ArrayList<>();
    static ArrayList<Integer> inscritos = new ArrayList<>();
    static ArrayList<Integer> votantes = new ArrayList<>();
    static ArrayList<Integer> nulos = new ArrayList<>();
    static ArrayList<Integer> brancos = new ArrayList<>();
    static ArrayList<Integer> ad = new ArrayList<>();
    static ArrayList<Integer> ps = new ArrayList<>();
    static ArrayList<Integer> ch = new ArrayList<>();
    static ArrayList<Integer> il = new ArrayList<>();
    static ArrayList<Integer> be = new ArrayList<>();
    static ArrayList<Integer> outros = new ArrayList<>();
    static ArrayList<Integer> total = new ArrayList<>();
    // para validar se os dados estao de acordo com as regras na leitura do documento //variavel para saber se as alterações foram guardadas
    static boolean validacaoInicial = false, guardadoNaBD = true;


    //variaveis para mudar a cor do texto
    static final String RED = "\033[0;91m";
    static final String GREEN = "\033[0;92m";
    static final String BLUE = "\033[0;94m";
    static final String YELLOW = "\033[0;93m";
    static final String CIAN = "\033[0;96m";
    static final String BLACK = "\033[0;90m";
    static final String RESET = "\033[0m";

    public static void main(String[] args) {
        boolean menu = true;
        int op = 0;

        //ciclo do menu inicial
        do {
            System.out.printf(CIAN + "%65s\n" + RESET, "| - MENU - |");
            System.out.println(BLUE + "|1 - Ler base de dados|\t|2 - Escrever dados na base de dados|\t|3 - Mostrar tabela de dados|\t|4 - Distrito com mais votos|\n|5 - Partido mais votado|\t|6 - Mais votado por distrito|\t|7 - Ordenar os distritos do partido vencedor|\n|8 - Atualizar informações/erros|\t|9 - Adicionar votos da freguesia|\t|10 - Email do distrito com mais votos invalidos|\t|0 - Sair|" + RESET);

            //validar se foi inserido apenas numeros
            try {
                //resetar o scanner
                in = new Scanner(System.in);

                op = in.nextInt();
                switch (op) {
                    case 0:
                        //verifica se as alterações ja foram guardadas
                        if (guardadoNaBD) {
                            System.out.println(RED + "\nTerminando o programa\n" + RESET);
                            menu = false;
                        } else {
                            do {
                                System.out.println(RED + "\nAs alterações nao foram guardadas, sair sem guardar?" + RESET);
                                System.out.println(RED + "|1 - Sim|\t|2 - Nao|" + RESET);

                                //validar se foi inserido apenas numeros
                                try {
                                    //resetar o scanner
                                    in = new Scanner(System.in);

                                    op = in.nextInt();

                                    if (op == 1) {
                                        System.out.println(RED + "\nTerminando o programa\n" + RESET);
                                        menu = false;
                                    } else if (op == 2) {
                                        System.out.println(GREEN + "\nCancelando...\n" + RESET);
                                    } else {
                                        System.out.println(RED + "\nEscolha uma opção valida\n" + RESET);
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println(RED + "\nInsira apenas números\n" + RESET);
                                }

                            } while (op != 1 && op != 2);

                        }

                        break;
                    case 1:
                        // le e preenche as variaveis com as informaçoes da base de dados
                        PreencherBaseDados();
                        break;
                    case 2:
                        //escrever os dados no txt
                        EscreverBaseDados();
                        break;
                    case 3:
                        //mostra a tabela completa
                        MostrarTabela();
                        break;
                    case 4:
                        //mostrar o(s) distrito(s) com mais votos
                        DistritoMaisVotos();
                        break;
                    case 5:
                        //calcular e mostrar o partido mais votado
                        PartidoMaisVotado();
                        break;
                    case 6:
                        //calcular e mostrar o mais votado por distrito
                        MaisVotadoPorDistrito();
                        break;
                    case 7:
                        //ordenar distritos do vencedor
                        OrdenarDistritosVencedor();
                        break;
                    case 8:
                        //atualizar informaçoes
                        AtualizarInformacoes();
                        break;
                    case 9:
                        //adicionar votos de concelhos
                        AdicionarFreguesia();
                        break;
                    case 10:
                        //imprimir os emails dos que tem mais votos invalidos
                        EmailMaisVotosInvalidos();
                        break;
                    default:
                        System.out.println(RED + "\nInsira uma opção valida!\n" + RESET);
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "\nInsira apenas números inteiros\n" + RESET);
            }

        } while (menu);


    }

    private static void EmailMaisVotosInvalidos() {
        int totalInvalidos = 0;
        ArrayList<String> emails = new ArrayList<>();
        String nome;

        //validar se pode proseguir
        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro ao mostrar dados\nNão existe dados para montar!\n" + RESET);
            return;
        } else if (!validacaoInicial) {
            System.out.println(RED + "\nErro ao mostrar dados\nDados inseridos nao estão corretos!\n" + RESET);
            return;
        }

        //ciclo para saber quem tem mais votos invalidos
        for (int i = 0; i < distritos.size(); i++) {
            //na primeira passagem atribui o valor e nas proximas é que compara
            if (i == 0) {
                totalInvalidos = nulos.get(i) + brancos.get(i);
            } else {
                if (totalInvalidos < (nulos.get(i) + brancos.get(i))) totalInvalidos = nulos.get(i) + brancos.get(i);
            }
        }

        //cilco para construir os emails
        for (int i = 0; i < distritos.size(); i++) {
            //verifica se é um dos destritos que é necessario ter o email
            if (totalInvalidos == (nulos.get(i) + brancos.get(i))) {
                //passa o nome para uma string para acessar os caracteres
                nome = distritos.get(i);

                //guarda o distrito antes do email
                emails.add(nome);

                //controi o email com os caracters desejados
                System.out.println(nome.charAt(1));
                emails.add(String.valueOf(nome.charAt(0)) + String.valueOf(nome.charAt(1)) + String.valueOf(nome.charAt(nome.length() - 2)) + String.valueOf(nome.charAt(nome.length() - 1)) + "@ine.pt");
            }
        }

        //mostrar em tabela
        System.out.printf(CIAN + "\n%s\n" + RESET, "Emails dos distritos com mais votos invalidos\n");

        //separar
        for (int i = 0; i < 29; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        //cabeçalho da tabela
        System.out.printf(BLACK + "| " + BLUE + "%-11s" + BLACK + " | " + BLUE + "%-11s" + BLACK + " |\n" + RESET, "Distrito", "Emails");

        //separar
        for (int i = 0; i < 29; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        //ciclo para mostrar os emails
        for (int i = 0; i < emails.size(); i += 2) {
            System.out.printf(BLACK + "| " + GREEN + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, emails.get(i), emails.get(i + 1));
        }

        //separar
        for (int i = 0; i < 29; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();
    }

    private static void AdicionarFreguesia() {
        int index = 0, addvotantes = 0, addnulos = 0, addbrancos = 0, addad = 0, addps = 0, addch = 0, addil = 0, addbe = 0, erros = 0;
        boolean menu = true, menu2 = true;

        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro ao mostrar dados\nNão existe dados para montar!\n" + RESET);
            return;
        } else if (!validacaoInicial) {
            System.out.println(RED + "\nErro ao mostrar dados\nDados inseridos nao estão corretos!\n" + RESET);
            return;
        }

        do {
            //Mostrar a tabela
            MostrarTabela();

            //mostrar opções de distritos
            for (int i = 0; i < distritos.size(); i++) {
                System.out.printf(YELLOW + "| %d | - %s\t" + RESET, i + 1, distritos.get(i));
            }
            System.out.printf(YELLOW + "| 0 | - Cancelar" + RESET);

            //quebra de linha
            System.out.println();

            try {
                System.out.println(BLUE + "Qual é o distrito em que pretende adicionar os votos da freguesia");
                //resetar o scanner
                in = new Scanner(System.in);

                index = in.nextInt();

                //para caso o utilizador queira cancelar
                if (index == 0) {
                    System.out.println(GREEN + "Cancelando..." + RESET);
                    return;
                } else {
                    // muda o index para o correto usado no array
                    index--;
                }

                //verifica se é uma opção valida
                if (index >= 0 && index < distritos.size()) {

                    //perguntar os valores ao utilizador
                    do {
                        System.out.println(BLUE + "Quantos votantes participaram? |0 - Para cancelar|" + RESET);
                        //resetar o scanner
                        in = new Scanner(System.in);

                        try {
                            addvotantes = in.nextInt();

                            //validaçoes
                            if (addvotantes == 0) {
                                System.out.println(GREEN + "Cancelando..." + RESET);
                                return;
                            }
                            if (addvotantes < 0) {
                                System.out.println(RED + "O número de votantes tem de ser positivo!\n" + RESET);
                            } else {
                                menu2 = false;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Insira apenas números!!\n" + RESET);
                        }

                    } while (menu2);
                    //resetar a variavel para o proximo loop
                    menu2 = true;

                    //perguntar os valores ao utilizador
                    do {
                        System.out.println(BLUE + "Quantos votos nulos?" + RESET);
                        //resetar o scanner
                        in = new Scanner(System.in);

                        try {
                            addnulos = in.nextInt();

                            //validaçoes
                            if (addnulos < 0) {
                                System.out.println(RED + "A quantidade de votos tem de ser 0 ou mais!\n" + RESET);
                            } else {
                                menu2 = false;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Insira apenas números!!\n" + RESET);
                        }

                    } while (menu2);
                    //resetar a variavel para o proximo loop
                    menu2 = true;

                    //perguntar os valores ao utilizador
                    do {
                        System.out.println(BLUE + "Quantos votos em branco?" + RESET);
                        //resetar o scanner
                        in = new Scanner(System.in);

                        try {
                            addbrancos = in.nextInt();

                            //validaçoes
                            if (addbrancos < 0) {
                                System.out.println(RED + "A quantidade de votos tem de ser 0 ou mais!\n" + RESET);
                            } else {
                                menu2 = false;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Insira apenas números!!\n" + RESET);
                        }

                    } while (menu2);
                    //resetar a variavel para o proximo loop
                    menu2 = true;

                    //perguntar os valores ao utilizador
                    do {
                        System.out.println(BLUE + "Quantos votos no AD?" + RESET);
                        //resetar o scanner
                        in = new Scanner(System.in);

                        try {
                            addad = in.nextInt();

                            //validaçoes
                            if (addad < 0) {
                                System.out.println(RED + "A quantidade de votos tem de ser 0 ou mais!\n" + RESET);
                            } else {
                                menu2 = false;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Insira apenas números!!\n" + RESET);
                        }

                    } while (menu2);
                    //resetar a variavel para o proximo loop
                    menu2 = true;

                    //perguntar os valores ao utilizador
                    do {
                        System.out.println(BLUE + "Quantos votos no PS?" + RESET);
                        //resetar o scanner
                        in = new Scanner(System.in);

                        try {
                            addps = in.nextInt();

                            //validaçoes
                            if (addps < 0) {
                                System.out.println(RED + "A quantidade de votos tem de ser 0 ou mais!\n" + RESET);
                            } else {
                                menu2 = false;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Insira apenas números!!\n" + RESET);
                        }

                    } while (menu2);
                    //resetar a variavel para o proximo loop
                    menu2 = true;

                    //perguntar os valores ao utilizador
                    do {
                        System.out.println(BLUE + "Quantos votos no CH?" + RESET);
                        //resetar o scanner
                        in = new Scanner(System.in);

                        try {
                            addch = in.nextInt();

                            //validaçoes
                            if (addch < 0) {
                                System.out.println(RED + "A quantidade de votos tem de ser 0 ou mais!\n" + RESET);
                            } else {
                                menu2 = false;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Insira apenas números!!\n" + RESET);
                        }

                    } while (menu2);
                    //resetar a variavel para o proximo loop
                    menu2 = true;

                    //perguntar os valores ao utilizador
                    do {
                        System.out.println(BLUE + "Quantos votos no IL?" + RESET);
                        //resetar o scanner
                        in = new Scanner(System.in);

                        try {
                            addil = in.nextInt();

                            //validaçoes
                            if (addil < 0) {
                                System.out.println(RED + "A quantidade de votos tem de ser 0 ou mais!\n" + RESET);
                            } else {
                                menu2 = false;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Insira apenas números!!\n" + RESET);
                        }

                    } while (menu2);
                    //resetar a variavel para o proximo loop
                    menu2 = true;

                    //perguntar os valores ao utilizador
                    do {
                        System.out.println(BLUE + "Quantos votos no BE?" + RESET);
                        //resetar o scanner
                        in = new Scanner(System.in);

                        try {
                            addbe = in.nextInt();

                            //validaçoes
                            if (addbe < 0) {
                                System.out.println(RED + "A quantidade de votos tem de ser 0 ou mais!\n" + RESET);
                            } else {
                                menu2 = false;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(RED + "Insira apenas números!!\n" + RESET);
                        }

                    } while (menu2);

                    //parar o ciclo
                    menu = false;

                } else {
                    System.out.println(RED + "Insira uma opção valida" + RESET);
                }

            } catch (InputMismatchException e) {
                System.out.println(RED + "Insira apenas números!!" + RESET);
            }
        } while (menu);

        //validações finais
        //verifica se os votantes vao ser mais que os inscritos
        if (addvotantes + votantes.get(index) > inscritos.get(index)) {
            System.out.println(RED + "A quantidade de votantes de um distrito nao pode ser maior que os inscritos!\n" + RESET);
            erros++;
        }
        //verifica se tem mais votos que votantes
        if (addvotantes < (addnulos + addbrancos + addad + addps + addch + addil + addbe)) {
            System.out.println(RED + "A quantidade de votos nao pode ser maior que os votantes!\n" + RESET);
            erros++;
        }

        //informa o utilizador
        if (erros != 0) {
            System.out.println(RED + "\nExiste erros nos dados, dados nao adicionados a base de dados!!!" + RESET);
            return;
        } else {
            votantes.set(index, (votantes.get(index) + addvotantes));
            nulos.set(index, (nulos.get(index) + addnulos));
            brancos.set(index, (brancos.get(index) + addbrancos));
            ad.set(index, (ad.get(index) + addad));
            ps.set(index, (ps.get(index) + addps));
            ch.set(index, (ch.get(index) + addch));
            il.set(index, (il.get(index) + addil));
            be.set(index, (be.get(index) + addbe));

            System.out.println(GREEN + "Dados inseridos na base de dados!\n" + RESET);

            //para saber que os dados nao estao guardados
            guardadoNaBD = false;

            //atualizar colunas e validação final
            CalcularOutros(index);
            CalcularOutros(index);
            ValidarDados();
        }


    }

    private static void AtualizarInformacoes() {
        boolean menu = true, menu2 = true;
        int index = 0, op = 0, respostaInt = 0;

        //validar se pode proseguir
        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro\nNão existe dados para alterar!\n" + RESET);
            return;
        }

        do {
            //Mostrar a tabela
            MostrarTabela();

            //mostrar opções de distritos
            for (int i = 0; i < distritos.size(); i++) {
                System.out.printf(YELLOW + "| %d | - %s\t" + RESET, i + 1, distritos.get(i));
            }
            System.out.printf(YELLOW + "| 0 | - Cancelar" + RESET);

            //quebra de linha
            System.out.println();

            //ciclo para garantir que o utilizador escolhe uma opção valida
            do {

                //perguntar ao utilizador qual distrito que alterar
                System.out.println(BLUE + "Qual é o distrito que pretende alterar?" + RESET);

                //resetar o scanner
                in = new Scanner(System.in);

                try {
                    index = in.nextInt();

                    //verifica se pode prosseguir ou nao
                    if (index >= 0 && index <= distritos.size()) {
                        if (index == 0) {
                            //cancela a operação
                            System.out.println(GREEN + "\nCancelando...\n" + RESET);
                            return;
                        } else {
                            //atualiza o index para o valor real usado nas listas
                            index--;
                            menu2 = false;
                        }
                    } else {
                        System.out.println(RED + "\nInsira uma opção valida!\n" + RESET);
                    }
                } catch (InputMismatchException e) {
                    System.out.println(RED + "\nInsira apenas números!\n" + RESET);
                }

            } while (menu2);

            //reseta a variavel do submenu
            menu2 = true;

            //ciclo para garantir que o utilizador escolhe uma opção valida
            do {

                //mostrar opções de colunas
                System.out.println(YELLOW + "|1| - Distritos\t|2| - Inscritos\t|3| - Votantes\t|4| - Nulos\t|5| - Brancos\t|6| - AD\t|7| - PS\t|8| - CH\t|9| - IL\t|10| - BE\t|0| - Cancelar\t" + RESET);

                //quebra de linha
                System.out.println();

                //perguntar ao utilizador qual distrito que alterar
                System.out.println(BLUE + "O que pretende alterar?" + RESET);

                //resetar o scanner
                in = new Scanner(System.in);

                try {
                    op = in.nextInt();

                    //verifica se pode prosseguir ou nao
                    if (op >= 0 && op <= 10) {
                        if (op == 0) {
                            //cancela a operação
                            System.out.println(GREEN + "\nCancelando...\n" + RESET);
                            return;
                        } else {
                            // 1 para os nomes por ser string e o resto é int
                            if (op == 1) {
                                System.out.println(BLUE + "\nQual é o novo nome?\n" + RESET);

                                //resetar o scanner
                                in = new Scanner(System.in);

                                //muda o valor antigo para o novo
                                distritos.set(index, in.nextLine());

                                //guarda a informação que os dados foram alterados e nao foram guardados
                                guardadoNaBD = false;

                                //termina este loop
                                menu2 = false;

                            } else {
                                System.out.println(BLUE + "\nQual é o novo valor?" + RESET);

                                //resetar o scanner
                                in = new Scanner(System.in);

                                try {
                                    respostaInt = in.nextInt();

                                    if (respostaInt >= 0) {
                                        switch (op) {
                                            case 2:
                                                //valida a resposta
                                                if (respostaInt >= (total.get(index))) {
                                                    //atualiza o valor
                                                    inscritos.set(index, respostaInt);

                                                    //informa o utilizador
                                                    System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                    //guarda a informação que os dados foram alterados e nao foram guardados
                                                    guardadoNaBD = false;

                                                    //termina este loop
                                                    menu2 = false;
                                                } else {
                                                    System.out.println(RED + "Os inscritos tem de ser maior ou igual aos votantes!!!\n" + RESET);
                                                }
                                                break;
                                            case 3:
                                                //valida a resposta
                                                if (respostaInt <= inscritos.get(index) && respostaInt >= (nulos.get(index) + brancos.get(index) + ad.get(index) + ps.get(index) + ch.get(index) + il.get(index) + be.get(index))) {
                                                    //atualiza o valor
                                                    votantes.set(index, respostaInt);

                                                    //informa o utilizador
                                                    System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                    //guarda a informação que os dados foram alterados e nao foram guardados
                                                    guardadoNaBD = false;

                                                    //atualiza a coluna outros
                                                    CalcularOutros(index);

                                                    //atualizar o total
                                                    CalcularTotal(index);

                                                    //parar este loop
                                                    menu2 = false;

                                                } else {
                                                    System.out.println(RED + "A quantidade de votantes nao pode ser maior que os inscritos nem menor que a quantidade de votos!!!\n" + RESET);
                                                }
                                                break;
                                            case 4:
                                                //validações
                                                if (respostaInt > votantes.get(index)) {
                                                    System.out.println(RED + "\nNão pode ter mais votos nulos que votantes!\n" + RESET);
                                                    break;
                                                }
                                                if (votantes.get(index) < (respostaInt + brancos.get(index) + ad.get(index) + ps.get(index) + ch.get(index) + il.get(index) + be.get(index))) {
                                                    System.out.println(RED + "\nNão pode haver mais votos que votantes!\n" + RESET);
                                                    break;
                                                }

                                                //atualiza o valor
                                                nulos.set(index, respostaInt);

                                                //informa o utilizador
                                                System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                //guarda a informação que os dados foram alterados e nao foram guardados
                                                guardadoNaBD = false;

                                                //atualiza a coluna outros
                                                CalcularOutros(index);

                                                //atualizar o total
                                                CalcularTotal(index);

                                                //parar este loop
                                                menu2 = false;

                                                break;
                                            case 5:
                                                //validações
                                                if (respostaInt > votantes.get(index)) {
                                                    System.out.println(RED + "\nNão pode ter mais votos nulos que votantes!\n" + RESET);
                                                    break;
                                                }
                                                if (votantes.get(index) < (respostaInt + brancos.get(index) + ad.get(index) + ps.get(index) + ch.get(index) + il.get(index) + be.get(index))) {
                                                    System.out.println(RED + "\nNão pode haver mais votos que votantes!\n" + RESET);
                                                    break;
                                                }

                                                //atualiza o valor
                                                brancos.set(index, respostaInt);

                                                //informa o utilizador
                                                System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                //guarda a informação que os dados foram alterados e nao foram guardados
                                                guardadoNaBD = false;

                                                //atualiza a coluna outros
                                                CalcularOutros(index);

                                                //atualizar o total
                                                CalcularTotal(index);

                                                //parar este loop
                                                menu2 = false;
                                                break;
                                            case 6:
                                                //validações
                                                if (respostaInt > votantes.get(index)) {
                                                    System.out.println(RED + "\nNão pode ter mais votos nulos que votantes!\n" + RESET);
                                                    break;
                                                }
                                                if (votantes.get(index) < (respostaInt + brancos.get(index) + ad.get(index) + ps.get(index) + ch.get(index) + il.get(index) + be.get(index))) {
                                                    System.out.println(RED + "\nNão pode haver mais votos que votantes!\n" + RESET);
                                                    break;
                                                }

                                                //atualiza o valor
                                                ad.set(index, respostaInt);

                                                //informa o utilizador
                                                System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                //guarda a informação que os dados foram alterados e nao foram guardados
                                                guardadoNaBD = false;

                                                //atualiza a coluna outros
                                                CalcularOutros(index);

                                                //atualizar o total
                                                CalcularTotal(index);

                                                //parar este loop
                                                menu2 = false;
                                                break;
                                            case 7:
                                                //validações
                                                if (respostaInt > votantes.get(index)) {
                                                    System.out.println(RED + "\nNão pode ter mais votos nulos que votantes!\n" + RESET);
                                                    break;
                                                }
                                                if (votantes.get(index) < (respostaInt + brancos.get(index) + ad.get(index) + ps.get(index) + ch.get(index) + il.get(index) + be.get(index))) {
                                                    System.out.println(RED + "\nNão pode haver mais votos que votantes!\n" + RESET);
                                                    break;
                                                }

                                                //atualiza o valor
                                                ps.set(index, respostaInt);

                                                //informa o utilizador
                                                System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                //guarda a informação que os dados foram alterados e nao foram guardados
                                                guardadoNaBD = false;

                                                //atualiza a coluna outros
                                                CalcularOutros(index);

                                                //atualizar o total
                                                CalcularTotal(index);

                                                //parar este loop
                                                menu2 = false;
                                                break;
                                            case 8:
                                                //validações
                                                if (respostaInt > votantes.get(index)) {
                                                    System.out.println(RED + "\nNão pode ter mais votos nulos que votantes!\n" + RESET);
                                                    break;
                                                }
                                                if (votantes.get(index) < (respostaInt + brancos.get(index) + ad.get(index) + ps.get(index) + ch.get(index) + il.get(index) + be.get(index))) {
                                                    System.out.println(RED + "\nNão pode haver mais votos que votantes!\n" + RESET);
                                                    break;
                                                }

                                                //atualiza o valor
                                                ch.set(index, respostaInt);

                                                //informa o utilizador
                                                System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                //guarda a informação que os dados foram alterados e nao foram guardados
                                                guardadoNaBD = false;

                                                //atualiza a coluna outros
                                                CalcularOutros(index);

                                                //atualizar o total
                                                CalcularTotal(index);

                                                //parar este loop
                                                menu2 = false;
                                                break;
                                            case 9:
                                                //validações
                                                if (respostaInt > votantes.get(index)) {
                                                    System.out.println(RED + "\nNão pode ter mais votos nulos que votantes!\n" + RESET);
                                                    break;
                                                }
                                                if (votantes.get(index) < (respostaInt + brancos.get(index) + ad.get(index) + ps.get(index) + ch.get(index) + il.get(index) + be.get(index))) {
                                                    System.out.println(RED + "\nNão pode haver mais votos que votantes!\n" + RESET);
                                                    break;
                                                }

                                                //atualiza o valor
                                                il.set(index, respostaInt);

                                                //informa o utilizador
                                                System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                //guarda a informação que os dados foram alterados e nao foram guardados
                                                guardadoNaBD = false;

                                                //atualiza a coluna outros
                                                CalcularOutros(index);

                                                //atualizar o total
                                                CalcularTotal(index);

                                                //parar este loop
                                                menu2 = false;
                                                break;
                                            case 10:
                                                //validações
                                                if (respostaInt > votantes.get(index)) {
                                                    System.out.println(RED + "\nNão pode ter mais votos nulos que votantes!\n" + RESET);
                                                    break;
                                                }
                                                if (votantes.get(index) < (respostaInt + brancos.get(index) + ad.get(index) + ps.get(index) + ch.get(index) + il.get(index) + be.get(index))) {
                                                    System.out.println(RED + "\nNão pode haver mais votos que votantes!\n" + RESET);
                                                    break;
                                                }

                                                //atualiza o valor
                                                be.set(index, respostaInt);

                                                //informa o utilizador
                                                System.out.println(GREEN + "\nAlterado com sucesso\n" + RESET);

                                                //guarda a informação que os dados foram alterados e nao foram guardados
                                                guardadoNaBD = false;

                                                //atualiza a coluna outros
                                                CalcularOutros(index);

                                                //atualizar o total
                                                CalcularTotal(index);

                                                //parar este loop
                                                menu2 = false;
                                                break;
                                        }
                                    } else {
                                        System.out.println(RED + "Apenas são aceites numeros positivos!\n" + RESET);
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println(RED + "Insira apenas números!!!\n" + RESET);
                                }

                            }

                        }
                    } else {
                        System.out.println(RED + "\nInsira uma opção valida!\n" + RESET);
                    }
                } catch (InputMismatchException e) {
                    System.out.println(RED + "\nInsira apenas números!\n" + RESET);
                }

            } while (menu2);

            //reseta a variavel do submenu
            menu2 = true;

            do {
                //pergunta se quer alterar mais alguma coisa
                System.out.println(BLUE + "Pretende alterar mais algum dado?\n|0| - Não\t|1| - Sim");

                //resetar o scanner
                in = new Scanner(System.in);

                op = in.nextInt();

                switch (op) {
                    case 0:
                        menu = false;
                        menu2 = false;
                        break;
                    case 1:
                        menu2 = false;
                        break;
                    default:
                        System.out.println(RED + "Escolha uma opção valida!\n" + RESET);
                        break;
                }
            } while (menu2);

        } while (menu);

        //fazer nova validação dos dados
        System.out.println(RED + "\nRevalidando os dados" + RESET);
        ValidarDados();


    }

    private static void OrdenarDistritosVencedor() {
        int totalAD = 0, totalPs = 0, totalCH = 0, totalIL = 0, totalBE = 0, maisVotado = 0, vencedores = 0, countwhile = 0;
        ArrayList<String> partidosVencedores = new ArrayList<>();
        int[][] arrayTemporario = new int[distritos.size()][2];

        //validar se pode proseguir
        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro ao mostrar dados\nNão existe dados para montar!\n" + RESET);
            return;
        } else if (!validacaoInicial) {
            System.out.println(RED + "\nErro ao mostrar dados\nDados inseridos nao estão corretos!\n" + RESET);
            return;
        }

        //ciclo para calcular o total de votos de cada partido
        for (int i = 0; i < distritos.size(); i++) {
            totalAD += ad.get(i);
            totalPs += ps.get(i);
            totalCH += ch.get(i);
            totalIL += il.get(i);
            totalBE += be.get(i);
        }


        //descobrir quem é o mais votado
        maisVotado = totalAD;
        if (maisVotado < totalPs) maisVotado = totalPs;
        if (maisVotado < totalCH) maisVotado = totalCH;
        if (maisVotado < totalIL) maisVotado = totalIL;
        if (maisVotado < totalBE) maisVotado = totalBE;

        //descobrir se existe mais que um vencedor
        if (maisVotado == totalAD) {
            vencedores++;
            partidosVencedores.add("AD");
        }
        if (maisVotado == totalPs) {
            vencedores++;
            partidosVencedores.add("PS");
        }
        if (maisVotado == totalCH) {
            vencedores++;
            partidosVencedores.add("CH");
        }
        if (maisVotado == totalIL) {
            vencedores++;
            partidosVencedores.add("IL");
        }
        if (maisVotado == totalBE) {
            vencedores++;
            partidosVencedores.add("BE");
        }

        if (vencedores > 1) {
            System.out.println(BLUE + "\n  Listas dos partidos vencedores" + RESET);
        } else {
            System.out.println(BLUE + "\n  Lista do partido vencedor" + RESET);
        }

        do {
            //mostrar em tabela
            System.out.printf(CIAN + "\n%13s\n" + RESET, partidosVencedores.get(countwhile));

            //separar
            for (int i = 0; i < 28; i++) {
                System.out.print(BLACK + "-" + RESET);
            }

            //quebra de linha
            System.out.println();

            //cabeçalho da tabela
            System.out.printf(BLACK + "| " + BLUE + "%-10s" + BLACK + " | " + BLUE + "%-11s" + BLACK + " |\n" + RESET, "Distrito", "Votos");

            //separar
            for (int i = 0; i < 28; i++) {
                System.out.print(BLACK + "-" + RESET);
            }

            //quebra de linha
            System.out.println();

            //ciclo para passar as informaçoes para o array temporario para mais a frente ordenar
            for (int i = 0; i < distritos.size(); i++) {
                //adiciona o indice do distrito na primeira coluna
                arrayTemporario[i][0] = i;

                //adiciona a quantidade de votos do distrito na segunda coluna
                switch (partidosVencedores.get(countwhile)) {
                    case "AD":
                        arrayTemporario[i][1] = ad.get(i);
                        break;
                    case "PS":
                        arrayTemporario[i][1] = ps.get(i);
                        break;
                    case "CH":
                        arrayTemporario[i][1] = ch.get(i);
                        break;
                    case "IL":
                        arrayTemporario[i][1] = il.get(i);
                        break;
                    case "BE":
                        arrayTemporario[i][1] = be.get(i);
                        break;
                }
            }

            //ordenar o array temporario por ondem descendete de votos
            Arrays.sort(arrayTemporario, (a, b) -> {
                int num1 = b[1];
                int num2 = a[1];
                return Integer.compare(num1, num2);
            });

            //ciclo para mostrar o resultado
            for (int i = 0; i < distritos.size(); i++) {
                System.out.printf(BLACK + "| " + GREEN + "%-10s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, distritos.get(arrayTemporario[i][0]), arrayTemporario[i][1]);
            }

            //separar
            for (int i = 0; i < 28; i++) {
                System.out.print(BLACK + "-" + RESET);
            }

            //quebra de linha
            System.out.println();


            countwhile++;
        } while (countwhile < vencedores);

    }

    private static void MaisVotadoPorDistrito() {
        String partidoMaisVotado = "";
        int numeroDeVotos = 0;
        double percentagem = 0;

        //validar se pode mostrar
        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro ao mostrar dados\nNão existe dados para montar!\n" + RESET);
            return;
        } else if (!validacaoInicial) {
            System.out.println(RED + "\nErro ao mostrar dados\nDados inseridos nao estão corretos!\n" + RESET);
            return;
        }


        //mostrar em tabela
        System.out.printf(CIAN + "\n%s\n" + RESET, "Partido(s) com mais votos por destrito");

        //separar
        for (int i = 0; i < 36; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        //cabeçalho da tabela
        System.out.printf(BLACK + "| " + BLUE + "%-7s" + BLACK + " | " + BLUE + "%-8s" + BLACK + " | " + BLUE + "%-11s" + BLACK + " |\n" + RESET, "Partido", "Votos", "Percentagem");

        //ciclo para correr os distritos
        for (int i = 0; i < distritos.size(); i++) {
            //separar
            for (int j = 0; j < 36; j++) {
                System.out.print(BLACK + "-" + RESET);
            }

            //quebra de linha
            System.out.println();

            //mostrar o distrito a que se refere
            System.out.printf(BLACK + "| " + CIAN + "%-32s" + BLACK + " |\n" + RESET, distritos.get(i));

            //separar
            for (int j = 0; j < 36; j++) {
                System.out.print(BLACK + "-" + RESET);
            }

            //quebra de linha
            System.out.println();

            //descobrir o maior numero de votos
            numeroDeVotos = ad.get(i);
            if (numeroDeVotos < ps.get(i)) numeroDeVotos = ps.get(i);
            if (numeroDeVotos < ch.get(i)) numeroDeVotos = ch.get(i);
            if (numeroDeVotos < il.get(i)) numeroDeVotos = il.get(i);
            if (numeroDeVotos < be.get(i)) numeroDeVotos = be.get(i);

            //calcular a percentagem
            percentagem = (double) numeroDeVotos / total.get(i) * 100;
            //arredondar para 2 casas decimal apenas
            percentagem = Math.round(percentagem * 100.0) / 100.0;

            //mostrar o(s) partido(s)
            if (numeroDeVotos == ad.get(i))
                System.out.printf(BLACK + "| " + GREEN + "%-7s" + BLACK + " | " + RESET + "%-8s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "AD", numeroDeVotos, percentagem + "%");
            if (numeroDeVotos == ps.get(i))
                System.out.printf(BLACK + "| " + GREEN + "%-7s" + BLACK + " | " + RESET + "%-8s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "PS", numeroDeVotos, percentagem + "%");
            if (numeroDeVotos == ch.get(i))
                System.out.printf(BLACK + "| " + GREEN + "%-7s" + BLACK + " | " + RESET + "%-8s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "CH", numeroDeVotos, percentagem + "%");
            if (numeroDeVotos == il.get(i))
                System.out.printf(BLACK + "| " + GREEN + "%-7s" + BLACK + " | " + RESET + "%-8s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "IL", numeroDeVotos, percentagem + "%");
            if (numeroDeVotos == be.get(i))
                System.out.printf(BLACK + "| " + GREEN + "%-7s" + BLACK + " | " + RESET + "%-8s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "BE", numeroDeVotos, percentagem + "%");


        }


        //fechar a tabela
        for (int i = 0; i < 36; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();
    }

    private static void PartidoMaisVotado() {
        int totalAD = 0, totalPs = 0, totalCH = 0, totalIL = 0, totalBE = 0, maisVotado = 0, totalDeVotos = 0;
        double percentagem = 0;

        //validar se pode mostrar o partido mais votado
        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro ao mostrar dados\nNão existe dados para montar!\n" + RESET);
            return;
        } else if (!validacaoInicial) {
            System.out.println(RED + "\nErro ao mostrar dados\nDados inseridos nao estão corretos!\n" + RESET);
            return;
        }

        //ciclo para calcular o total de votos de cada partido
        for (int i = 0; i < distritos.size(); i++) {
            totalAD += ad.get(i);
            totalPs += ps.get(i);
            totalCH += ch.get(i);
            totalIL += il.get(i);
            totalBE += be.get(i);
        }


        //descobrir quem é o mais votado
        maisVotado = totalAD;
        if (maisVotado < totalPs) maisVotado = totalPs;
        if (maisVotado < totalCH) maisVotado = totalCH;
        if (maisVotado < totalIL) maisVotado = totalIL;
        if (maisVotado < totalBE) maisVotado = totalBE;


        //mostrar em tabela
        System.out.printf(CIAN + "\n%35s\n" + RESET, "| Partido(s) com mais votos |");

        //separar
        for (int i = 0; i < 43; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        //cabeçalho da tabela
        System.out.printf(BLACK + "| " + BLUE + "%-11s" + BLACK + " | " + BLUE + "%-11s" + BLACK + " | " + BLUE + "%-11s" + BLACK + " |\n" + RESET, "Partido", "Votos", "Percentagem");

        //separar
        for (int i = 0; i < 43; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        //calcular o total de votos
        for (int i = 0; i < distritos.size(); i++) {
            totalDeVotos += total.get(i);
        }
        //calcular a percentagem
        percentagem = (double) maisVotado / totalDeVotos * 100;
        //arredondar para 2 casas decimal apenas
        percentagem = Math.round(percentagem * 100.0) / 100.0;

        //mostrar o(s) partido(s)
        if (maisVotado == totalAD)
            System.out.printf(BLACK + "| " + GREEN + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "AD", maisVotado, percentagem + "%");
        if (maisVotado == totalPs)
            System.out.printf(BLACK + "| " + GREEN + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "PS", maisVotado, percentagem + "%");
        if (maisVotado == totalCH)
            System.out.printf(BLACK + "| " + GREEN + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "CH", maisVotado, percentagem + "%");
        if (maisVotado == totalIL)
            System.out.printf(BLACK + "| " + GREEN + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "IL", maisVotado, percentagem + "%");
        if (maisVotado == totalBE)
            System.out.printf(BLACK + "| " + GREEN + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " | " + RESET + "%-11s" + BLACK + " |\n" + RESET, "BE", maisVotado, percentagem + "%");


        //fechar a tabela
        for (int i = 0; i < 43; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

    }

    private static void DistritoMaisVotos() {
        int maxVotos = 0;

        //validar se pode mostrar a tabela
        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro ao mostrar dados\nNão existe dados para montar!\n" + RESET);
            return;
        } else if (!validacaoInicial) {
            System.out.println(RED + "\nErro ao mostrar dados\nDados inseridos nao estão corretos!\n" + RESET);
            return;
        }

        //ciclo para ver qual é o maior valor
        for (int i = 0; i < distritos.size(); i++) {
            //a primeira vez atribui o primeiro valor do array a vareavel, depois compara com os outros
            if (i == 0) maxVotos = total.get(i);
            else {
                if (maxVotos < total.get(i)) {
                    maxVotos = total.get(i);
                }
            }
        }

        //mostrar em tabela
        System.out.printf(CIAN + "\n| %s |\n" + RESET, "Distrito(s) com mais votos");

        //separar
        for (int i = 0; i < 30; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        //cabeçalho da tabela
        System.out.printf(BLACK + "| " + BLUE + "%-11s" + BLACK + " | " + BLUE + "%-12s" + BLACK + " |\n" + RESET, "Distrito(s)", "Voto(s)");

        //separar
        for (int i = 0; i < 30; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        //mostrar o(s) destrito(s)
        for (int i = 0; i < distritos.size(); i++) {
            if (total.get(i) == maxVotos) {
                System.out.printf(BLACK + "| " + GREEN + "%-11s" + BLACK + " | " + RESET + "%-12d" + BLACK + " |\n" + RESET, distritos.get(i), total.get(i));
            }
        }


        //fechar a tabela
        for (int i = 0; i < 30; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

    }

    private static void MostrarTabela() {


        //validar se pode mostrar a tabela
        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro ao montar a tabela\nNão existe dados para montar na tabela!\n" + RESET);
            return;
        }

        //cabeça da tabela
        System.out.printf(CIAN + "\n %90s \n" + RESET, "| Votações por destrito |");

        //inicio da tabela
        for (int i = 0; i < 157; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        System.out.printf(BLACK + "| " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | " + BLUE + "%-10S" + BLACK + " | \n" + RESET,
                "Distrito", "Inscritos", "Votantes", "Nulos", "Brancos", "AD", "PS", "CH", "IL", "BE", "Outros", "Total");

        //separação da tabela
        for (int i = 0; i < 157; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();

        //mostrar dados na tabela
        for (int i = 0; i < distritos.size(); i++) {
            System.out.printf(BLACK + "| " + GREEN + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | " + RESET + "%-10S" + BLACK + " | \n" + RESET,
                    distritos.get(i), inscritos.get(i), votantes.get(i), nulos.get(i), brancos.get(i), ad.get(i), ps.get(i), ch.get(i), il.get(i), be.get(i), outros.get(i), total.get(i));
        }

        //fim da tabela
        for (int i = 0; i < 157; i++) {
            System.out.print(BLACK + "-" + RESET);
        }

        //quebra de linha
        System.out.println();
    }

    private static void EscreverBaseDados() {
        ArrayList<String> tem = new ArrayList<>();

        //validar se pode escrever no txt
        if (distritos.isEmpty()) {
            System.out.println(RED + "\nErro ao escrever na base de dados\nNão existe dados para escrever!\n" + RESET);
            return;
        } else if (!validacaoInicial) {
            System.out.println(RED + "\nErro ao escrever na base de dados\nDados inseridos nao estao corretos!\n" + RESET);
            return;
        }

        //criar o arraylist para escrever no txt
        for (int i = 0; i < distritos.size(); i++) {
            tem.add(distritos.get(i) + ";" + inscritos.get(i) + ";" + votantes.get(i) + ";" + nulos.get(i) + ";" + brancos.get(i) + ";" + ad.get(i) + ";" + ps.get(i) + ";" + ch.get(i) + ";" + il.get(i) + ";" + be.get(i));
        }

        //escrever o array no txt
        try {
            Files.write(Path.of("distritos.txt"), tem);

            //avisar o utilidor que foi bem sucedido
            System.out.println(GREEN + "\nDados guardados na base de dados com sucesso!\n" + RESET);

            //mudar a variavel para saber que os dados foram guardados
            guardadoNaBD = true;
        } catch (IOException e) {
            System.out.println("Erro a escrever no ficheiro!");
        }

    }

    private static void PreencherBaseDados() {
        String linha;
        boolean validacao = true, erros = false;

        // preenche os arrays com as informações do ficheiro
        try {
            //vai buscar as informações do txt
            List<String> texto = Files.readAllLines(Path.of("distritos.txt"), StandardCharsets.UTF_8);
            for (int i = 0; i < texto.size(); i++) {

                linha = texto.get(i);
                String[] temp = linha.split(";");

                //validar se existe dados na linha
                if (!linha.isEmpty()) {
                    try {
                        distritos.add(temp[0]);
                        try {
                            inscritos.add(Integer.valueOf(temp[1]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            inscritos.add(-1);
                            erros = true;
                        }
                        try {
                            votantes.add(Integer.valueOf(temp[2]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            votantes.add(-1);
                            erros = true;
                        }
                        try {
                            nulos.add(Integer.valueOf(temp[3]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            nulos.add(-1);
                            erros = true;
                        }
                        try {
                            brancos.add(Integer.valueOf(temp[4]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            brancos.add(-1);
                            erros = true;
                        }
                        try {
                            ad.add(Integer.valueOf(temp[5]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            ad.add(-1);
                            erros = true;
                        }
                        try {
                            ps.add(Integer.valueOf(temp[6]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            ps.add(-1);
                            erros = true;
                        }
                        try {
                            ch.add(Integer.valueOf(temp[7]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            ch.add(-1);
                            erros = true;
                        }
                        try {
                            il.add(Integer.valueOf(temp[8]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            il.add(-1);
                            erros = true;
                        }
                        try {
                            be.add(Integer.valueOf(temp[9]));
                        } catch (Exception e) {
                            // insere −1 para nao dar erro a mostrar e no futuro o utilizador saber onde tem de atualizar os dados
                            be.add(-1);
                            erros = true;
                        }
                    } catch (Exception e) {
                        System.out.println(RED + "\nExiste um erro nesta linha da base de dados, por favor corrija antes de continuar." + RESET);
                        System.out.println(RED + linha + RESET);
                        //validacao = false;
                    }
                    if (erros) {
                        System.out.println(RED + "\nExiste um erro nesta linha da base de dados, por favor corrija antes de continuar." + RESET);
                        System.out.println(RED + linha + RESET);
                        //validacao = false;
                        erros = false;
                    }
                }
            }

            //quebra de linha
            System.out.println();

            //caso de erro na leitura da base de dados
            if (!validacao) {
                return;
            }

            if (distritos.isEmpty()) {
                System.out.println(RED + "\nNao existe dados na base de dados!\n" + RESET);
                return;
            }

            //preencher o array outros
            CalcularOutros(-1);

            //preencher o array total
            CalcularTotal(-1);

            //validar os dados
            ValidarDados();

        } catch (IOException e) {
            System.out.println(RED + "Erro, Base de Dados não encontrada!" + RESET);
        }

    }

    private static void ValidarDados() {
        int count = 0, soma = 0;

        //informa o utilizador do começo da validação de dados
        System.out.println(YELLOW + "\nIniciando a validação da base de dados\n" + RESET);

        //validar os dados
        for (int i = 0; i < distritos.size(); i++) {
            //validar os inscritos
            if (inscritos.get(i) < total.get(i)) {
                System.out.println(RED + "O destrito " + distritos.get(i) + " tem mais votantes que inscritos!!!" + RESET);
                count++;
            }


            //validar os votantes
            if (votantes.get(i) != (nulos.get(i) + brancos.get(i) + ad.get(i) + ps.get(i) + ch.get(i) + il.get(i) + be.get(i) + outros.get(i))) {
                System.out.println(RED + "No destrito " + distritos.get(i) + " o numero de votos nao é igual ao numero de votantes!!!" + RESET);
                count++;
            }

            //validar os votantes
            if (outros.get(i) < 0 || inscritos.get(i) < 0 || votantes.get(i) < 0 || nulos.get(i) < 0 || brancos.get(i) < 0 || ad.get(i) < 0 || ps.get(i) < 0 || ch.get(i) < 0 || il.get(i) < 0 || be.get(i) < 0) {
                System.out.println(RED + "Existe erros no destrito " + distritos.get(i) + ", os erros foram marcados com \"-1\", visualize a tabela para ver os erros!!!" + RESET);
                count++;
            }
        }

        //mostra a quantidade de erros ou se foi bem sucedida a validação
        switch (count) {
            case 0:
                System.out.println(GREEN + "Dados validados com sucesso!\n" + RESET);
                validacaoInicial = true;
                break;
            case 1:
                System.out.println(RED + "\nExiste 1 erro na base de dados, por favor corrija antes de continuar!\n" + RESET);
                validacaoInicial = false;
                break;
            default:
                System.out.println(RED + "\nExistem " + count + " erros na base de dados, por favor corrija antes de continuar!\n" + RESET);
                validacaoInicial = false;
                break;
        }


    }

    private static void CalcularTotal(int opcao) {
        int numero = 0;

        // se for -1 é para criar, se for 0 ou maior é para alterar os valores dessa posição
        if (opcao == -1) {
            for (int i = 0; i < distritos.size(); i++) {
                //obter o total de votos
                numero = nulos.get(i) + brancos.get(i) + ad.get(i) + ps.get(i) + ch.get(i) + il.get(i) + be.get(i) + outros.get(i);
                total.add(numero);
            }
        } else if (opcao >= 0) {
            //recalcular o total de votos
            numero = nulos.get(opcao) + brancos.get(opcao) + ad.get(opcao) + ps.get(opcao) + ch.get(opcao) + il.get(opcao) + be.get(opcao) + outros.get(opcao);
            total.set(opcao, numero);

            //para saber que os dados nao estao guardados
            guardadoNaBD = false;
        } else {
            System.out.println(RED + "Erro a calcular os votos totais!" + RESET);
        }
    }

    private static void CalcularOutros(int opcao) {
        int numero = 0;

        // se for -1 é para criar, se for 0 ou maior é para alterar os valores dessa posição
        if (opcao == -1) {
            for (int i = 0; i < distritos.size(); i++) {
                //obter a quantidade para a coluna outros
                numero = votantes.get(i) - (nulos.get(i) + brancos.get(i) + ad.get(i) + ps.get(i) + ch.get(i) + il.get(i) + be.get(i));
                if (numero < 0) {
                    numero = -1;
                }
                outros.add(numero);
            }
        } else if (opcao >= 0) {
            //recalcular a quantidade para a coluna outros
            numero = votantes.get(opcao) - (nulos.get(opcao) + brancos.get(opcao) + ad.get(opcao) + ps.get(opcao) + ch.get(opcao) + il.get(opcao) + be.get(opcao));
            if (numero < 0) {
                numero = -1;
            }
            outros.set(opcao, numero);

            //para saber que os dados nao estao guardados
            guardadoNaBD = false;
        } else {
            System.out.println(RED + "Erro a calcular os dados de outros partidos!" + RESET);
        }

    }
}