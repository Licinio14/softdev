package ex_02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Veiculo car1 = new Carro("renault","clio",1996,85,1200,TipoCombustivel.GASOLINA,6.3,5);
        Veiculo car2 = new Carro("BW","150",2000,150,1900,TipoCombustivel.GPL,11.9,4);
        Veiculo car3 = new Carro("Mercedes","clk",2010,450,2000,TipoCombustivel.DISEL,16.5,5);
        Veiculo car4 = new Carro("Tesla","y",2022,130,0,TipoCombustivel.ELETRICO,11,5);

        car1.Ligar();
        car2.Ligar();
        car3.Ligar();
        car4.Ligar();

        Veiculo vencedor = car1.Corrida(car2);
        Veiculo vencedor2 = car3.Corrida(car4);
        Veiculo premiado = vencedor.Corrida(vencedor2);

        System.out.println("________________________________________________________");

        System.out.println("O vencedor da primeira corrida foi: ");
        vencedor.ExivirDetalhes();

        System.out.println("________________________________________________________");

        System.out.println("O vencedor da segunda corrida foi: ");
        vencedor2.ExivirDetalhes();

        System.out.println("________________________________________________________");

        System.out.println("O vencedor dos 4 carros foi o: ");
        premiado.ExivirDetalhes();

        System.out.println("________________________________________________________");

        System.out.println("O " + car1.getMarca() + " consome " + car1.CalcularConsumos(97) + " litros ao fazer 97kms");
        System.out.println();
        System.out.println("O " + car2.getMarca() + " consome " + car2.CalcularConsumos(97) + " litros ao fazer 97kms");
        System.out.println();
        System.out.println("O " + car3.getMarca() + " consome " + car3.CalcularConsumos(97) + " litros ao fazer 97kms");
        System.out.println();
        System.out.println("O " + car4.getMarca() + " consome " + car4.CalcularConsumos(97) + " kw ao fazer 97kms");

        System.out.println("________________________________________________________");

        Veiculo batalhaDeConsumosVeiculo1 = car1, batalhaDeConsumosVeiculo2 = car4;

        System.out.println("\nEntre: \n");
        batalhaDeConsumosVeiculo1.ExivirDetalhes();
        System.out.println("\n");
        batalhaDeConsumosVeiculo2.ExivirDetalhes();



        if (batalhaDeConsumosVeiculo1.CalcularConsumos(97) > batalhaDeConsumosVeiculo2.CalcularConsumos(97)){
            System.out.println("\n\nO carro que gasta mais litros ao fazer 97kms:\n");
            batalhaDeConsumosVeiculo1.ExivirDetalhes();
        }else if (batalhaDeConsumosVeiculo1.CalcularConsumos(97) < batalhaDeConsumosVeiculo2.CalcularConsumos(97)){
            System.out.println("\nO carro que gasta mais litros ao fazer 97kms:\n");
            batalhaDeConsumosVeiculo2.ExivirDetalhes();
        }else {
            System.out.println("\nAmbos gastam o mesmo.\n");
        }

        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println();

        Mota m1 = new Mota("KTM","ex350",2016,350,3500,TipoCombustivel.GASOLINA,6);

        ArrayList<String> motaTxt= m1.Imagem();

        for(String mota : motaTxt){
            System.out.println(mota);
        }

        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println();

        Camiao scania = new Camiao("scania","520",2018,520,5200,TipoCombustivel.DISEL,32,45000);

        double custo = scania.CalcularCusto(298,60000);
        if (custo == -1){
            System.out.println("O camiao tem carga a mais e nao pode fazer a viagem");
        }else {
            System.out.println("A viagem 60t ira custar: " + custo);
        }

        custo = scania.CalcularCusto(298,10000);
        if (custo == -1){
            System.out.println("O camiao tem carga a mais e nao pode fazer a viagem");
        }else {
            System.out.println("A viagem 10t ira custar: " + custo);
        }

        custo = scania.CalcularCusto(298,40000);
        if (custo == -1){
            System.out.println("O camiao tem carga a mais e nao pode fazer a viagem");
        }else {
            System.out.println("A viagem 40t ira custar: " + custo);
        }


        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println();

        System.out.println("Corrida entre mota e camiao: ");
        Veiculo novoVencedor = m1.Corrida(scania);

        novoVencedor.ExivirDetalhes();

        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println();

        double custocarro = car2.CalcularConsumos(150);
        System.out.println("O custo da viagem de 150 km para o carro é: " + custocarro);

        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println();



    }
}
