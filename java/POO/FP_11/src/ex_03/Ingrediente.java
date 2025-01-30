package ex_03;

import ex_03.enums.Medida;

public class Ingrediente {
    protected int codigo;
    protected String nome;
    protected Medida medida;
    protected int kcalMedida;

    public Ingrediente(int codigo, String nome, Medida medida, int kcalMedida) {
        this.codigo = codigo;
        this.nome = nome;
        this.medida = medida;
        this.kcalMedida = kcalMedida;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Medida getMedida() {
        return medida;
    }

    public int getKcalMedida() {
        return kcalMedida;
    }
}
