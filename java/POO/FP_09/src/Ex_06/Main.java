package Ex_06;

public class Main {
    public static void main(String[] args) {
        Atleta at1 = new Atleta("Miguel", Modalidade.ATLETISMO,1.75,71,"Arabia");
        Atleta at2 = new Atleta("Arnaldo", Modalidade.CORRIDA100M,1.55,60,"Portugal");
        Atleta at3 = new Atleta("Joana", Modalidade.CORRIDA100M,1.65,59,"França");
        Atleta at4 = new Atleta("Ana", Modalidade.SALTOALTURA,1.85,67,"Espanha");
        Atleta at5 = new Atleta("Maria", Modalidade.LANCAMENTOPESO,1.95,98,"USA");
        Atleta at6 = new Atleta("Otavio", Modalidade.SALTOALTURA,1.71,64,"Mexico");


        System.out.println("Vai ser criada a competição de corrida 100 metros\n");
        Competicao corrida100m = new Competicao("Corrida 100 Metros","Portugal",2);

        boolean validacao = false;

        validacao = corrida100m.ADDAtleta(at2);
        if (validacao) System.out.println("Atleta " + at2.getNome() + " foi adicionado.\n");
        else System.out.println("Atleta " + at2.getNome() + " nao foi adicionado.\n");
        validacao = corrida100m.ADDAtleta(at3);
        if (validacao) System.out.println("Atleta " + at3.getNome() + " foi adicionado.\n");
        else System.out.println("Atleta " + at3.getNome() + " nao foi adicionado.\n");

        System.out.println("\n1º competição: \n");
        int maxParticipantes = corrida100m.getNumParticipantes();
        System.out.println("****************    " + corrida100m.getNome() + "    ****************");
        System.out.println("Localização: " + corrida100m.getPais());
        System.out.println("****************    Participantes    ****************");
        for (int i = 0; i < maxParticipantes; i++) {
            Atleta mostrarAtleta = corrida100m.getParticipantes(i);
            System.out.println("\n");
            mostrarAtleta.MostrarAtleta();
            System.out.println("__________________________________________________\n");
        }


        System.out.println("Vai ser criada a competição de salto\n");
        Competicao salto = new Competicao("Corrida 100 Metros","Portugal",2);

        validacao = false;

        validacao = salto.ADDAtleta(at4);
        if (validacao) System.out.println("Atleta " + at4.getNome() + " foi adicionado.\n");
        else System.out.println("Atleta " + at4.getNome() + " nao foi adicionado.\n");
        validacao = salto.ADDAtleta(at6);
        if (validacao) System.out.println("Atleta " + at6.getNome() + " foi adicionado.\n");
        else System.out.println("Atleta " + at6.getNome() + " nao foi adicionado.\n");
        validacao = salto.ADDAtleta(at1);
        if (validacao) System.out.println("Atleta " + at1.getNome() + " foi adicionado.\n");
        else System.out.println("Atleta " + at1.getNome() + " nao foi adicionado.\n");

        System.out.println("\n2º competição: \n");
        maxParticipantes = salto.getNumParticipantes();
        System.out.println("****************    " + salto.getNome() + "    ****************");
        System.out.println("Localização: " + salto.getPais());
        System.out.println("****************    Participantes    ****************");
        for (int i = 0; i < maxParticipantes; i++) {
            Atleta mostrarAtleta = salto.getParticipantes(i);
            System.out.println("\n");
            mostrarAtleta.MostrarAtleta();
            System.out.println("__________________________________________________\n");
        }



    }
}
