package Model;

import Domain.User;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> userList;

    public  UserRepository() throws FileNotFoundException {
        this.userList = CSVReader.readUserFileToArray("Files/login_grandesNegocios.csv");
    }

    public  ArrayList<User> getUserList(){
        return userList;
    }
}
