package ex_03;

import ex_03.enums.*;

public class Main {
    public static void main(String[] args) {
        boolean validacao;

        System.out.println("\nCriado os ingredientes da pizza");
        Queijo queijo = new Queijo("I111","Queijo de Cabra", Medida.GRAMAS,2.8, OrigemIngrediente.NACIONAL, TipoQueijo.BRIE);
        Vegetal molhoTomate = new Vegetal("I112","Molho de Tomate", Medida.LITROS,325.0,OrigemIngrediente.NACIONAL,TipoVegetal.TOMATE);
        Base base = new Base("B100","Base Alta",7.5, BasePizza.ALTA,"Massa alta e fofa");
        Carne chourica = new Carne("I114","Rodela Chouriça de Mirandela", Medida.UNIDADES,35.0,OrigemIngrediente.NACIONAL,TipoCarne.CHOURICO);
        Vegetal pimentoVerde = new Vegetal("I115","Fatia Pimento Verde", Medida.UNIDADES,4.0,OrigemIngrediente.IMPORTADO,TipoVegetal.PIMENTO);
        Carne calabreza = new Carne("I116","Fatias de calabreza", Medida.UNIDADES,45.0,OrigemIngrediente.IMPORTADO,TipoCarne.PORCO);

        System.out.println("\nCriada a pizza portugal");
        ListaIngredientes baseGrande300 = new ListaIngredientes(base,300);
        ListaIngredientes molhoTomate009 = new ListaIngredientes(molhoTomate,0.09);
        Pizza portuguesa = new Pizza("P1991","Pizza Portugal","Pizza tradicional com ingredientes nacionais que promete levar quem a come numa viagem pela cultura de Portugal.",19.99, TamanhoPizza.GRANDE,baseGrande300,molhoTomate009);

        System.out.println("_________________________________________________________________________");


        ListaIngredientes listaQueijo = new ListaIngredientes(queijo,150);
        ListaIngredientes listachourica = new ListaIngredientes(chourica,10);
        ListaIngredientes listaPimentoVerde = new ListaIngredientes(pimentoVerde,5);
        ListaIngredientes listaCalabreza = new ListaIngredientes(calabreza,15);



        System.out.print("\nQueijo de Cabra: ");
        validacao = portuguesa.AdicionarToppings(listaQueijo);
        if (validacao) {
            System.out.print("Adicionado!");
        }else {
            System.out.print("Não adicionado!");
        }

        System.out.print("\nQueijo de Cabra: ");
        validacao = portuguesa.AdicionarToppings(listaQueijo);
        if (validacao) {
            System.out.print("Adicionado!");
        }else {
            System.out.print("Não adicionado!");
        }

        System.out.print("\nRodelas Chouriça: ");
        validacao = portuguesa.AdicionarToppings(listachourica);
        if (validacao) {
            System.out.print("Adicionado!");
        }else {
            System.out.print("Não adicionado!");
        }

        System.out.print("\nFatias Pimento Verde: ");
        validacao = portuguesa.AdicionarToppings(listaPimentoVerde);
        if (validacao) {
            System.out.print("Adicionado!");
        }else {
            System.out.print("Não adicionado!");
        }

        System.out.print("\nFatias Calabreza: ");
        validacao = portuguesa.AdicionarToppings(listaCalabreza);
        if (validacao) {
            System.out.print("Adicionado!");
        }else {
            System.out.print("Não adicionado!");
        }

        System.out.println("\n_________________________________________________________________________\n");

        portuguesa.InfoPrint();
        
    }
}
