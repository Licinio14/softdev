//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] nomes = new int[5];
        nomes[0] = 10;
        nomes[1] = 15;
        nomes[2] = 54;
        nomes[3] = 2;
        nomes[4] = 45;

        String[] nomes2 = new String[]{"Joao","Maria","Pedro","Maria","Pedro"};
        for (int i = 0;i < nomes2.length; i++){
            System.out.println(i + " = " + nomes2[i]);
        }


        for (String nome : nomes2){
            System.out.println(nome);
        }



        int[][] nums = new int[2][2];
        nums[0][0] = 1;
        nums[0][1] = 2;
        nums[1][0] = 3;
        nums[1][1] = 4;

        int[][][] coords = new int[2][2][2];

        for (int i = 0; i < 2 ; i++){
            for (int j = 0; j < 2; j++){
                System.out.println(nums[i][j]);
            }
        }



    }
}