package ex02.criarTacos.tiposTacos;

import ex02.Taco;

public class TacoCarne extends Taco {
    public TacoCarne(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("A preparar taco de carne");
    }

    @Override
    public void bake() {
        System.out.println("A cozinhar taco de carne");
    }

    @Override
    public void box() {
        System.out.println("A embalar taco de carne");
    }
}
