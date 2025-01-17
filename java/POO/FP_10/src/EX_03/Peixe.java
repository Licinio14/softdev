package EX_03;

public class Peixe {
    private String especie;
    private double peso;
    private double precoKg;

    public Peixe(String nome, double peso, double precoKg) {
        this.especie = nome;
        this.peso = peso;
        this.precoKg = precoKg;
    }

    public String getNome() {
        return especie;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecoKg() {
        return precoKg;
    }
}
