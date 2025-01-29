package ex_02;

public class Carro extends Veiculo{
    protected int quantidadePassageiros;

    public Carro(String marca, String modelo, int fabrico, int potencia, int cilindrada, TipoCombustivel combustivel, double litros100km, int quantidadePassageiros) {
        super(marca, modelo, fabrico, potencia, cilindrada, combustivel, litros100km);
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    /**
     * calcula o custo de uma viagem com o carro
     * @param kms quantidade de km da viagem (int)
     * @return custo total da viagem / se returnar -1 é porque nao encontrou o tipo de combustivel certo
     */
    public double CalcularCusto(double kms){
        double litros = kms / 100 * this.getLitros100km();
        double custo = 0;


        switch (this.getCombustivel()){
            case GPL -> custo = litros * 1.15;
            case DISEL -> custo = 1.95;
            case ELETRICO -> custo = 0.12;
            case GASOLINA -> custo = 2.10;
            case HIBRIDO -> custo = 1.60;
            default -> custo = -1;
        }

        return custo;
    }

    @Override
    public void  ExivirDetalhes(){
        super.ExivirDetalhes();
        System.out.println("Quantidade de Passageiros: " + this.quantidadePassageiros);
        System.out.println("____________________________");
    }
}
