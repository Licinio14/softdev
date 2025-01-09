package Ex_10;

public class Funcionario {
    private String nome;
    private double salario;
    private Departamento departamento;

    public Funcionario(String nome, double salario, Departamento departamento) {
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Salario: " + salario);
        System.out.println("Departamento: " + departamento);
    }

    public void aumentarSalario(double valor){
        System.out.printf(this.nome + " passou de " + this.salario);
        this.salario = this.salario + (this.salario * (valor / 100));
        System.out.printf("€ para o valor de " + this.salario + "€\n");

    }
}
