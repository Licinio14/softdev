package EX_01;

public class Main {
    public static void main(String[] args) {

        Musica m1 = new Musica("1 - Baile da Madeira",Genero.POP,"Joaquim",347);
        Musica m2 = new Musica("2 -NaraRara",Genero.ELETRONICA,"Maria",647);
        Musica m3 = new Musica("3 - MainRockShock",Genero.ROCK,"Manuel",147);
        Musica m4 = new Musica("4 - Alto",Genero.FADO,"Jose Ralo",547);
        Musica m5 = new Musica("5 - Maitai",Genero.POP,"Maria Leal",847);
        Musica m6 = new Musica("6 - Maria Da Caverna",Genero.FUNK,"Marco",321);

        MusicPlayer listaMusica = new MusicPlayer();

        System.out.println("Vai ser adicionado 6 musicas\n");
        listaMusica.AddMusicas(m1);
        listaMusica.AddMusicas(m2);
        listaMusica.AddMusicas(m3);
        listaMusica.AddMusicas(m4);
        listaMusica.AddMusicas(m5);
        listaMusica.AddMusicas(m6);

        listaMusica.ImprimirRelatorio();

        System.out.println("\nVai ser trocada a 1º com a 6º\n");

        listaMusica.TrocarMusicaProgramacao(m1,m6);
        listaMusica.ImprimirRelatorio();

        System.out.println("\nVai ser removida a musica n3º\n");

        listaMusica.RemoverProgramacao(m3);
        listaMusica.ImprimirRelatorio();

        System.out.println("\nVai ser calculada a duração da programação\n");

        String tempo = listaMusica.DuracaoProgramacao();
        System.out.println("A duração da programação é: " + tempo);


        System.out.println("\nVai ser limpado a programação e recalculada a duração da programação\n");

        listaMusica.LimparProgramacao();
        tempo = listaMusica.DuracaoProgramacao();
        System.out.println("A nova duração da programação é: " + tempo);



    }
}
