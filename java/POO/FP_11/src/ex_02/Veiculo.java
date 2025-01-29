package ex_02;

public class Veiculo {

    private String marca;
    private String modelo;
    private int fabrico;
    private int potencia;
    private int cilindrada;
    private TipoCombustivel combustivel;
    private double litros100km;

    public Veiculo(String marca, String modelo, int fabrico, int potencia, int cilindrada, TipoCombustivel combustivel, double litros100km) {
        this.marca = marca;
        this.modelo = modelo;
        this.fabrico = fabrico;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.combustivel = combustivel;
        this.litros100km = litros100km;
    }

    public void ExivirDetalhes(){
        System.out.println("____________________________");
        System.out.println("Marca: " + this.marca + "\nModelo: " + this.modelo + "\nAno: " + this.fabrico);

    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getFabrico() {
        return fabrico;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public TipoCombustivel getCombustivel() {
        return combustivel;
    }

    public double getLitros100km() {
        return litros100km;
    }

    public int Idade() {
        return 2025 - this.fabrico;
    }

    public void Ligar() {
        if (this.Idade() > 30){
            if (this.combustivel.equals(TipoCombustivel.DISEL)){
                System.out.println("Deita um pouco de fumo... Custa a pegar... O carro está ligado!\nVrum-vrum-vrum");
            }else {
                System.out.println("Custa a pegar... O carro está ligado!\nVrum-vrum-vrum");
            }
        } else {
            if (this.potencia < 250){
                System.out.println("O carro está ligado!\nVrummmmmmmmmm");
            }else {
                System.out.println("O carro está ligado!\nVRUMMMMMMMMMM");
            }
        }
    }

    public Veiculo Corrida(Veiculo adversario){
        if (this.potencia > adversario.potencia){
            return this;
        } else if (this.potencia < adversario.potencia) {
            return adversario;
        }else {
            if (this.cilindrada > adversario.cilindrada){
                return this;
            }else if (this.cilindrada < adversario.cilindrada){
                return adversario;
            }else {
                if (this.fabrico < adversario.fabrico){
                    return this;
                }else if (this.fabrico > adversario.fabrico){
                    return adversario;
                }else {
                    return null;
                }
            }
        }
    }

    public double CalcularConsumos(double distanciaKMs){

        return (distanciaKMs / 100) * this.litros100km;

    }




}
