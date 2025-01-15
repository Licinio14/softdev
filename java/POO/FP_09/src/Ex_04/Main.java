package Ex_04;

public class Main {

    public static void main(String[] args) {
        Imovel casa1 = new Imovel("Rua almeda de baixo",452,"Lisboa",Tipo.MANSAO,Acabamento.PARA_RESTAURO,124,6,10,9);
        Imovel casa2 = new Imovel("Rua Cima de baixo",12,"Lisboa",Tipo.APARTAMENTO,Acabamento.NOVA_COM_ALTO_ACABAMENTO,24,1,1,0);
        Imovel casa3 = new Imovel("Rua Esqueda de baixo",78,"Bragança",Tipo.CASA,Acabamento.USADA,56,2,3,3);
        Imovel casa4 = new Imovel("Rua Direita de baixo",9,"Alentejo",Tipo.APARTAMENTO,Acabamento.NOVA,37,4,2,0);

        casa4.ImprimirDescricao();
        casa4.MudarEstadoCasa(Acabamento.NOVA_COM_ALTO_ACABAMENTO);
        casa4.ImprimirDescricao();

        System.out.println("\n_______________________________________________________\n");

        Imovel maisCaro = casa1.CompararImoveis(casa3);
        maisCaro.ImprimirDescricao();



    }

    

}
