package Ex_06;

public class Competicao {
    private String nome;
    private String pais;
    private Atleta[] listaAtletas;

    public Competicao(String nome, String pais, int maxAtletas) {
        this.nome = nome;
        this.pais = pais;
        this.listaAtletas = new Atleta[maxAtletas];
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public int getNumParticipantes() {
        int count = 0;

        for (int i = 0; i < this.listaAtletas.length; i++) {
            if (this.listaAtletas[i] != null){
                count++;
            }
        }
        return count;
    }

    public Atleta getParticipantes(int index) {
        return this.listaAtletas[index];
    }

    public boolean ADDAtleta(Atleta novoAtleta){
        int max = this.listaAtletas.length;
        int count = 0;

        for (int i = 0; i < max; i++) {
            if (this.listaAtletas[i] != null){
                count++;
            }
        }

        if (count < max){
            this.listaAtletas[count] = novoAtleta;
            return true;
        }else {
            return false;
        }
    }
}
