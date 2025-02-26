package Model;

import Domain.Player;
import Domain.User;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PlayerRepository {
    private ArrayList<Player> playerList;

    public PlayerRepository() throws FileNotFoundException {
        this.playerList = CSVReader.readPlayerFileToArray("Files/login_grandesNegocios.csv");
    }

    public ArrayList<User> getUsersList() {
        return playerList;
    }
}
