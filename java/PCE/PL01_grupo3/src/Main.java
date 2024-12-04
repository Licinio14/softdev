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
                        Adicionar();
                        break;
                    case 5:
                        Clear();
                        Substituir();
                        break;
                    case 6:
                        Clear();
                        Adicionarnovo();
                        break;
                    case 7:
                        Clear();
                        Eliminar();
                        break;
                    default:
                        System.out.println("Insira um valor valido!");
                        break;
            }

        }while (valimenu);




    }

    private static void Eliminar() {

        boolean vali = true;
        int respo = 0;

        if (array.length == 0){
            System.out.println("Array vazio!");
            return;
        }

        int[] teste = new int[array.length - 1];

        do{
            Imprimir();
            System.out.println("Qual é a posição que pretende apagar? Escolha entre 1 e " + max);
            try{
                respo = in.nextInt();
                if (respo > 0 && respo <= max){
                    vali = false;
                }else{
                    System.out.println("Escolha uma opção valida!");
                }

            }catch (InputMismatchException e){
                System.out.println("Insira apenas numeros validos!");
            }

        }while (vali);
        max--;
        teste = new int[max];
        //System.arraycopy(teste, 0, array, 0, teste.length);

        int count = 0;
        vali = true;
        do{
            if (count < respo - 1){
                teste[count] = array[count];
            } else if (count == respo - 1) {
                System.out.println("Posição eliminada");
            }else if (count < array.length){
                teste[count - 1] = array[count];
            }else {
                vali = false;
            }
            count++;
        }while (vali);
        array = new int[max];
        System.arraycopy(teste, 0, array, 0, teste.length);

    }

    private static void Adicionarnovo() {
        boolean vali = true;
        int respo = 0;

        do {
            Imprimir();
            System.out.println("Em que posição pretende adicionar? Entre 1 e " + max);

            try{
                in = new Scanner(System.in);
                respo = in.nextInt();
                if (respo < 1 || respo > max){
                    System.out.println("Insira um valor dentro dos parametros!");
                }else {
                    vali = false;
                }
            }catch (InputMismatchException e){
                System.out.println("Insira apenas numeros!");
            }

        }while (vali);

        vali = true;
        int resposta = 0;
        do {
            System.out.println("Qual é o valor que quer adicionar?");

            try{
                in = new Scanner(System.in);
                resposta = in.nextInt();
                vali = false;
            }catch (InputMismatchException e){
                System.out.println("Insira apenas numeros!");
            }

        }while (vali);

        vali = true;
        int[] teste = new int[array.length + 1];

        int count = 0;
        do{
            if (count < respo - 1){
                teste[count] = array[count];
            } else if (count == respo - 1) {
                teste[count] = resposta;
            }else if (count < teste.length){
                teste[count] = array[count - 1];
            }else {
                vali = false;
            }
            count++;
        }while (vali);
        max++;
        array = new int[max];
        System.arraycopy(teste, 0, array, 0, teste.length);




    }

    private static void Substituir() {
        boolean vali = true, vali2 = true;
        do{
            Imprimir();
            System.out.println("As posições possiveis sao de 1 a " + max);
            System.out.println("Escolha uma posição: ");
            try {
                in = new Scanner(System.in);
                int resposta = in.nextInt();
                if (resposta < 1 || resposta > max){
                    System.out.println("Insira um valor dentro dos parametros!");
                }else {
                    do {
                        System.out.println("Qual é o novo numero da posição: " + resposta);
                        try{
                            in = new Scanner(System.in);
                            int numero = in.nextInt();
                            array[resposta - 1] = numero;
                            vali = false;
                            vali2 = false;
                        }catch (InputMismatchException e){
                            System.out.println("Insira apenas numeros!");
                        }
                    }while (vali2);
                }

            }catch (InputMismatchException e){
                System.out.println("Insira um numero!");
            }


        }while(vali);



    }

    private static void Adicionar() {
        //add mais numeros
        boolean vali = true;
        arrayreserva = new int[max];
        System.arraycopy(array, 0, arrayreserva, 0, array.length);
        int resposta = 0;
        //System.out.println("Quantos numeros pretende inserir?");

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

    private static void Imprimir() {
        for (int i = 0; i < max; i++){
            System.out.println("Posição " + (i+1) + " = " + "|" + array[i] + "|\t");
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