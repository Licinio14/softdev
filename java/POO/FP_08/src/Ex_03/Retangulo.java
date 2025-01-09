package Ex_03;

public class Retangulo {

    private double largura;
    private double altura;

    Retangulo(double largura, double altura){
        this.largura = largura;
        this.altura = altura;
    }


    public void CalcArea(){
        System.out.println("A area é: " + this.largura * this.altura);
    }

    public void CalcPerimetro(){
        System.out.println("O perimetro é: " + ((this.largura * 2) + (this.altura * 2)));
    }

}
