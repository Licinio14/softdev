import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 1;
        while (op != 0) {
            System.out.println("1-Ler ficheiro para string");
            System.out.println("2-Ler ficheiro para array");
            System.out.println("3-Escrever string para ficheiro");
            System.out.println("4-Escrever array para ficheiro");
            System.out.println("5-Trocar conteúdo 2 ficheiros");
            op = in.nextInt();

            if (op == 0) break;
            else if (op == 1) ex01a_v2();
            else if (op == 2) ex01b_v2();
            else if (op == 3) ex01c_v2();
            else if (op == 4) ex01d_v2();
            else if (op == 5) ex02();
            else System.out.println("Opção inválida");
        }

    }

    private static void ex01a_v2() {
        Path caminho = Path.of("ex01.txt");

        try {
            String texto = Files.readString(caminho, StandardCharsets.UTF_8);
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ex01a() {
        // a. Ler um ficheiro de texto para uma única string e o apresente o
        // seu conteúdo.

        try {
            BufferedReader br = new BufferedReader(new FileReader("ex01.txt"));
            //String linha = "";
            //String texto = "";

            String linha = "", texto = "";
            while ((linha = br.readLine()) != null) {
                texto += linha + "\n";
            }

            System.out.println(texto);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ex01b_v2() {
        Path caminho = Path.of("ex01.txt");

        try {
            List<String> texto = Files.readAllLines(caminho, StandardCharsets.UTF_8);
            for (int i = 0; i < texto.size(); i++) {
                System.out.println("Linha " + (i + 1) + ": " + texto.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ex01b() {
        // b. Ler um ficheiro de texto para um array de strings, em que cada
        // linha é uma posição do array, e apresente o seu conteúdo.
        try {
            BufferedReader br = new BufferedReader(new FileReader("ex01.txt"));

            String linha = "";
            ArrayList<String> texto = new ArrayList<>();
            while ((linha = br.readLine()) != null) {
                texto.add(linha);
            }

            for (int i = 0; i < texto.size(); i++) {
                System.out.println("Linha " + (i + 1) + ": " + texto.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ex01c_v2() {
        in = new Scanner(System.in);
        System.out.println("Qual o texto a inserir?");
        String texto = in.nextLine();

        try {
            Files.writeString(Path.of("ex01.txt"), texto);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ex01c() {
        // c. Escrever um texto digitado pelo utilizador e gravar o mesmo num ficheiro.
        in = new Scanner(System.in);
        System.out.println("Qual o texto a inserir?");
        String texto = in.nextLine();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ex01.txt"));
            //BufferedWriter bw = new BufferedWriter(new FileWriter("ex01.txt", true));
            bw.write(texto);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ex01d_v2() {
        ArrayList<String> texto = new ArrayList<>();
        texto.add("Primeira linha");
        texto.add("Segunda linha");
        texto.add("Terceira linha");

        try {
            Files.write(Path.of("ex01.txt"), texto);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ex01d() {
        // d. Preencher um array de strings e escrever cada linha num ficheiro.

        ArrayList<String> texto = new ArrayList<>();
        texto.add("Primeira linha");
        texto.add("Segunda linha");
        texto.add("Terceira linha");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ex01.txt"));
            //BufferedWriter bw = new BufferedWriter(new FileWriter("ex01.txt", true));
            for (int i = 0; i < texto.size(); i++) {
                bw.write(texto.get(i));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ex02() {
        // 2. Crie uma aplicação que leia o conteúdo de dois ficheiros
        // (a.txt e b.txt) e troque os seus conteúdos (o primeiro
        // ficheiro deve ficar com o conteúdo do segundo e vice-versa


    }
}