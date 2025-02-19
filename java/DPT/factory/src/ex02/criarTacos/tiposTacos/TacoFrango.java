package ex02.criarTacos.tiposTacos;

import ex02.Taco;

public class TacoFrango extends Taco {
    public TacoFrango(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("A preparar taco de Frango");
    }

    @Override
    public void bake() {
        System.out.println("A cozinhar taco de Frango");
    }

    @Override
    public void box() {
        System.out.println("A embalar taco de Frango");
    }
}
