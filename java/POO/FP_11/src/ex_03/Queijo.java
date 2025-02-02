package ex_03;

import ex_03.enums.Medida;
import ex_03.enums.OrigemIngrediente;
import ex_03.enums.TipoQueijo;

public class Queijo extends Topping{
    protected TipoQueijo tipo;

    public Queijo(String codigo, String nome, Medida medida, Double kcalMedida, OrigemIngrediente origem, TipoQueijo tipo) {
        super(codigo, nome, medida, kcalMedida, origem);
        this.tipo = tipo;
    }
}
