package Ex_07;

public class Main {
    public static void main(String[] args) {
        Livro lvr1 = new Livro("Historias do saber","Antonio Bratio", "Historia",1973,"978-85-359-0277-4");
        Livro lvr2 = new Livro("Pelas estradas","Marta Abreu", "Viagens",547,"974-85-591-0227-1");

        System.out.println("Livro 1: ");
        lvr1.exibirDetalhes();

        System.out.println();
        System.out.println("___________________________________________");
        System.out.println();

        System.out.println("Livro 2: ");
        lvr2.exibirDetalhes();



    }
}
