package ex03;

public abstract class Documento {
    protected String nome;
    protected String autor;
    protected String extencao;
    protected TipoDoc tipo;

    public Documento(String nome, String autor, String extencao, TipoDoc tipo) {
        this.nome = nome;
        this.autor = autor;
        this.extencao = extencao;
        this.tipo = tipo;
    }

    public abstract void open();

    public abstract void save();

    public abstract void close();
}
