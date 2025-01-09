package Ex_07;

public class Livro {
    private String titulo;
    private String autor;
    private String categoria;
    private int numeroPaginas;
    private String isbn;

    Livro(String titulo, String autor, String categoria, int numeroPaginas, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    public void exibirDetalhes() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Numero de Paginas: " + this.numeroPaginas);
        System.out.println("ISBN: " + this.isbn);
    }


}
