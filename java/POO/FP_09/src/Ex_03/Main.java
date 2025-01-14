package Ex_03;

public class Main {
    public static void main(String[] args) {

        Animal cao = new Animal("Bobi", "cao", "Brasil", 9.7, 3);
        Animal macaco = new Animal("Bambi", "macaco", "Brasil", 18, 1);
        Animal cavalo = new Animal("Merce", "cavalo", "Africa", 158, 2);
        Animal porco = new Animal("Narco", "porco", "Espanha", 42, 5);

        cao.AdicionarAlimentos(Alimentos.CARNE);
        cao.AdicionarAlimentos(Alimentos.RACAO_DE_CAO);

        macaco.AdicionarAlimentos(Alimentos.BANANAS);
        macaco.AdicionarAlimentos(Alimentos.PLANTAS);

        cavalo.AdicionarAlimentos(Alimentos.MACAS);
        cavalo.AdicionarAlimentos(Alimentos.PERAS);

        porco.AdicionarAlimentos(Alimentos.PERAS);
        porco.AdicionarAlimentos(Alimentos.CARNE);
        porco.AdicionarAlimentos(Alimentos.RACAO_DE_CAO);

        System.out.println("\n__________________________________________________________________________\n");
        System.out.println("O cao vai tentar comer carne\n");
        System.out.println("O peso do cao é: " + cao.getPeso());
        boolean testeAlimentacao = cao.AlimentarAnimal(Alimentos.CARNE, 0.7);
        if (testeAlimentacao){
            System.out.println("O cao comeu tudo");
        }else {
            System.out.println("O cao nao gosta de" + Alimentos.CARNE);
        }
        System.out.println("O cao agora pesa: " + cao.getPeso());


        System.out.println("\n__________________________________________________________________________\n");
        System.out.println("O cavalo vai tentar comer carne\n");
        System.out.println("O peso do cavalo é: " + cavalo.getPeso());
        testeAlimentacao = cavalo.AlimentarAnimal(Alimentos.CARNE, 0.7);
        if (testeAlimentacao){
            System.out.println("O cavalo comeu tudo");
        }else {
            System.out.println("O cavalo nao gosta de" + Alimentos.CARNE);
        }
        System.out.println("O cavalo agora pesa: " + cavalo.getPeso());

        System.out.println("\n__________________________________________________________________________\n");

        System.out.println("Mostrar o animal:");
        cao.MostrarAnimal();



    }
}
