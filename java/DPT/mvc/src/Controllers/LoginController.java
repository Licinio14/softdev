package Controllers;

import Domain.User;
import Model.UserRepository;

import java.io.FileNotFoundException;

public class LoginController {

    private UserRepository userRepository;

    public LoginController() throws FileNotFoundException {
        userRepository = new UserRepository();
    }

    public String accessType(String usernameInput, String passwordInput){
        String accessType = "ERROR";

        for (User currentUser: this.userRepository.getUserList()){
            if (currentUser.getUserName().equals(usernameInput) && currentUser.getPassWord().equals(passwordInput)){
                // valid access
                accessType = currentUser.getAcontType();
            }
        }

        return accessType;
    }
}
