import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<String> tb1 = new ArrayList<>();
    static ArrayList<String> tb2 = new ArrayList<>();
    static ArrayList<String> exam = new ArrayList<>();
    static ArrayList<String> classi = new ArrayList<>();
    static int mbcount = 0, counttb1 = 0, counttb2 = 0, countexam = 0, countfinal = 0;
    static double maiornota = 0, menornota = 0, tb1m = 0, tb2m = 0, exampm = 0, finalm = 0, tb1p = 0, tb2p = 0, examp = 0,finalp;
    static double[] notafinal = new double[20];


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean vali = true;
        int resposta;

        //preencher as lista primeiro
        PreencherListas();

        do{

            System.out.println("O que pretende fazer?");
            System.out.println("|1 - Inserir alunos|\t |2 - Editar alunos/notas|\t |3 - Eliminar alunos|\t |4 - Lista de alunos|\t |5 - Output final|\t |0 - Sair|");

                resposta = in.nextInt();
                if (resposta >= 0 && resposta <= 5){
                    switch (resposta){
                        case 0:
                            System.out.println("Terminando o programa");
                            return;
                        case 1:
                            InserirAlunos();
                            break;
                        case 2:
                            EditarAlunos();
                            break;
                        case 3:
                            EliminarAlunos();
                            break;
                        case 4:
                            MostrarAlunos();
                            break;
                        case 5:
                            Output();
                            break;
                    }
                }else {
                    System.out.println("Insira uma resposta valida!");
                }


        }while (vali);

    }

    private static void Output() {

        Classificacao();

        ArrayList<String> tem = new ArrayList<>();
        tem.add("Nome\t\t\tClassificação");
        for (int i = 0; i < nomes.size(); i++) {
            tem.add(nomes.get(i) + "\t\t\t" + classi.get(i));
        }
        tem.add("******************************************************************");
        tem.add("Melhor Nota Final: " + maiornota + " valores");
        tem.add("Pior Nota Final: " + menornota + " valores");
        tem.add("Percentagens de Notas Positivas:");
        tem.add("Trabalho 1: " + tb1p + "%");
        tem.add("Trabalho 2: " + tb2p + "%");
        tem.add("Exame: " + examp + "%");
        tem.add("Final: " + finalp + "%");
        tem.add("Médias das Notas:");
        tem.add("Trabalho 1: " + tb1m + " valores");
        tem.add("Trabalho 2: " + tb2m + " valores");
        tem.add("Exame: " + exampm + " valores");
        tem.add("Final: " + finalm + " valores");
        tem.add(mbcount + " alunos com classificação Muito Bom");
        try{
            Files.write(Path.of("output.txt"),tem);
        }catch (IOException e){
            System.out.println("Erro a escrever no ficheiro!");
        }
        for (String s : tem) {
            System.out.println(s);
        }


    }

    private static void Classificacao() {
        //garantir que tudo ta a 0
        mbcount = 0; tb1p = 0; tb2p = 0; examp = 0;finalp = 0; counttb1 = 0; counttb2 = 0; countexam = 0; countfinal = 0;
        maiornota = 0; menornota = 0; tb1m = 0; tb2m = 0; exampm = 0; finalm = 0;
        notafinal = new double[nomes.size()];
        int max = nomes.size();
        DecimalFormat df = new DecimalFormat("#.##");

        // preencher a nota final e as classificaçoes nos arrays
        for (int i = 0; i < nomes.size(); i++) {
            int n1 = Integer.parseInt(tb1.get(i));
            int n2 = Integer.parseInt(tb2.get(i));
            int n3 = Integer.parseInt(exam.get(i));
            notafinal[i] = (n1 * 0.2) + (n2 * 0.2) + (n3 * 0.6);

            if (i == 0){
                maiornota = notafinal[i];
                menornota = notafinal[i];
            } else {
                if (notafinal[i] > maiornota){
                    maiornota = notafinal[i];
                }
                if (notafinal[i] < menornota){
                    menornota = notafinal[i];
                }
            }


            if (notafinal[i] < 5 ) {
                classi.add("Muito fraco");
            } else if (notafinal[i] >= 5 && notafinal[i] < 10) {
                classi.add("Fraco");
            } else if (notafinal[i] >= 10 && notafinal[i] < 13) {
                classi.add("Suficiente");
            } else if (notafinal[i] >= 13 && notafinal[i] < 17) {
                classi.add("Bom");
            }else if (notafinal[i] >= 17 && notafinal[i] <= 20) {
                classi.add("Muit Bom");
                mbcount++;
            }
        }

        //conta as positivas
        for (int i = 0; i < nomes.size(); i++) {
            int n1 = Integer.parseInt(tb1.get(i));
            int n2 = Integer.parseInt(tb2.get(i));
            int n3 = Integer.parseInt(exam.get(i));

            if (n1 >= 10){
                counttb1++;
            }
            if (n2 >= 10){
                counttb2++;
            }
            if (n3 >= 10){
                countexam++;
            }
            if (notafinal[i] >= 10){
                countfinal++;
            }

            tb1m += n1;
            tb2m += n2;
            exampm += n3;
            finalm += notafinal[i];


        }

        //calcula a percentagem
        tb1p = Double.parseDouble(df.format((double) counttb1 / max * 100));
        tb2p = Double.parseDouble(df.format((double) counttb2 / max * 100));
        examp = Double.parseDouble(df.format((double) countexam / max * 100));
        finalp = Double.parseDouble(df.format((double) countfinal / max * 100));

        //calcula a media
        tb1m = Double.parseDouble(df.format(tb1m / nomes.size()));
        tb2m = Double.parseDouble(df.format(tb2m / nomes.size()));
        exampm = Double.parseDouble(df.format(exampm / nomes.size()));
        finalm = Double.parseDouble(df.format(finalm / nomes.size()));


    }

    private static void EditarAlunos() {
        Scanner in = new Scanner(System.in);
        int resp = 0, index = 0, edit = 0;
        String resposta = "";
        boolean vali = true, vali2 = true;

        if (nomes.isEmpty()){
            System.out.println("Nao exeistem alunos para editar!");
            return;
        }

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Aluno " + (i + 1) + ": " + nomes.get(i));
        }

        do {
            System.out.println("Qual o numero do aluno que quer editar? Digite 0 para cancelar. 1 - " + nomes.size());
            try{
                resp = in.nextInt();
                if (resp > 0 && resp <= nomes.size()){
                    index = resp - 1;
                    vali = false;
                } else if (resp == 0) {
                    System.out.println("Cancelando");
                    return;
                } else {
                    System.out.println("Escolha um aluno valido!");
                }
            }catch (InputMismatchException e){
                System.out.println("Insira o numero do aluno");
            }
        }while (vali);
        vali = true;

        do {
            System.out.println("Aluno: " + nomes.get(index) + "\t\tTB1:" + tb1.get(index) + "\tTB2:" + tb2.get(index) + "\tExam:" + exam.get(index));
            System.out.println("O que pretende editar?\n|1 - Nome|\t|2 - TB1|\t|3 - TB2|\t|4 - Exam|\t|0 - Cancelar|");
            try{
                resp = in.nextInt();


                if (resp == 2 || resp == 3 || resp == 4){
                    do {
                        System.out.println("Qual é o novo valor?");
                        try{
                            edit = in.nextInt();
                            if (edit >= 0 && edit <= 20){
                                vali2 = false;
                            }else{
                                System.out.println("Insira um valor valido!");
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Insira apenas numeros!");
                        }
                    }while (vali2);

                }else if (resp == 1){
                    System.out.println("Qual é o novo nome?");
                    in = new Scanner(System.in);
                    resposta = in.nextLine();
                }

                switch (resp){
                    case 0:
                        System.out.println("Cancelando");
                        return;
                    case 1:
                        nomes.set(index, resposta);
                        break;
                    case 2:
                        tb1.set(index, String.valueOf(edit));
                        break;
                    case 3:
                        tb2.set(index, String.valueOf(edit));
                        break;
                    case 4:
                        exam.set(index, String.valueOf(edit));
                        break;
                }

            }catch (InputMismatchException e){
                System.out.println("Insira apenas numeros!");
            }

            EscreverAlunos();

        }while (vali);


    }

    private static void EliminarAlunos() {
        Scanner in = new Scanner(System.in);
        int resp = 0;
        boolean vali = true;

        if (nomes.isEmpty()){
            System.out.println("Nao exeistem alunos para eliminar!");
            return;
        }

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Aluno " + (i + 1) + ": " + nomes.get(i));
        }

        do {
            System.out.println("Qual o numero do aluno que quer eliminar? Digite 0 para cancelar. 1 - " + nomes.size());
            try{
                resp = in.nextInt();
                if (resp > 0 && resp <= nomes.size()){
                    resp--;
                    nomes.remove(resp);
                    tb1.remove(resp);
                    tb2.remove(resp);
                    exam.remove(resp);
                    System.out.println("Aluno eliminado com sucesso!");
                    vali = false;
                } else if (resp == 0) {
                    break;
                } else {
                    System.out.println("Escolha um aluno valido!");
                }
            }catch (InputMismatchException e){
                System.out.println("Insira o numero do aluno");
            }

        }while (vali);

        EscreverAlunos();

    }

    private static void InserirAlunos() {
        Scanner in = new Scanner(System.in);
        int resp = 0;
        String resposta;
        boolean vali = true, vali2 = true;

        do {
            in = new Scanner(System.in);
            System.out.println("Qual é o nome do aluno: ");
            nomes.add(in.nextLine());

            //trabalho 1
            do {
                System.out.println("Qual é a nota do primeiro trabalho?");
                try{
                    resp = in.nextInt();
                    if (resp >= 0 && resp <= 20){
                        tb1.add(String.valueOf(resp));
                        vali2 = false;
                    }else {
                        System.out.println("Insira uma nota valida! 0 - 20!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while (vali2);
            vali2 = true;

            //trabalho 2
            do {
                System.out.println("Qual é a nota do segundo trabalho?");
                try{
                    resp = in.nextInt();
                    if (resp >= 0 && resp <= 20){
                        tb2.add(String.valueOf(resp));
                        vali2 = false;
                    }else {
                        System.out.println("Insira uma nota valida! 0 - 20!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while (vali2);
            vali2 = true;

            //Exam
            do {
                System.out.println("Qual é a nota do exame?");
                try{
                    resp = in.nextInt();
                    if (resp >= 0 && resp <= 20){
                        exam.add(String.valueOf(resp));
                        vali2 = false;
                    }else {
                        System.out.println("Insira uma nota valida! 0 - 20!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while (vali2);
            vali2 = true;

            //Inserir mais?
            do {
                System.out.println("Quer inserir mais alunos?\n|1 - Sim|\t\t|2 - Nao|");
                try{
                    resp = in.nextInt();
                    if (resp == 1){
                        vali2 = false;
                    }else if (resp == 2){
                        vali2 = false;
                        vali = false;
                    }else{
                        System.out.println("Insira uma nota valida! 0 - 20!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while (vali2);
            vali2 = true;


        }while (vali);
        EscreverAlunos();
    }

    private static void EscreverAlunos() {
        ArrayList<String> tem = new ArrayList<>();
        for (int i = 0; i < nomes.size(); i++) {
            tem.add(nomes.get(i) + ";" + tb1.get(i) + ";" + tb2.get(i) + ";" + exam.get(i));
        }
        try{
            Files.write(Path.of("nomes.txt"),tem);
        }catch (IOException e){
            System.out.println("Erro a escrever no ficheiro!");
        }
    }

    private static void MostrarAlunos() {
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Aluno: " + nomes.get(i) + "\t\tTB1:" + tb1.get(i) + "\tTB2:" + tb2.get(i) + "\tExam:" + exam.get(i));
        }
    }

    private static void PreencherListas() {
        String linha;
            try {
                List<String> texto = Files.readAllLines(Path.of("nomes.txt"), StandardCharsets.UTF_8);
                for (int i = 0; i < texto.size(); i++) {
                    linha = texto.get(i);
                    String[] temp = linha.split(";");
                    nomes.add(temp[0]);
                    tb1.add(temp[1]);
                    tb2.add(temp[2]);
                    exam.add(temp[3]);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }

}