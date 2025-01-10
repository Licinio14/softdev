package EX_11;

public class Main {
    public static void main(String[] args) {

        Conta cliente1 = new Conta("1","Marina");
        Conta cliente2 = new Conta("2","Sabrina");
        Conta cliente3 = new Conta("3","Leandro");

        cliente1.MostrarConta();
        cliente2.MostrarConta();
        cliente3.MostrarConta();
        System.out.println();

        //_________________________________________________________________

        cliente1.Depositar(1000);
        cliente3.Depositar(50);

        cliente1.MostrarConta();
        cliente2.MostrarConta();
        cliente3.MostrarConta();
        System.out.println();


        //_________________________________________________________________

        cliente1.Levantar(150);
        cliente3.Levantar(2000);

        cliente1.MostrarConta();
        cliente2.MostrarConta();
        cliente3.MostrarConta();
        System.out.println();


        //_________________________________________________________________

        cliente3.Transferencia(50,cliente2);

        cliente1.MostrarConta();
        cliente2.MostrarConta();
        cliente3.MostrarConta();
        System.out.println();



    }
}
