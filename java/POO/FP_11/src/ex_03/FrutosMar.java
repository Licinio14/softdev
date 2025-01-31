package ex_03;

import ex_03.enums.Medida;
import ex_03.enums.OrigemIngrediente;
import ex_03.enums.TipoFrutosMar;

public class FrutosMar extends Topping{
    protected TipoFrutosMar tipo;

    public FrutosMar(String codigo, String nome, Medida medida, Double kcalMedida, OrigemIngrediente origem, TipoFrutosMar tipo) {
        super(codigo, nome, medida, kcalMedida, origem);
        this.tipo = tipo;
    }
}
