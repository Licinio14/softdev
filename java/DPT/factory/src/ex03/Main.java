package ex03;

import ex03.CriarDocs.CriarDocs;

public class Main {
    public static void main(String[] args) {

        Documento doc1 = CriarDocs.CriarDocs(TipoDoc.DOCUMENTO_TEXTO,"documento1","Luis");

        doc1.open();
        doc1.save();
        doc1.close();
    }
}
