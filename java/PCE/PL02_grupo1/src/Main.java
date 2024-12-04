import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    static String linha;

    public static void main(String[] args) {
        boolean vali = true;
        int respo = 0;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("|1 - Ler uma unica string|\t |2 - Passar todas as linhas para o array|\t |3 - Escrever no ficheiro|\t |4 - Preencher um array de strings e passar para o ficheiro|\t|5 - Trocar ficheiros|\t|0 - Sair|");
            try{
                respo = in.nextInt();
                if (respo >=0 && respo <= 5){
                    switch (respo){
                        case 0:
                            System.out.println("Terminando o programa");
                            return;
                        case 1:
                            LerString();
                            break;
                        case 2:
                            TodasArray();
                            break;
                        case 3:
                            EscreverFicheiro();
                            break;
                        case 4:
                            PreencherComArray();
                            break;
                        case 5:
                            Trocar();
                            break;
                    }
                }else {
                    System.out.println("Escolha uma opção valida!");
                }
            }catch (InputMismatchException e){
                System.out.println("Insira numeros!");
            } catch (IOException e) {
                System.out.println("Erro ao aceder o ficheiro");
            }
        }while (vali);

    }

    private static void Trocar() throws IOException {
        // trocar o conteudo dos ficheiros
        BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
        ArrayList<String> texto = new ArrayList<>();
        while ((linha = br.readLine()) != null){
            texto.add(linha);
        }
        br.close();

        br = new BufferedReader(new FileReader("segundo.txt"));
        ArrayList<String> segundo = new ArrayList<>();
        while ((linha = br.readLine()) != null){
            segundo.add(linha);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("texto.txt"));
        for (String s : segundo) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();

        bw = new BufferedWriter(new FileWriter("segundo.txt"));
        for (String s : texto) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();



    }

    private static void PreencherComArray() throws IOException {
        //preencher um array e escrever no txt
        ArrayList<String> teste = new ArrayList<>();
        in = new Scanner(System.in);
        boolean vali = true;
        String resposta;
        int count = 0;

        do{
            count++;
            System.out.println(count + "ª informação. Digite 0 para parar.");
            resposta = in.nextLine();
            if (Objects.equals(resposta, "0")){
                vali = false;
            }else {
                teste.add(resposta);
            }
        }while (vali);


        BufferedWriter bw = new BufferedWriter(new FileWriter("texto.txt", true));
        for (String s : teste) {
            bw.newLine();
            bw.write(s);
        }
        bw.close();

    }

    private static void EscreverFicheiro() throws IOException {
        //Escrever um texto digitado pelo utilizador e gravar o mesmo num ficheiro.
        String resposta;
        in = new Scanner(System.in);
        System.out.println("Escreva o texto que pertende guardar no doc:");
        resposta = in.nextLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter("texto.txt", true));
        bw.newLine();
        bw.write(resposta);
        bw.close();
    }

    private static void TodasArray() throws IOException {
        //Ler um ficheiro de texto para um array de strings, em que cada linha é uma posição do array, e o
        //apresente o seu conteúdo.

        BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
        ArrayList<String> texto = new ArrayList<>();
        while ((linha = br.readLine()) != null){
            texto.add(linha);
        }
        br.close();
        for (String s : texto) {
            System.out.println(s);
        }
    }

    private static void LerString() throws IOException {
        //Ler um ficheiro de texto para uma única string e o apresente o seu conteúdo.
        String texto;

        BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
        linha = br.readLine();
        texto = linha;
        while (linha != null){
            linha = br.readLine();
            texto += linha;
            texto +="\n";

        }


        if (texto != null){
            System.out.println(texto);
        }else {
            System.out.println("O ficheiro esta vazio!");
        }
    }
}