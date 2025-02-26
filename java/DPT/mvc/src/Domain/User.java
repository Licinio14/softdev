package Domain;

public class User {
    private String acontType;
    private String userName;
    private String passWord;

    public User(String acontType, String userName, String passWord) {
        this.acontType = acontType;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getAcontType() {
        return acontType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
