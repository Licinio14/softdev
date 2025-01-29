package ex_02;

public class Camiao extends Veiculo{
    protected double capacidadeCarga;

    public Camiao(String marca, String modelo, int fabrico, int potencia, int cilindrada, TipoCombustivel combustivel, double litros100km, double capacidadeCarga) {
        super(marca, modelo, fabrico, potencia, cilindrada, combustivel, litros100km);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    @Override
    public void  ExivirDetalhes(){
        super.ExivirDetalhes();
        System.out.println("Capacidade de Carga: " + this.capacidadeCarga);
        System.out.println("____________________________");
    }

    /**
     * calcula o custo da viagem do camiao
     * @param kms kms totais da viagem (double)
     * @param carga total da carga (em kg) que o camiao tem de carregar (double)
     * @return retorna o custo da viagem / -1 se tiver carga a mais
     */
    public double CalcularCusto(double kms, double carga){
        double custo = 0;

        if (carga > this.capacidadeCarga){
            custo = -1;
        }else {

            double consumo = this.getLitros100km();
            carga /= 100;
            consumo = consumo + (carga * 0.1);
            double litros = kms / 100 * consumo;

            custo = litros * 1.95;

        }


        return custo;

    }
}
