package Ex_02;

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

        //_________________________________________________________________

        System.out.println("_______________________________________________________________");

        System.out.println("O cliente " + cliente1.getTitular() + " quer pedir um emprestimo de 600€");
        boolean sucessoTransferencia = cliente1.PedirEmpresimo(600);
        if (sucessoTransferencia){
            System.out.println("\n Emprestimo atribuido com sucesso\n");
            cliente1.MostrarConta();
        }else {
            System.out.println("\n O pedido de emprestimo foi recusado!");
        }

        System.out.println("_______________________________________________________________");

        System.out.println("O cliente " + cliente2.getTitular() + " quer pedir um emprestimo de 600€");
        sucessoTransferencia = cliente2.PedirEmpresimo(600);
        if (sucessoTransferencia){
            System.out.println("\n Emprestimo atribuido com sucesso\n");
            cliente2.MostrarConta();
        }else {
            System.out.println("\n O pedido de emprestimo foi recusado!");
        }

        System.out.println("_______________________________________________________________");

        System.out.println("O cliente " + cliente1.getTitular() + " quer pedir um emprestimo de 600€");
        sucessoTransferencia = cliente1.PedirEmpresimo(600);
        if (sucessoTransferencia){
            System.out.println("\n Emprestimo atribuido com sucesso\n");
            cliente1.MostrarConta();
        }else {
            System.out.println("\n O pedido de emprestimo foi recusado!");
        }



    }
}
