package ex_01;

import java.util.ArrayList;

public class Catalogo {

    private ArrayList<Aviao> listaAvioes;

    public Catalogo() {
        this.listaAvioes = new ArrayList<>();
    }

    /**
     * Imprime todo o catalogo de avioes
     */
    public void ExibirDetalhes(){
        System.out.println("*****************\tCatalogo de Aviões\t*****************");
        System.out.println("________________________________________________________");
        for (Aviao nAviao : this.listaAvioes){
            System.out.print("Modelo: " + nAviao.modelo + " | Preço: " + nAviao.preco);

            if(nAviao instanceof JatoParticular){
                System.out.println(" | Tipo: Jato Particular");
            }

            if(nAviao instanceof AviaoCombate){
                System.out.println(" | Tipo: Avião de Combate");
            }
        }

    }

    /**
     * Adiciona um aviao ao catalogo
     * @param nAviao enum tipo Aviao
     */
    public void VenderAviao(Aviao nAviao){
        this.listaAvioes.add(nAviao);
    }

    /**
     * Remove um aviao do catalogo
     * @param nAviao enum tipo Aviao
     * @return true se remover o aviao / false caso o aviao nao exista no catalogo
     */
    public boolean ComprarAviao(Aviao nAviao){
        boolean validacao = this.listaAvioes.contains(nAviao);
        if (validacao){
            this.listaAvioes.remove(nAviao);
            return true;
        }else {
            return false;
        }
    }

    /**
     * calcula o total do valor do catalogo
     * @return retorna o total (double)
     */
    public double CalcularTotal(){
        double precoTotal = 0;

        for (Aviao nAviao : listaAvioes){
            precoTotal += nAviao.getPreco();
        }

        return precoTotal;
    }
}
