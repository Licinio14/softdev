import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<String> tb1 = new ArrayList<>();
    static ArrayList<String> tb2 = new ArrayList<>();
    static ArrayList<String> exam = new ArrayList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean vali = true;
        int resposta;

        //preencher as lista primeiro
        PreencherListas();

        do{

            System.out.println("O que pretende fazer?");
            System.out.println("|1 - Inserir alunos|\t |2 - Editar alunos/notas|\t |3 - Eliminar alunos|\t |4 - Lista de alunos|\t |0 - Sair|");
            try{
                resposta = in.nextInt();
                if (resposta >= 0 && resposta <= 4){
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
                    }
                }else {
                    System.out.println("Insira uma resposta valida!");
                }
            }catch (InputMismatchException e){
                System.out.println("Insira apenas numeros");
            }

        }while (vali);

    }

    private static void EditarAlunos() {
        Scanner in = new Scanner(System.in);
        int index = 0, respo = 0;
        boolean vali = true, vali2 = true;
        String edit;

        MostrarAlunos();

        do{
            System.out.println("Qual é o Aluno que pretende editar? 0 - Para cancelar");
            try{
                index = in.nextInt();
                if (index > 0 && index <= nomes.size()){
                    index--;
                    vali = false;
                } else if (index == 0) {
                    vali = false;
                } else {
                    System.out.println("Insira uma opção valida!");
                }
            }catch (InputMismatchException e){
                System.out.println("Insira apenas numeros!");
            }
        }while (vali);

        if (index == 0){
            System.out.println("Operação cancelada");
        }else {

            do{
                System.out.println("Aluno: " + nomes.get(index) + "\t TB1: " + tb1.get(index) + "\t TB2: " + tb2.get(index) + "\t Exam: " + exam.get(index));
                System.out.println("O que pretende editar?");
                System.out.println("|1 - Nome|\t|2 - TB1|\t|3 - TB2|\t|4 - Exam|\t|0 - Sair|");
                try{
                    respo = in.nextInt();

                    //tenho de fazer validações para os numeros
                    System.out.println("Insira o novo valor: ");
                    in = new Scanner(System.in);
                    edit = in.nextLine();
                    switch (respo){
                        case 0:
                            vali2 = false;
                            break;
                        case 1:
                            nomes.set(index,edit);
                            break;
                        case 2:
                            tb1.set(index,edit);
                            break;
                        case 3:
                            tb2.set(index,edit);
                            break;
                        case 4:
                            exam.set(index,edit);
                            break;

                    }

                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while (vali2);
            EscerverNosFicheiros();


        }
    }

    private static void EliminarAlunos() {
        Scanner in = new Scanner(System.in);
        int index;
        boolean vali = true;

        MostrarAlunos();

        do{
            System.out.println("Qual é o Aluno que pretende eliminar? 0 - Para cancelar");
            try{
                index = in.nextInt();
                if (index > 0 && index <= nomes.size()){
                    index--;
                    nomes.remove(index);
                    tb1.remove(index);
                    tb2.remove(index);
                    exam.remove(index);
                    System.out.println("Aluno removido!");
                    vali = false;
                } else if (index == 0) {
                    vali = false;
                } else {
                    System.out.println("Insira uma opção valida!");
                }
            }catch (InputMismatchException e){
                System.out.println("Insira apenas numeros!");
            }
        }while (vali);

        EscerverNosFicheiros();



    }

    private static void MostrarAlunos() {
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Aluno " + (i + 1) + "ª: " + nomes.get(i));

        }
    }

    private static void InserirAlunos() {
        Scanner in = new Scanner(System.in);
        int respo;
        boolean vali = true, vali2 = true;

        do{
            System.out.println("Digite o nome do aluno");
            in = new Scanner(System.in);
            nomes.add(in.nextLine());
            // ler com validações a nota 1
            do {
                System.out.println("Digite a nota do trabalho 1");
                try{
                    respo = in.nextInt();
                    if (respo >= 0 && respo <= 20){
                        tb1.add(String.valueOf(respo));
                        vali2 = false;
                    }else{
                        System.out.println("Insira uma nota valida!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while(vali2);
            vali2 = true;

            // ler com validações a nota 2
            do {
                System.out.println("Digite a nota do trabalho 2");
                try{
                    respo = in.nextInt();
                    if (respo >= 0 && respo <= 20){
                        tb2.add(String.valueOf(respo));
                        vali2 = false;
                    }else{
                        System.out.println("Insira uma nota valida!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while(vali2);
            vali2 = true;

            // ler com validações a nota 3
            do {
                System.out.println("Digite a nota do exam");
                try{
                    respo = in.nextInt();
                    if (respo >= 0 && respo <= 20){
                        exam.add(String.valueOf(respo));
                        vali2 = false;
                    }else{
                        System.out.println("Insira uma nota valida!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while(vali2);
            vali2 = true;

            // se quer inserir mais
            do {
                System.out.println("|1 - Inserir mais|\t\t\t|0 - Parar de inserir|");
                try{
                    respo = in.nextInt();
                    if (respo == 0){
                        vali2 = false;
                        vali = false;
                    }else if (respo == 1){
                        vali2= false;
                    } else{
                        System.out.println("Insira opção valida!");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Insira apenas numeros!");
                }
            }while(vali2);
            vali2 = true;

        }while (vali);

        EscerverNosFicheiros();




    }

    private static void EscerverNosFicheiros() {


        try {
            Files.write(Path.of("nomes.txt"), nomes);
            Files.write(Path.of("tb1.txt"), tb1);
            Files.write(Path.of("tb2.txt"), tb2);
            Files.write(Path.of("exam.txt"), exam);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void PreencherListas() {


        try {
            nomes = (ArrayList<String>) Files.readAllLines(Path.of("nomes.txt"), StandardCharsets.UTF_8);
            tb1 = (ArrayList<String>) Files.readAllLines(Path.of("tb1.txt"), StandardCharsets.UTF_8);
            tb2 = (ArrayList<String>) Files.readAllLines(Path.of("tb2.txt"), StandardCharsets.UTF_8);
            exam = (ArrayList<String>) Files.readAllLines(Path.of("exam.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }




    }
}