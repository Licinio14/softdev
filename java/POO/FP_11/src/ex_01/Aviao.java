package ex_01;

public class Aviao {
    protected int numSerie;
    protected String modelo;
    protected int anoFabrico;
    protected double peso;
    protected double comprimentoFuselagem;
    protected double envergaduraAsas;
    protected double alturaCauda;
    protected int numeroMotores;
    protected double autonomia;
    protected double velocidadeMaxima;
    protected double preco;

    /**
     *
     * @param numSerie numero do aviao (int)
     * @param modelo nome do modelo do aviao (string)
     * @param anoFabrico ano de construção do aviao (int)
     * @param peso peso total do aviao em kg (double)
     * @param comprimentoFuselagem comprimento do aviao em metros (double)
     * @param envergaduraAsas comprimento das asas do aviao em metros (double)
     * @param alturaCauda altura da cauda em metros (double)
     * @param numeroMotores quantidade de motores que o aviao tem (int)
     * @param autonomia distancia maxima de voo em km (double)
     * @param velocidadeMaxima velocidade maxima que o aviao pode atingir km/h (double)
     * @param preco valor do aviao (double)
     */
    protected Aviao(int numSerie, String modelo, int anoFabrico, double peso, double comprimentoFuselagem, double envergaduraAsas, double alturaCauda, int numeroMotores, double autonomia, double velocidadeMaxima, double preco) {
        this.numSerie = numSerie;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
        this.peso = peso;
        this.comprimentoFuselagem = comprimentoFuselagem;
        this.envergaduraAsas = envergaduraAsas;
        this.alturaCauda = alturaCauda;
        this.numeroMotores = numeroMotores;
        this.autonomia = autonomia;
        this.velocidadeMaxima = velocidadeMaxima;
        this.preco = preco;
    }

    /**
     * exibe os detalhes do aviao generico
     */
    public void ExebirDetalhes(){
        System.out.println("*********************** " + this.modelo + " ***********************");
        System.out.println("Nº Serie: " + this.numSerie + " | Ano de Fabrico: " + this.anoFabrico + " | Peso: " + this.peso);
        System.out.println("Comprimento: " + this.comprimentoFuselagem + " | Largura: " + this.envergaduraAsas + " | Altura: " + this.alturaCauda);
        System.out.println("Nº motores: " + this.numeroMotores + " | Autonomia: " + this.autonomia + " | Velocidade maxima: " + this.velocidadeMaxima);

    }

    public int getNumSerie() {
        return numSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabrico() {
        return anoFabrico;
    }

    public double getPeso() {
        return peso;
    }

    public double getComprimentoFuselagem() {
        return comprimentoFuselagem;
    }

    public double getEnvergaduraAsas() {
        return envergaduraAsas;
    }

    public double getAlturaCauda() {
        return alturaCauda;
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public double getPreco() {
        return preco;
    }
}
