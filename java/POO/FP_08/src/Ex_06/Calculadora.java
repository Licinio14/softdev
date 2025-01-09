package Ex_06;

public class Calculadora {


    Calculadora() {
    }


    public void Adicao(int x, int y){
        System.out.println("Adicao de " + x + " e " + y + " = " + (x + y));
    }

    public void Subtracao(int x, int y){
        System.out.println("Subtracao de " + x + " e " + y + " = " + (x - y));
    }

    public void Multiplicacao(int x, int y){
        System.out.println("Multiplicacao de " + x + " e " + y + " = " + (x * y));
    }

    public void Divisao(int x, int y){
        System.out.println("Divisao de " + x + " e " + y + " = " + (x / y));
    }
}
