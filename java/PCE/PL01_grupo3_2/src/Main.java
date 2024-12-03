import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    static int[] array, arrayreserva;
    static int max = 0, count = 1;

    public static void main(String[] args) throws InterruptedException {
        // criar uma app que peça um conjunto de numeros inteiros e os guarde num array
        boolean valimenu = true;
        int menu = 0;


        Preencherarray();
        do {
            System.out.println("O que pretende fazer?");
            System.out.println("|0 - Sair|\t|1 - Ordenar de forma crescente|\t|2 - Ordenar de forma decrescente|\t|3 - Imprimir array|\n|4 - Inserir mais valores|\t|5 - Substituir um calor|\t|6 - Adicionar um elemento no meio do array|\n|7 - Eliminar uma posição do array|");
            in = new Scanner(System.in);
            menu = in.nextInt();

            switch (menu){
                case 0:
                    valimenu = false;
                    System.out.println("Terminando o programa.");
                    Carregar(30);
                    break;
                case 1:
                    Ordenar(1);
                    Clear();
                    break;
                case 2:
                    Ordenar(2);
                    Clear();
                    break;
                case 3:
                    Clear();
                    Imprimir();
                    break;
                case 4:
                    Clear();
                    //Adicionar();
                    break;
                case 5:
                    Clear();
                    //Substituir();
                    break;
                case 6:
                    Clear();
                    //Adicionarnovo();
                    break;
                case 7:
                    Clear();
                    //Eliminar();
                    break;
                default:
                    System.out.println("Insira um valor valido!");
                    break;
            }

        }while (valimenu);




    }

    private static void Imprimir() {
        for (int i = 0; i < max; i++){
            System.out.print("|" + array[i] + "|\t");
        }
        System.out.println();
    }

    private static void Ordenar(int i) throws InterruptedException {
        // ordenar o array crescente e decrescente
        int count = 0;

        if (i == 1){
            Arrays.sort(array);
            System.out.println("Ordenando o array");
            Carregar(20);
        }else {
            Arrays.sort(array);
            int[] ordem = new int[array.length];
            System.arraycopy(array,0,ordem,0,array.length);
            for (int j = array.length - 1; j >= 0; j--) {
                array[count] = ordem[j];
                count++;
            }
            System.out.println("Ordenando o array");
            Carregar(20);
        }
    }

    private static void Carregar(int i) throws InterruptedException {
        for (int j = 0; j < 50; j++) {
            System.out.print("///");
            Thread.sleep(i);
        }
        System.out.println();
    }

    private static void Preencherarray() {
        // preencher o array global
        boolean vali = true;
        array = new int[max];
        int resposta = 0;

        do{

            System.out.println("Qual é o " + count + "ª numero? |Insira algo diferente de um numero para terminar!");



            try{
                resposta = in.nextInt();

                max++;
                count++;
                arrayreserva = new int[max];
                System.arraycopy(array, 0, arrayreserva, 0, array.length);
                array = new int[max];
                System.arraycopy(arrayreserva, 0, array, 0, arrayreserva.length - 1);
                array[max - 1] = resposta;

            }catch (InputMismatchException e){
                vali = false;
            }

        }while(vali);

    }

    public static void Clear() {
        for (int i = 0; i < 80; i++){
            System.out.println();
        }
    }

}