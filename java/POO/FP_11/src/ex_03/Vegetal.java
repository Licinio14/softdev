package ex_03;

import ex_03.enums.Medida;
import ex_03.enums.OrigemIngrediente;
import ex_03.enums.TipoVegetal;

public class Vegetal extends Topping{
    protected TipoVegetal tipo;

    public Vegetal(String codigo, String nome, Medida medida, Double kcalMedida, OrigemIngrediente origem, TipoVegetal tipo) {
        super(codigo, nome, medida, kcalMedida, origem);
        this.tipo = tipo;
    }
}
