package EX_09;

public class Produto {
    private String nome;
    private double preco;
    private int stock = 0;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int getStock() {

        return this.stock;

    }


    public void setStockADD(int stock) {
        this.stock += stock;
        System.out.println("Foram compradas " + stock + " do produto " + this.nome);
    }

    public void setStockSUB(int stock) {
        if (this.stock < stock){
            System.out.println("Não existe stock suficiente para vender " + stock + " " + this.nome + ". Existem: " + this.stock);
        } else if (this.stock > stock) {
            this.stock -= stock;
            System.out.println(stock + " " + this.nome +" foram vendidos. Restam: " + this.stock);

        }

    }
}
