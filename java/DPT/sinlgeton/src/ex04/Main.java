package ex04;

public class Main {
    public static void main(String[] args) {

        FileManager fileManager = FileManager.getFileManager("");
        fileManager.setRootDirectory("src/ex04");
        fileManager.createFile("file.txt");
        fileManager.createFile("ficheiroNovo.txt");
        fileManager.deleteFile("file.txt");
        fileManager.setRootDirectory("src");
        fileManager.createFile("tabela.csv");
        fileManager.createFile("filmes.csv");
        fileManager.createFile("jogos.csv");
        fileManager.deleteFile("tabela.csv ");

    }
}
