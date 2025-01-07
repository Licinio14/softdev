package Ex_02;

public class Main {
    public static void main(String[] args){

        Cao caoPrimeiro = new Cao("Bobi","Lavrador");
        Cao caoSegundo = new Cao("Bolinhas","Husky");
        Cao caoTerceiro = new Cao("Pardo","Lavrador");

        System.out.println(caoPrimeiro.getNome());
        System.out.println(caoPrimeiro.getRaca());
        caoPrimeiro.Ladrar();

        System.out.println();
        caoPrimeiro.setLatido("Woof Woof");

        System.out.println(caoPrimeiro.getNome());
        System.out.println(caoPrimeiro.getRaca());
        caoPrimeiro.Ladrar();

    }
}
