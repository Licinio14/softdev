package ex_03;

public class ListaIngredientes {
    protected Ingrediente ingrediente;
    protected double quantidade;

    public ListaIngredientes(Ingrediente ingrediente, double quantidade) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void EditarQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    protected double CalcularCalorias() {
        return this.ingrediente.getKcalMedida() * this.quantidade;
    }
}
