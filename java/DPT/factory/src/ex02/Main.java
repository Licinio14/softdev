package ex02;

import ex02.criarTacos.CriarTacos;

public class Main {
    public static void main(String[] args) {

        Taco taco1 = CriarTacos.criarTatos(TipoTaco.TACO_CARNE,"Taco Mexicano");

        Taco taco2 = CriarTacos.criarTatos(TipoTaco.TACO_VEGETARIANO,"Taco Vegetariano");

        taco1.prepare();
        taco1.bake();
        taco2.prepare();
        taco2.bake();
        taco2.box();
        taco1.box();


    }

}
