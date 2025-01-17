package Ex_06;

public class Atleta {
    private String nome;
    private Modalidade modDisportiva;
    private double altura;
    private double peso;
    private String paisOrigem;

    public Atleta(String nome, Modalidade modDisportiva, double altura, double peso, String paisOrigem) {
        this.nome = nome;
        this.modDisportiva = modDisportiva;
        this.altura = altura;
        this.peso = peso;
        this.paisOrigem = paisOrigem;
    }

    public String getNome() {
        return nome;
    }

    public Modalidade getModDisportiva() {
        return modDisportiva;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void MostrarAtleta(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Modalidade: " + this.modDisportiva);
        System.out.println("Altura: " + this.altura);
        System.out.println("Peso: " + this.peso);
        System.out.println("Pais: " + this.paisOrigem);
    }
}
