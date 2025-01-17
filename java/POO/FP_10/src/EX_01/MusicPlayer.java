package EX_01;

import java.util.ArrayList;

public class MusicPlayer {
    private ArrayList<Musica> programacao = new ArrayList<Musica>();

    public boolean AddMusicas(Musica musicaNova){
        this.programacao.add(musicaNova);
        return true;
    }

    public boolean MudarProgramacao(Musica musicaDaLista, Musica novaMusica){
        int index = this.programacao.indexOf(musicaDaLista);
        this.programacao.set(index,novaMusica);

        //en vez do if (return true) else (return false);
        return this.programacao.get(index) == novaMusica;
    }

    /**
     * Troca duas musicas de posição na programação
     * @param musica1 primeira musica
     * @param musica2 segunda musica
     * @return retorna bollean
     */
    public boolean TrocarMusicaProgramacao(Musica musica1, Musica musica2){
        int index = this.programacao.indexOf(musica1);
        int index2 = this.programacao.indexOf(musica2);

        this.programacao.set(index,musica2);
        this.programacao.set(index2,musica1);

        return true;
    }

    /**
     * Troca duas musicas de posição na programação
     * @param index1 primeira musica
     * @param index2 segunda musica
     * @return retorna bollean
     */
    public boolean TrocarMusicaProgramacao(int index1, int index2){
        Musica m1 = this.programacao.get(index1);
        Musica m2 = this.programacao.get(index2);

        this.programacao.set(index1,m2);
        this.programacao.set(index2,m1);

        return true;
    }

    public boolean RemoverProgramacao(Musica MusicaARemover){
        int index = this.programacao.indexOf(MusicaARemover);
        this.programacao.remove(index);

        //en vez do if (return true) else (return false);
        return this.programacao.get(index) != MusicaARemover;
    }

    public boolean LimparProgramacao(){
        this.programacao.clear();

        return this.programacao.isEmpty();
    }

    public void ImprimirRelatorio(){
        System.out.println("\n\n______________________________________________________________\n");
        for (int i = 0; i < this.programacao.size() ; i++) {
            Musica imprimirMusica = this.programacao.get(i);
            System.out.printf("%20s | %20s | %20s | %20s | %20d\n", "Musica " + i + ":", imprimirMusica.getTitulo(), imprimirMusica.getGenero(), imprimirMusica.getArtista(), imprimirMusica.getDuracaoSegundos());
        }
        System.out.println("\n______________________________________________________________\n\n");
    }

    public String DuracaoProgramacao(){
        int duracaoSegundosTotal = 0, horas = 0, minutos = 0, segundos = 0;
        String resultado;
        for (int i = 0; i < this.programacao.size() ; i++) {
            Musica imprimirMusica = this.programacao.get(i);
            duracaoSegundosTotal += imprimirMusica.getDuracaoSegundos();
        }

        horas = duracaoSegundosTotal / 3600;
        minutos = (duracaoSegundosTotal % 3600) / 60;
        segundos = duracaoSegundosTotal % 60;
        resultado = horas + ":" + minutos + ":" + segundos;

        return (resultado);
    }
}
