package ex03.CriarDocs;

import ex03.Documento;
import ex03.TDocs.Apresentacao;
import ex03.TDocs.Calculo;
import ex03.TDocs.Texto;
import ex03.TipoDoc;

public class CriarDocs {
    public static Documento CriarDocs(TipoDoc tipo, String nome, String autor){

        return switch (tipo){
            case APRESENTACAO -> new Apresentacao(nome,autor,".pptx",tipo);
            case FOLHA_DE_CALCULO -> new Calculo(nome,autor,".xlsx",tipo);
            case DOCUMENTO_TEXTO -> new Texto(nome, autor,"docx.",tipo);
        };

    }
}
