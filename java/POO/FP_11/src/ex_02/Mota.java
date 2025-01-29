package ex_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mota extends Veiculo{

    public Mota(String marca, String modelo, int fabrico, int potencia, int cilindrada, TipoCombustivel combustivel, double litros100km) {
        super(marca, modelo, fabrico, potencia, cilindrada, combustivel, litros100km);
    }

    public ArrayList<String> Imagem(){
        String linha = "";
        ArrayList<String> texto = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/ex_02/Mota.txt"));

            while ((linha = br.readLine()) != null) {
                texto.add(linha);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return texto;

    }
}
