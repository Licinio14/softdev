package ex03.TDocs;

import ex03.Documento;
import ex03.TipoDoc;

public class Calculo extends Documento {
    public Calculo(String nome, String autor, String extencao, TipoDoc tipo) {
        super(nome, autor, extencao, tipo);
    }

    @Override
    public void open() {
        System.out.println("A abrir o documento de " + this.tipo + " " + this.nome + "." + this.extencao);
    }

    @Override
    public void save() {
        System.out.println("Alterações do " + this.autor + " gravadas");
    }

    @Override
    public void close() {
        System.out.println("A fechar o documento de " + this.tipo);
    }
}
