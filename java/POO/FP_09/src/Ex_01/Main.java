package Ex_01;

public class Main {
    public static void main(String[] args) {

        Carro car1 = new Carro("renault","clio",1996,85,1200,TipoCombustivel.GASOLINA,6.3);
        Carro car2 = new Carro("BW","150",2000,150,1900,TipoCombustivel.GPL,11.9);
        Carro car3 = new Carro("Mercedes","clk",2010,450,2000,TipoCombustivel.DISEL,16.5);
        Carro car4 = new Carro("Tesla","y",2022,130,0,TipoCombustivel.ELETRICO,11);

        car1.Ligar();
        car2.Ligar();
        car3.Ligar();
        car4.Ligar();

        Carro vencedor = car1.Corrida(car2);
        Carro vencedor2 = car3.Corrida(car4);
        Carro premiado = vencedor.Corrida(vencedor2);

        System.out.println("________________________________________________________");

        System.out.println("O vencedor da primeira corrida foi: ");
        vencedor.MostrarCarro();

        System.out.println("________________________________________________________");

        System.out.println("O vencedor da segunda corrida foi: ");
        vencedor2.MostrarCarro();

        System.out.println("________________________________________________________");

        System.out.println("O vencedor dos 4 carros foi o: ");
        premiado.MostrarCarro();

        System.out.println("________________________________________________________");

        System.out.println("O " + car1.getMarca() + " consome " + car1.CalcularConsumos(97) + " litros ao fazer 97kms");
        System.out.println();
        System.out.println("O " + car2.getMarca() + " consome " + car2.CalcularConsumos(97) + " litros ao fazer 97kms");
        System.out.println();
        System.out.println("O " + car3.getMarca() + " consome " + car3.CalcularConsumos(97) + " litros ao fazer 97kms");
        System.out.println();
        System.out.println("O " + car4.getMarca() + " consome " + car4.CalcularConsumos(97) + " kw ao fazer 97kms");

        System.out.println("________________________________________________________");

        Carro batalhaDeConsumosCarro1 = car1, batalhaDeConsumosCarro2 = car4;

        System.out.println("\nEntre: \n");
        batalhaDeConsumosCarro1.MostrarCarro();
        System.out.println("\n");
        batalhaDeConsumosCarro2.MostrarCarro();



        if (batalhaDeConsumosCarro1.CalcularConsumos(97) > batalhaDeConsumosCarro2.CalcularConsumos(97)){
            System.out.println("\n\nO carro que gasta mais litros ao fazer 97kms:\n");
            batalhaDeConsumosCarro1.MostrarCarro();
        }else if (batalhaDeConsumosCarro1.CalcularConsumos(97) < batalhaDeConsumosCarro2.CalcularConsumos(97)){
            System.out.println("\nO carro que gasta mais litros ao fazer 97kms:\n");
            batalhaDeConsumosCarro2.MostrarCarro();
        }else {
            System.out.println("\nAmbos gastam o mesmo.\n");
        }






    }
}
