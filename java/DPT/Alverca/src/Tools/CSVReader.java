package Tools;

import Domain.Player;
import Domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static ArrayList<User> readUserFileToArray(String filePath) throws FileNotFoundException {

        // Instanciar o Array de Users (vazio)
        ArrayList<User> usersArrayRead = new ArrayList<User>();

        // Instanciar Scanner para ler o ficheiro (caminho passado por parâmetro)
        Scanner sc = new Scanner(new File(filePath));

        // Ignorar a primeira linha (cabeçalho)
        sc.nextLine();

        // Ciclo que vai iterar para cada linha do ficheiro
        while (sc.hasNextLine()) {

            // Guardamos toda a linha na variável: linha
            String line = sc.nextLine();

            // Criamos um Array de Strings, onde cada posição terá uma coluna da linha
            String[] separatedLine = line.split(";");

            // Criar objeto User
            User newUser = new User(separatedLine[0], separatedLine[1], separatedLine[2]);

            // Adicionar novo User ao Array
            usersArrayRead.add(newUser);
        }

        return usersArrayRead;
    }

    public static ArrayList<Player> readPlayerFileToArray(String filePath) throws FileNotFoundException {

        // Instanciar o Array de Users (vazio)
        ArrayList<Player> playersArrayRead = new ArrayList<Player>();

        // Instanciar Scanner para ler o ficheiro (caminho passado por parâmetro)
        Scanner sc = new Scanner(new File(filePath));

        // Ignorar a primeira linha (cabeçalho)
        sc.nextLine();

        // Ciclo que vai iterar para cada linha do ficheiro
        while (sc.hasNextLine()) {

            // Guardamos toda a linha na variável: linha
            String line = sc.nextLine();

            // Criamos um Array de Strings, onde cada posição terá uma coluna da linha
            String[] separatedLine = line.split(";");

            // Criar objeto User
            Player newPlayer = new User(separatedLine[0], separatedLine[1], separatedLine[2]);

            // Adicionar novo User ao Array
            playersArrayRead.add(newPlayer);
        }

        return playersArrayRead;
    }

}
