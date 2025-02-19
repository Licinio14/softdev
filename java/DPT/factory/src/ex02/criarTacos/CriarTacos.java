package ex02.criarTacos;

import ex02.Taco;
import ex02.TipoTaco;
import ex02.criarTacos.tiposTacos.TacoCarne;
import ex02.criarTacos.tiposTacos.TacoFrango;
import ex02.criarTacos.tiposTacos.TacoVegetariano;

import java.util.IllegalFormatException;

public class CriarTacos {
    public static Taco criarTatos(TipoTaco tipo,String nome){
        switch (tipo){
            case TACO_CARNE -> {
                return new TacoCarne(nome);
            }
            case TACO_FRANGO -> {
                return new TacoFrango(nome);
            }
            case TACO_VEGETARIANO -> {
                return new TacoVegetariano(nome);
            }
            default -> {
                throw new IllegalArgumentException("Tipod e Taco invalido");
            }
        }
    }
}
