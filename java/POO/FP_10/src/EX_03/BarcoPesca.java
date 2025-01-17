package EX_03;

import java.util.ArrayList;

public class BarcoPesca {
    private String nome, cor, anoFabrico;
    private int tripulacao;
    private double capacidadeCargaKG;
    private Marca marca;
    private ArrayList<Peixe> peixesPescado = new ArrayList<>();
    private ArrayList<Marisco> mariscosPescado = new ArrayList<>();

    public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCargaKG, Marca marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCargaKG = capacidadeCargaKG;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getAnoFabrico() {
        return anoFabrico;
    }

    public int getTripulacao() {
        return tripulacao;
    }

    public double getCapacidadeCargaKG() {
        return capacidadeCargaKG;
    }

    public Marca getMarca() {
        return marca;
    }

    public boolean PescarPeixe(Peixe peixePescado){
        double cargaOcupada = 0;
        for (Peixe saberPeso : this.peixesPescado){
            cargaOcupada += saberPeso.getPeso();
        }

        if (cargaOcupada + peixePescado.getPeso() <= this.capacidadeCargaKG){
            this.peixesPescado.add(peixePescado);
            return true;
        }else {
            return false;
        }

    }

    public boolean PescarMarisco(Marisco mariscoPescado){
        double cargaOcupada = 0;
        for (Marisco saberPeso : this.mariscosPescado){
            cargaOcupada += saberPeso.getPeso();
        }

        if (cargaOcupada + mariscoPescado.getPeso() <= this.capacidadeCargaKG){
            this.mariscosPescado.add(mariscoPescado);
            return true;
        }else {
            return false;
        }
    }

    public boolean LargarPeixe(Peixe peixeLargar){
        boolean verificacao = this.peixesPescado.contains(peixeLargar);
        if (verificacao){
            this.peixesPescado.remove(peixeLargar);
            return true;
        }else {
            return false;
        }
        
        //todo: Verificar e continuar o largar peixe
    }
}
