package Ex_10;

public class Main {
    public static void main(String[] args) {

        Funcionario Rui = new Funcionario("Rui", 1000, Departamento.DEVELOPERS);
        Funcionario Marta = new Funcionario("Marta", 1500, Departamento.SEGURANCA);
        Funcionario Fernando = new Funcionario("Fernando", 800, Departamento.DEVELOPERS);


        Rui.exibirDados();
        System.out.println("Recebeu 10% de aumento:");
        Rui.aumentarSalario(10);
        Rui.exibirDados();

        System.out.println("__________________________________________");

        Marta.exibirDados();
        System.out.println("Recebeu 5% de aumento:");
        Marta.aumentarSalario(5);
        Marta.exibirDados();


        System.out.println("__________________________________________");

        Fernando.exibirDados();
        System.out.println("Recebeu 33% de aumento:");
        Fernando.aumentarSalario(33);
        Fernando.exibirDados();
    }
}
