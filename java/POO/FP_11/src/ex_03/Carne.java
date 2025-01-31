package ex_03;

import ex_03.enums.Medida;
import ex_03.enums.OrigemIngrediente;
import ex_03.enums.TipoCarne;

public class Carne extends Topping{
    protected TipoCarne tipo;

    public Carne(String codigo, String nome, Medida medida, Double kcalMedida, OrigemIngrediente origem, TipoCarne tipo) {
        super(codigo, nome, medida, kcalMedida, origem);
        this.tipo = tipo;
    }
}
