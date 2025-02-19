package ex03;

public class main {
    public static void main(String[] args) throws InterruptedException {

        UserSessionManager user = UserSessionManager.getSession();

        System.out.println("Token de Acesso: " + user.getSessionToken());
        System.out.println("Último Acesso: " + user.getLastAccess());

        Thread.sleep(5000);

        user.setLastAccess();



        System.out.println("\n\n\nToken de Acesso: " + user.getSessionToken());
        System.out.println("Último Acesso: " + user.getLastAccess());

        /*

        dia 12 de março, teste e trabalho

         */
    }
}
