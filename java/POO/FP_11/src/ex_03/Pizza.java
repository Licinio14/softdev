package ex_03;

import ex_03.enums.TamanhoPizza;

import java.util.ArrayList;

public class Pizza {
    protected int codigo;
    protected String nome;
    protected String descricao;
    protected double preco;
    protected TamanhoPizza tamanho;
    protected ArrayList<ListaIngredientes> ingredientes;

    public Pizza(int codigo, String nome, String descricao, double preco, TamanhoPizza tamanho) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ingredientes = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public TamanhoPizza getTamanho() {
        return tamanho;
    }

    public boolean AdicionarIngrediente(ListaIngredientes ingrediente) {
        if (this.ingredientes.size() >= 5) {
            return false;
        }else {
            if (this.ingredientes.contains(ingrediente)) {
                return false;
            }else {
                this.ingredientes.add(ingrediente);
                return true;
            }
        }
    }

    public void EditarQtIngrediente(Ingrediente testeIngrediente, int quantidade) {
        for (ListaIngredientes ingrediente : this.ingredientes) {
            if (ingrediente.getIngrediente() == testeIngrediente) {
                ingrediente.EditarQuantidade(quantidade);
            }
        }
    }

    public void ExcluirIngrediente(int idIngrediente) {
        for (ListaIngredientes ingrediente : this.ingredientes) {
            Ingrediente testeIngrediente = ingrediente.getIngrediente();
            if (testeIngrediente.getCodigo() == idIngrediente) {
                this.ingredientes.remove(ingrediente);
            }
        }
    }

    public double CalcularCalorias() {
        double calorias = 0;
        for (ListaIngredientes ingrediente : this.ingredientes) {
            calorias += ingrediente.CalcularCalorias();
        }
        return calorias;
    }

    public void InfoPrint(){
        String medida;
        System.out.println("***** " + this.nome + " ******");
        System.out.println("Código: " + this.codigo);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Preço: " + this.preco);
        System.out.println("Tamanho: " + this.tamanho);
        for (int i = 0; i < 5; i++) {
            Ingrediente novoIng = this.ingredientes.get(i).getIngrediente();
            switch (novoIng.getMedida()){
                case GRAMAS -> medida = "g.";
                case LITROS -> medida = "L.";
                case UNIDADES -> medida = "uni.";
                default -> medida = ".";
            }
            System.out.println("Ingrediente " + i + ": " + "[ " + novoIng.getCodigo() + " | " + novoIng.getNome() + " | " + novoIng.getMedida() + " | " + novoIng.getKcalMedida() + " Kcal]: " + this.ingredientes.get(i).getQuantidade() + medida);
        }
    }


}
