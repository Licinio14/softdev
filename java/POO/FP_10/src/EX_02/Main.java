package EX_02;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Miguel",45,981457364,"miguel@gmail.com");
        Pessoa p2 = new Pessoa("Maria",12,981759364,"Maria@gmail.com");
        Pessoa p3 = new Pessoa("Marco",34,983547364,"Marco@gmail.com");
        Pessoa p4 = new Pessoa("Mariana",18,981453844,"Mariana@gmail.com");
        Pessoa p5 = new Pessoa("Manuel",99,981178364,"Manuel@gmail.com");

        Sorteio euroMilhas = new Sorteio(94164.68);

        System.out.println("Vai adicionar as 5 pessoas:\n");

        euroMilhas.adicionarParticipantes(p1);
        euroMilhas.adicionarParticipantes(p2);
        euroMilhas.adicionarParticipantes(p3);
        euroMilhas.adicionarParticipantes(p4);
        euroMilhas.adicionarParticipantes(p5);

        System.out.println("\n____________________________________________________________________________\n");

        euroMilhas.ImprimirParticipantes();

        System.out.println("\n____________________________________________________________________________\n");

        Pessoa ganhador = euroMilhas.SortearGanhador();

        System.out.println("O ganhador do euroMilhas é " + ganhador.getNome() + " com " + ganhador.getIdade() + " anos.");


    }
}
