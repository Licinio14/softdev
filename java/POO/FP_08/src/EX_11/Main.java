package EX_11;

public class Main {
    public static void main(String[] args) {

        Conta cliente1 = new Conta(1,3924.35,"Marina");
        Conta cliente2 = new Conta(2,248.47,"Sabrina");
        Conta cliente3 = new Conta(4,785362.45,"Leandro");

        cliente1.MostrarConta();
        System.out.println(cliente1.getTitular() + " vai depositar 1000€: ");
        cliente1.Depositar(1000);
        cliente1.MostrarSaldo();

        System.out.println("_________________________________________");

        System.out.println(cliente1.getTitular() + " vai levantar 120€: ");
        cliente1.Levantar(120);
        cliente1.MostrarSaldo();

        System.out.println("__________________________________________");

        cliente2.MostrarConta();
        System.out.println();
        cliente3.MostrarConta();

        System.out.println("__________________________________________");

        System.out.println("o " + cliente3.getTitular() + " vai transferir 1678.41 para o " + cliente2.getTitular());
        cliente3.Transferencia(1678.41,cliente2);

        System.out.println("__________________________________________");

        cliente1.MostrarConta();
        System.out.println();
        cliente2.MostrarConta();
        System.out.println();
        cliente3.MostrarConta();

        System.out.println("__________________________________________");



    }
}
