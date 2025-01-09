package Ex_05;

public class Carro {

    private String marca;
    private String modelo;
    private int fabrico;

    Carro(String marca, String modelo, int fabrico) {
        this.marca = marca;
        this.modelo = modelo;
        this.fabrico = fabrico;
    }

    public void Ligar() {
        System.out.println("O carro esta ligado");
    }
}
