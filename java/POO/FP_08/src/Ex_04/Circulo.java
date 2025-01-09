package Ex_04;

public class Circulo {
    //atributos de instancia
    private double raio;

    //metodos construtor
    Circulo(double raio) {
        this.raio = raio;
    }

    //metodos de acesso


    //metodos de instancia
    public void CalcularArea() {
        System.out.println((Math.PI * this.raio * this.raio));
    }

    public void CalcularPerimetro() {
        System.out.println((2 * Math.PI * this.raio));
    }


}
