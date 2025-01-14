package Ex_03;

public class Animal {

    private String nome;
    private String especie;
    private String paisOrigem;
    private double peso;
    private Alimentos[] alimentacao;

    public Animal(String nome, String especie, String paisOrigem, double peso, int maxAlimentos) {
        this.nome = nome;
        this.especie = especie;
        this.paisOrigem = paisOrigem;
        this.peso = peso;
        this.alimentacao = new Alimentos[maxAlimentos];
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public double getPeso() {
        return peso;
    }

    public Alimentos[] getAlimentacao() {
        return alimentacao;
    }

    public void MostrarAnimal() {
        System.out.println("\n________________________________________\n");
        System.out.println("Nome: " + this.nome);
        System.out.println("Especie: " + this.especie);
        System.out.println("País: " + this.paisOrigem);
        System.out.println("Peso: " + this.peso);
        System.out.print("Comidas favoritas: | ");
        if (this.alimentacao.length == 0) {

            System.out.print("O animal ainda não tem comidas favoritas!");

        } else {

            for (int i = 0; i < this.alimentacao.length; i++) {

                if (this.alimentacao[i] != null) {
                    System.out.print(this.alimentacao[i] + " | ");
                }

            }

        }
        System.out.println();
        System.out.println("\n________________________________________\n");

    }

    public void AdicionarAlimentos(Alimentos alimento) {

        for (int i = 0; i < this.alimentacao.length; i++) {

            if (this.alimentacao[i] == null) {
                this.alimentacao[i] = alimento;
                return;
            }

        }

        System.out.println("Infelizmente o " + this.nome + " não pode comer mais alimentos diferentes");

    }

    public boolean AlimentarAnimal(Alimentos comida, double peso) {

        for (int i = 0; i < this.alimentacao.length; i++) {
            if (this.alimentacao[i].equals(comida)) {
                this.peso += peso;
                return true;
            }
        }

        return false;
    }
}
