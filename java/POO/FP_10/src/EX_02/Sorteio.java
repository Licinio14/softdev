package EX_02;

import java.util.ArrayList;
import java.util.Random;

public class Sorteio {
    private double premio;
    private ArrayList<Pessoa> participantes = new ArrayList<>();

    public Sorteio(double premio) {
        this.premio = premio;
    }

    public double getPremio() {
        return premio;
    }

    public boolean adicionarParticipantes(Pessoa novaPessoa){

        if (novaPessoa.getIdade() >= 18) {
            this.participantes.add(novaPessoa);
            return true;
        }
        else {
            System.out.println("A " + novaPessoa.getNome() + " não tem idade suficiente para jogar");
            return false;
        }

    }

    public Pessoa SortearGanhador(){

        int max = this.participantes.size();
        Random rnd = new Random();
        return this.participantes.get(rnd.nextInt(max));

    }

    public void ImprimirParticipantes(){
        System.out.println("\nOs participantes são: \n");
        int count = 0;
        for (Pessoa imprimirPessoa : this.participantes){
            System.out.print("Participante " + ++count + ": ");
            imprimirPessoa.ImprimirPessoa();
        }
    }


}
