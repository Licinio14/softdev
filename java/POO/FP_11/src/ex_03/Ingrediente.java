package ex_03;

import ex_03.enums.Medida;

public class Ingrediente {
    protected String codigo;
    protected String nome;
    protected Medida medida;
    protected Double kcalMedida;

    public Ingrediente(String codigo, String nome, Medida medida, Double kcalMedida) {
        this.codigo = codigo;
        this.nome = nome;
        this.medida = medida;
        this.kcalMedida = kcalMedida;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Medida getMedida() {
        return medida;
    }

    public Double getKcalMedida() {
        return kcalMedida;
    }


}
