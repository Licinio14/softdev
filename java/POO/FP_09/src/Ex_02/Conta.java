package Ex_02;

public class Conta {

    private String numConta;
    private double saldo = 0;
    private String titular;
    private int anoAbertura = 2023;
    private double margemDeEmprestimo = 0;
    private double valorEmDivida = 0;

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

    public void AtualizarMargemEmprestimo(){
        this.margemDeEmprestimo = this.saldo * 0.9;
    }

    public void Transferencia(double valor, Conta contaDestino) {

        if (this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferencia efetuada com sucesso!");
            this.AtualizarMargemEmprestimo();
            contaDestino.AtualizarMargemEmprestimo();
        }else {
            System.out.println("Saldo insuficiente");
        }

    }

    public void MostrarConta() {
        System.out.println("_____________________________");
        System.out.println("Conta: " + this.numConta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Margem de emprestimo: " + this.margemDeEmprestimo);
        System.out.println("Divida: " + this.valorEmDivida);
        System.out.println("_____________________________");
    }

    public void Depositar(double valor) {
        this.saldo +=  valor;
        System.out.println("Deposito efetuado com sucesso!");
        this.AtualizarMargemEmprestimo();
    }

    public void Levantar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Levantamento efetuado com sucesso!");
            this.AtualizarMargemEmprestimo();
        }else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void MostrarSaldo(){

        System.out.println("Saldo da conta do(a) " + this.titular + ": " + this.saldo + "€");

    }

    public boolean PedirEmpresimo(double valorDoEmprestimo){

        if (this.valorEmDivida == 0){
            if (valorDoEmprestimo > 0 && valorDoEmprestimo <= this.margemDeEmprestimo){
                this.saldo += valorDoEmprestimo;
                this.valorEmDivida = valorDoEmprestimo;
                this.AtualizarMargemEmprestimo();
                return true;
            }else {
                System.out.println(this.titular + " não pode pedir um emprestimo com este valor!");
                return false;
            }
        }else {
            System.out.println(this.titular + " já tem uma divida activa!");
            return false;
        }

    }

}
