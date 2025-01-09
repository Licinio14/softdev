package Ex_8;

public class Main {
    public static void main(String[] args) {
        Aluno Marta = new Aluno("Marta",22, Curso.SOFT_DEV ,14.8);
        Aluno Miguel = new Aluno("Miguel",19, Curso.DATA_SA ,6.7);
        System.out.println("Marta: ");
        Marta.Situacao();
        System.out.println("Miguel: ");
        Miguel.Situacao();

    }
}
