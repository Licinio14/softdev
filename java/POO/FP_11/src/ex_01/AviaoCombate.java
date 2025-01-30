package ex_01;

import ex_01.Enums.Arma;
import ex_01.Enums.Instalacao;

import java.util.ArrayList;

public class AviaoCombate extends Aviao{
    protected String paisOrigem;
    protected boolean camuflagem;
    protected ArrayList<Arma> arsenal;

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
     * @param paisOrigem pais onde é fabricado (string)
     * @param camuflagem se tem camuflagem (boolean)
     */
    public AviaoCombate(int numSerie, String modelo, int anoFabrico, double peso, double comprimentoFuselagem, double envergaduraAsas, double alturaCauda, int numeroMotores, double autonomia, double velocidadeMaxima, double preco, String paisOrigem, boolean camuflagem) {
        super(numSerie, modelo, anoFabrico, peso, comprimentoFuselagem, envergaduraAsas, alturaCauda, numeroMotores, autonomia, velocidadeMaxima, preco);
        this.paisOrigem = paisOrigem;
        this.camuflagem = camuflagem;
        this.arsenal = new ArrayList<>();
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public boolean isCamuflagem() {
        return camuflagem;
    }

    /**
     * Imprime na consola, em uma linha, todas as armas que o avaio contem
     */
    public void getListaArmas(){
        System.out.println();
        for ( Arma arma : this.arsenal){
            System.out.print("| " + arma + " | ");
        }
        System.out.println();
    }


    /**
     * adiciona uma arma ao arsenal do aviao (max 3)
     * @param arma enum tipo Arma
     * @return true se adicionar / false se nao tiver espaço e nao adiciona
     */
    public boolean addArma(Arma arma){
        if (this.arsenal.size() == 3){
            return false;
        }else {
            this.arsenal.add(arma);
            return true;
        }
    }

    /**
     * remove uma arma do arsenal do aviao
     * @param arma enum tipo Arma
     * @return true se remover a arma / false caso a arma nao exista no arsenal
     */
    public boolean RemoveArma(Arma arma){
        boolean validacao = this.arsenal.contains(arma);
        if (validacao){
            this.arsenal.remove(arma);
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
        System.out.println("Pais: " + this.paisOrigem + " | Camuflagem: " + this.camuflagem);
        System.out.println("*************** Preço: " + this.getPreco() + " ***************");
        System.out.println();
    }

}
