package ex_01;

import ex_01.Enums.Arma;
import ex_01.Enums.CategoriaJato;
import ex_01.Enums.Instalacao;

public class Main {
    public static void main(String[] args) {
        AviaoCombate f16 = new AviaoCombate(4324,"F16",2018,2079,22,15,5,1,780,660,1267095,"USA",false);
        AviaoCombate f22 = new AviaoCombate(4538,"F22",2020,3079,25,15,5,2,680,860,3427995,"USA",true);
        AviaoCombate f35 = new AviaoCombate(1235,"F35",2023,4079,31,20,5,1,1564,560,2061015,"USA",true);

        JatoParticular boing = new JatoParticular(35245,"a320",2014,64000,91,34,11,4,2600,500,5945784,60,20, CategoriaJato.HEAVYJET);
        JatoParticular cesna = new JatoParticular(48965,"10",2019,4200,30,15,6,2,800,320,487532,8,20, CategoriaJato.MIDSIZEJET);
        JatoParticular cesnap = new JatoParticular(34587,"150",2000,820,13,8,5,1,200,150,124854,2, 0,CategoriaJato.LIGHTJET);

        Catalogo newFlights = new Catalogo();

        f16.addArma(Arma.BOMBAS);
        f16.addArma(Arma.METRALHADORAS);
        f16.addArma(Arma.TORPEDOS);
        boolean validacao = f16.addArma(Arma.MISSEIS);
        if (!validacao){
            System.out.println("Misseis nao foram adicionados");
        }

        newFlights.VenderAviao(f16);
        f16.ExebirDetalhes();
        newFlights.VenderAviao(f35);
        f35.ExebirDetalhes();

        boing.addInstalacao(Instalacao.WC);
        boing.addInstalacao(Instalacao.SUITE);
        boing.addInstalacao(Instalacao.TOMADAS);
        boing.addInstalacao(Instalacao.CHUVEIRO);
        boing.addInstalacao(Instalacao.COZINHA);

        newFlights.VenderAviao(boing);
        boing.ExebirDetalhes();

        newFlights.ExibirDetalhes();
        System.out.println();
        System.out.println("Total: " + newFlights.CalcularTotal());
        System.out.println();
        System.out.println("_________________________________________________");
        System.out.println();
        newFlights.ComprarAviao(f35);
        newFlights.ExibirDetalhes();
        System.out.println();
        System.out.println("Total: " + newFlights.CalcularTotal());
    }
}
