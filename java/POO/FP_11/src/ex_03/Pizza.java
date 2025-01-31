package ex_03;

import ex_03.enums.TamanhoPizza;

import java.util.ArrayList;
import java.util.Objects;

public class Pizza {
    private final int MAX_INGREDIENTES = 5;
    protected String codigo;
    protected String nome;
    protected String descricao;
    protected double preco;
    protected TamanhoPizza tamanho;
    protected ArrayList<ListaIngredientes> ingredientes;

    public Pizza(String codigo, String nome, String descricao, double preco, TamanhoPizza tamanho, ListaIngredientes base,ListaIngredientes topping) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ingredientes = new ArrayList<>();
        this.ingredientes.add(base);
        this.ingredientes.add(topping);
    }

    public String getCodigo() {
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

    public boolean AdicionarToppings(ListaIngredientes listaIngrediente) {
        boolean vali = false;

        if (this.ingredientes.size() >= MAX_INGREDIENTES) {
            return false;
        } else {
            for (int i = 0; i < this.ingredientes.size(); i++) {
                Ingrediente novoIng = this.ingredientes.get(i).getIngrediente();
                Ingrediente ingredienteadd = listaIngrediente.getIngrediente();
                if (novoIng == ingredienteadd) {
                    vali = true;
                    break;
                }
            }

            if (vali) {
                return false;
            } else {
                this.ingredientes.add(listaIngrediente);
                return true;
            }
        }
    }


    public boolean EditarIngrediente(ListaIngredientes ListaIngredienteAntigo ,ListaIngredientes listaIngredienteEditado) {
        int index = -1;

        if(ListaIngredienteAntigo.getIngrediente() instanceof Base){
            return false;
        }else {
            index = this.ingredientes.indexOf(ListaIngredienteAntigo);
            this.ingredientes.set(index,listaIngredienteEditado);
            return true;
        }

    }

    public boolean EditarQtIngrediente(Ingrediente mudarIngrediente, double quantidade){
        Ingrediente ingredienteAlterar = null;
        ListaIngredientes listaAlterar = null;

        for (ListaIngredientes lista : this.ingredientes){
            if (Objects.equals(lista.getIngrediente(), mudarIngrediente)){
                ingredienteAlterar = lista.getIngrediente();
                listaAlterar = lista;
                break;
            }
        }

        if (ingredienteAlterar == null){
            return false;
        }else {
            listaAlterar.EditarQuantidade(quantidade);
                return true;
        }

    }

    public boolean ExcluirIngrediente(String idIngrediente) {
        Ingrediente ingredienteEliminar = null;
        ListaIngredientes listaEliminar = null;

        for (ListaIngredientes lista : this.ingredientes){
            if (Objects.equals(lista.getIngrediente().getCodigo(), idIngrediente)){
                ingredienteEliminar = lista.getIngrediente();
                listaEliminar = lista;
                break;
            }
        }

        if (ingredienteEliminar == null){
            return false;
        }else {
            if(ingredienteEliminar instanceof Base){
                return false;
            }else {
                if (this.ingredientes.size() <= 2){
                    return false;
                }else {
                    this.ingredientes.remove(listaEliminar);
                    return true;
                }
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
        System.out.println("Preço: " + this.preco + "€");
        System.out.println("Tamanho: " + this.tamanho);
        for (int i = 0; i < this.ingredientes.size(); i++) {
            Ingrediente novoIng = this.ingredientes.get(i).getIngrediente();
            switch (novoIng.getMedida()){
                case GRAMAS -> medida = " g.";
                case LITROS -> medida = " L.";
                case UNIDADES -> medida = " uni.";
                default -> medida = ".";
            }
            System.out.println("Ingrediente " + i + ": " + "[ " + novoIng.getCodigo() + " | " + novoIng.getNome() + " | " + novoIng.getMedida() + " | " + novoIng.getKcalMedida() + " Kcal]: " + this.ingredientes.get(i).getQuantidade() + medida);
        }
    }


}
