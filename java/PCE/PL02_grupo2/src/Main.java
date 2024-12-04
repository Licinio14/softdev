import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<Integer> tb1 = new ArrayList<>();
    static ArrayList<Integer> tb2 = new ArrayList<>();
    static ArrayList<Integer> exam = new ArrayList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean vali = true;
        int resposta;

        //preencher as lista primeiro
        PreencherListas();

        do{

            System.out.println("O que pretende fazer?");
            System.out.println("|1 - Inserir alunos|\t |2 - Editar alunos/notas|\t |3 - Eliminar alunos|");
            try{
                resposta = in.nextInt();
                if (resposta >= 0 && resposta <= 3){
                    switch (resposta){
                        case 0:
                            System.out.println("Terminando o programa");
                            return;
                        case 1:
                            InserirAlunos();
                            break;
                        case 2:

                            break;
                        case 3:

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
                        tb1.add(respo);
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
                        tb2.add(respo);
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
                        exam.add(respo);
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

    private static void PreencherListas() {
        int teste;
        // buscar nomes
        try (BufferedReader br = new BufferedReader(new FileReader("nomes.txt"))){
            String linha;
            while ((linha = br.readLine()) != null){
                nomes.add(linha);
            }
            br.close();
        }catch (IOException e){
            System.out.println("Erro ao tentar ler o ficheiro nomes");
        }

        // buscar tb1
        try (BufferedReader br = new BufferedReader(new FileReader("tb1.txt"))){
            String linha;
            while ((linha = br.readLine()) != null){
                teste = Integer.parseInt(linha);
                tb1.add(teste);
            }
            br.close();
        }catch (IOException e){
            System.out.println("Erro ao tentar ler o ficheiro tb1");
        }

        // buscar tb2
        try (BufferedReader br = new BufferedReader(new FileReader("tb2.txt"))){
            String linha;
            while ((linha = br.readLine()) != null){
                teste = Integer.parseInt(linha);
                tb2.add(teste);
            }
            br.close();
        }catch (IOException e){
            System.out.println("Erro ao tentar ler o ficheiro tb2");
        }

        // buscar exam
        try (BufferedReader br = new BufferedReader(new FileReader("exam.txt"))){
            String linha;
            while ((linha = br.readLine()) != null){
                teste = Integer.parseInt(linha);
                exam.add(teste);
            }
            br.close();
        }catch (IOException e){
            System.out.println("Erro ao tentar ler o ficheiro exam");
        }




    }
}