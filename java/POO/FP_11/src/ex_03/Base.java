package ex_03;

import ex_03.enums.BasePizza;
import ex_03.enums.Medida;

public class Base extends Ingrediente{
    protected BasePizza tipoBase;
    protected String descricao;

    public Base(String codigo, String nome, Double kcalMedida, BasePizza tipoBase, String descricao) {
        super(codigo, nome, Medida.GRAMAS, kcalMedida);
        this.tipoBase = tipoBase;
        this.descricao = descricao;
    }
}
