package Ex_04;

public class Main {
    public static void main(String[] args) {
        Circulo cr1 = new Circulo(5.9);
        Circulo cr2 = new Circulo(3);
        Circulo cr3 = new Circulo(7.1);

        System.out.println("A area do cr1: ");
        cr1.CalcularArea();
        System.out.println("O perimetro do cr1: ");
        cr1.CalcularPerimetro();

        System.out.println("_____________________________________");

        System.out.println("A area do cr2: ");
        cr2.CalcularArea();
        System.out.println("O perimetro do cr2: ");
        cr2.CalcularPerimetro();

        System.out.println("_____________________________________");

        System.out.println("A area do cr3: ");
        cr3.CalcularArea();
        System.out.println("O perimetro do cr3: ");
        cr3.CalcularPerimetro();
    }
}
