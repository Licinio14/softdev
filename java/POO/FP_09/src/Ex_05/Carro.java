package Ex_05;

public class Carro {

    private String marca;
    private String modelo;
    private int fabrico;
    private int potencia;
    private int cilindrada;
    private TipoCombustivel combustivel;
    private double litros100km;

    Carro(String marca, String modelo, int fabrico) {
        this.marca = marca;
        this.modelo = modelo;
        this.fabrico = fabrico;
    }

    public void MostrarCarro(){
        System.out.println("____________________________");
        System.out.println("Marca: " + this.marca + "\nModelo: " + this.modelo + "\nAno: " + this.fabrico);
        System.out.println("____________________________");
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

    public Carro Corrida(Carro adversario){
        if (this.potencia > adversario.potencia){
            return this;
        } else if (this.potencia < adversario.potencia) {
            return adversario;
        }else {
            //continuar depois da potencia
        }
    }




}
