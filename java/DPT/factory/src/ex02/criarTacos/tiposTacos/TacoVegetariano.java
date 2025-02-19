package ex02.criarTacos.tiposTacos;

import ex02.Taco;

public class TacoVegetariano extends Taco {
    public TacoVegetariano(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("A preparar taco de Vegetariano");
    }

    @Override
    public void bake() {
        System.out.println("A cozinhar taco de Vegetariano");
    }

    @Override
    public void box() {
        System.out.println("A embalar taco de Vegetariano");
    }
}
