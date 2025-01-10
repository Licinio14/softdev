package EX_11;

public class Conta {

    private String numConta;
    private double saldo = 0;
    private String titular;

    public Conta(String numConta, String titular) {
        this.numConta = numConta;
        this.titular = titular;
    }

    //gets e sets
    public String getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    //metudos
    public void Transferencia(double valor, Conta contaDestino) {

        if (this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferencia efetuada com sucesso!");
        }else {
            System.out.println("Saldo insuficiente");
        }

    }

    public void MostrarConta() {
        System.out.println("_____________________________");
        System.out.println("Conta: " + this.numConta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("_____________________________");
    }

    public void Depositar(double valor) {
        this.saldo +=  valor;
        System.out.println("Deposito efetuado com sucesso!");
    }

    public void Levantar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Levantamento efetuado com sucesso!");
        }else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void MostrarSaldo(){
        System.out.println("Saldo da conta do(a) " + this.titular + ": " + this.saldo + "€");
    }



}
