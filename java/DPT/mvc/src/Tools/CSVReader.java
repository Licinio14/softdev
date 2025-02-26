package Tools;

import Domain.Sale;
import Domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static ArrayList<User> readUserFileToArray(String filePath) throws FileNotFoundException {
        // instanciar o array de users (vazio)
        ArrayList<User> usersArrayRead = new ArrayList<User>();

        //instanciar scanner para ler o ficheiro (caminho passado por parametro)
        Scanner sc = new Scanner(new File(filePath));

        //ignorar a primeira linha
        sc.nextLine();

        //ciclo que vai iterar para cada linha do ficheiro
        while (sc.hasNextLine()) {

            //Guardamos toda a linha na variavel:linha
            String line = sc.nextLine();

            // Criamos um array de strings, onde cada posiçao tera uma colina da linha
            String[] separatedLine = line.split(";");

            // criar objeto user
            User newUser = new User(separatedLine[0],separatedLine[1],separatedLine[2]);

            //Adicionar o novo User ao Array
            usersArrayRead.add(newUser);
        }

        // fechar o scanner
        sc.close();

        return usersArrayRead;
    }

    public static ArrayList<Sale> readSalesFileToArray(String filePath) throws FileNotFoundException {
        // instanciar o array de users (vazio)
        ArrayList<Sale> salesArrayRead = new ArrayList<Sale>();

        //instanciar scanner para ler o ficheiro (caminho passado por parametro)
        Scanner sc = new Scanner(new File(filePath));

        //ignorar a primeira linha
        sc.nextLine();

        //ciclo que vai iterar para cada linha do ficheiro
        while (sc.hasNextLine()) {

            //Guardamos toda a linha na variavel:linha
            String line = sc.nextLine();

            // Criamos um array de strings, onde cada posiçao tera uma colina da linha
            String[] separatedLine = line.split(",");

            // criar objeto user
            Sale newSale = new Sale(separatedLine[0],separatedLine[1],Double.parseDouble(separatedLine[2]),Double.parseDouble(separatedLine[3]));

            //Adicionar o novo User ao Array
            salesArrayRead.add(newSale);
        }

        // fechar o scanner
        sc.close();

        return salesArrayRead;
    }
}

