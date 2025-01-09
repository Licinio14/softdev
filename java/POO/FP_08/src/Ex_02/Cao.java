package Ex_02;

public class Cao {

    //atributos de instancia
    //metodos construtor
    //metodos de acesso
    //metodos de instancia
    private String nome;
    private String raca;
    private String latido = "Au au au";

    Cao(String nome, String raca){
        this.nome = nome;
        this.raca = raca;
    }

    public String getNome(){
        return this.nome;
    }

    public String getRaca(){
        return this.raca;
    }

    public String getLatido(){
        return this.latido;
    }

    public void Ladrar(){
        System.out.println(latido);
    }

    public void setLatido(String latido){
        this.latido = latido;
    }

}
