package ex_01;

import ex_01.Enums.CategoriaJato;
import ex_01.Enums.Instalacao;

import java.util.ArrayList;

public class JatoParticular extends Aviao{

    protected int lotacao;
    protected double capacidadeBagagem;
    protected CategoriaJato categoria;
    protected ArrayList<Instalacao> listaInstalacoes;

    /**
     *
     * @param numSerie numero do aviao (int)
     * @param modelo ingrediente do modelo do aviao (string)
     * @param anoFabrico ano de construção do aviao (int)
     * @param peso peso total do aviao em kg (double)
     * @param comprimentoFuselagem comprimento do aviao em metros (double)
     * @param envergaduraAsas comprimento das asas do aviao em metros (double)
     * @param alturaCauda altura da cauda em metros (double)
     * @param numeroMotores quantidade de motores que o aviao tem (int)
     * @param autonomia distancia maxima de voo em km (double)
     * @param velocidadeMaxima velocidade maxima que o aviao pode atingir km/h (double)
     * @param preco valor do aviao (double)
     * @param lotacao quantidade de ocupantes (int)
     * @param capacidadeBagagem capacidade da bagagem em cm3 (double)
     * @param categoria categoria do jato (CategoriaJato)
     */
    public JatoParticular(int numSerie, String modelo, int anoFabrico, double peso, double comprimentoFuselagem, double envergaduraAsas, double alturaCauda, int numeroMotores, double autonomia, double velocidadeMaxima, double preco, int lotacao, double capacidadeBagagem, CategoriaJato categoria) {
        super(numSerie, modelo, anoFabrico, peso, comprimentoFuselagem, envergaduraAsas, alturaCauda, numeroMotores, autonomia, velocidadeMaxima, preco);
        this.lotacao = lotacao;
        this.capacidadeBagagem = capacidadeBagagem;
        this.categoria = categoria;
        this.listaInstalacoes = new ArrayList<>();
    }

    public int getLotacao() {
        return lotacao;
    }

    public double getCapacidadeBagagem() {
        return capacidadeBagagem;
    }

    public CategoriaJato getCategoria() {
        return categoria;
    }

    /**
     * Imprime na consola, em uma linha, todas as instalações que o avaio contem
     */
    public void getListaInstalacoes(){
        for ( Instalacao instalacao : this.listaInstalacoes){
            System.out.print("| " + instalacao + " |");
        }
    }

    /**
     * adiciona instalações ao aviao
     * @param instalacao tipo enum Instalacao
     */
    public void addInstalacao(Instalacao instalacao){
        this.listaInstalacoes.add(instalacao);
    }

    /**
     * remove uma instalação do aviao
     * @return true se removeu / false se nao existir a instalação
     */
    public boolean RemoveInstalacao(Instalacao instalacao){
         boolean validacao = this.listaInstalacoes.contains(instalacao);
         if (validacao){
             this.listaInstalacoes.remove(instalacao);
             return true;
         }else {
             return false;
         }
    }

    /**
     * exibe os detalhes do jato
     */
    @Override
    public void ExebirDetalhes(){
        System.out.println();
        super.ExebirDetalhes();
        System.out.println("Nº Ocupantes: " + this.lotacao + " | Capacidade de Bagagem: " + this.capacidadeBagagem + " | Categoria: " + this.categoria);
        this.getListaInstalacoes();
        System.out.println();
        System.out.println("*************** Preço: " + this.getPreco() + " ***************");
        System.out.println();
    }
}
