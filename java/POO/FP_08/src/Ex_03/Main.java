package Ex_03;

public class Main {
    public static void main(String[] args){

        Retangulo ret1 = new Retangulo(5.8,3.1);
        Retangulo ret2 = new Retangulo(9.3,2.7);
        Retangulo ret3 = new Retangulo(7,5);

        System.out.println("A area dos rectangulos é:");
        ret1.CalcArea();
        ret2.CalcArea();
        ret3.CalcArea();

        System.out.println("___________________________________");
        System.out.println("O perimetro dos rectangulos é:");
        ret1.CalcPerimetro();
        ret2.CalcPerimetro();
        ret3.CalcPerimetro();

    }
}
