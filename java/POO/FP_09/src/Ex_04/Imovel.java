package Ex_04;

public class Imovel {

    private String rua;
    private int numeroPorta;
    private String cidade;
    private Tipo tipo;
    private Acabamento acabamento;
    private double area;
    private int numeroQuartos;
    private int numeroCasasBanho;
    private double areaPiscina;

    public Imovel(String rua, int numeroPorta, String cidade, Tipo tipo, Acabamento acabamento, double area, int numeroQuartos, int numeroCasasBanho, double areaPiscina) {
        this.rua = rua;
        this.numeroPorta = numeroPorta;
        this.cidade = cidade;
        this.tipo = tipo;
        this.acabamento = acabamento;
        this.area = area;
        this.numeroQuartos = numeroQuartos;
        this.numeroCasasBanho = numeroCasasBanho;
        this.areaPiscina = areaPiscina;
    }

    public String getRua() {
        return rua;
    }

    public int getNumeroPorta() {
        return numeroPorta;
    }

    public String getCidade() {
        return cidade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Acabamento getAcabamento() {
        return acabamento;
    }

    public double getArea() {
        return area;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public int getNumeroCasasBanho() {
        return numeroCasasBanho;
    }

    public double getAreaPiscina() {
        return areaPiscina;
    }



    public double CalcularValorImovel(){
        double valor = 0;

        if (this.tipo.equals(Tipo.APARTAMENTO)){
            valor += this.area * 1000;

        } else if (this.tipo.equals(Tipo.CASA)) {
            valor += this.area * 3000;

        }else if (this.tipo.equals(Tipo.MANSAO)) {
            valor += this.area * 5000;

        }

        switch (this.acabamento){
            case Acabamento.PARA_RESTAURO -> valor /= 2;
            case Acabamento.USADA -> valor -= valor * 0.1;
            case Acabamento.NOVA_COM_ALTO_ACABAMENTO -> valor += valor * 0.25;
        }

        valor += this.numeroQuartos * 7500;
        valor += this.numeroCasasBanho * 10500;
        valor += this.areaPiscina * 1000;


        return valor;
    }

    public void MudarEstadoCasa(Acabamento novoEstado){
        this.acabamento = novoEstado;
    }

    public void ImprimirDescricao(){
        System.out.println("\n_______________________________________________\n");
        System.out.println("Rua: " + this.rua);
        System.out.println("Porta: " + this.numeroPorta);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Acabamento: " + this.acabamento);
        System.out.println("Área: " + this.area);
        System.out.println("Número de quartos: " + this.numeroQuartos);
        System.out.println("Números de casas de banho: " + this.numeroCasasBanho);
        System.out.println("Área da piscina: " + this.areaPiscina);
        System.out.println("Valor do imóvel: " + this.CalcularValorImovel());
        System.out.println("\n_______________________________________________\n");
    }

    public Imovel CompararImoveis(Imovel imovelParaComparacao){

        if (this.CalcularValorImovel() > imovelParaComparacao.CalcularValorImovel()){
            return this;
        } else if (this.CalcularValorImovel() < imovelParaComparacao.CalcularValorImovel()) {
            return imovelParaComparacao;
        } else {
            return null;
        }

    }

}
