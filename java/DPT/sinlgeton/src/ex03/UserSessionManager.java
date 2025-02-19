package ex03;

import java.util.Date;
import java.util.Random;

public class UserSessionManager {
    private static UserSessionManager session;

    private int sessionToken;
    private String lastAccess;

    private UserSessionManager() {
        this.sessionToken = createToken();
        this.lastAccess = getDateNow();
    }

    public static UserSessionManager getSession(){
        if (session == null){
            session = new UserSessionManager();
        }
        return session;
    }

    public int getSessionToken() {
        return sessionToken;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess() {
        this.lastAccess = getDateNow();
    }

    private int createToken(){
        StringBuilder token = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < 8; i++) {
            token.append(rd.nextInt(10));
        }

        return Integer.parseInt(String.valueOf(token));
    }

    public void showLastAcces(){

    }

    private String getDateNow(){
        //return String.valueOf(System.currentTimeMillis());
        return String.valueOf(new Date());
    }
}
