package ex03;

import java.util.Random;

public class UserSessionManager {
    private static UserSessionManager session;

    private int sessionToken;
    private String lastAccess;

    private UserSessionManager( String lastAccess) {
        this.sessionToken = createToken();
        this.lastAccess = lastAccess;
    }

    public UserSessionManager getSession(String lastAccess){
        if (session == null){
            UserSessionManager session = new UserSessionManager(lastAccess);
        }
        return session;
    }

    private int createToken(){
        StringBuilder token = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < 8; i++) {
            token.append(rd.nextInt(10));
        }

        return Integer.parseInt(String.valueOf(token));
    }
}
