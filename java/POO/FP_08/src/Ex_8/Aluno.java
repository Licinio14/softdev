package Ex_8;

public class Aluno {
    private String nome;
    private int idade;
    private Curso curso;
    private double media;

    Aluno(String nome, int idade, Curso curso, double media) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.media = media;
    }

    public void Situacao(){

        if(this.media < 9.5){
            System.out.println("Reprovado");
        }else {
            System.out.println("Aprovado");
        }

    }
}