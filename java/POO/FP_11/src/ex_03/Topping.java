package ex_03;

import ex_03.enums.Medida;
import ex_03.enums.OrigemIngrediente;

public class Topping extends Ingrediente {
    protected OrigemIngrediente origem;

    public Topping(String codigo, String nome, Medida medida, Double kcalMedida, OrigemIngrediente origem) {
        super(codigo, nome, medida, kcalMedida);
        this.origem = origem;
    }
}
