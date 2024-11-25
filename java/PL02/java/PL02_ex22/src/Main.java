import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int bytes = 0, megabytes = 0;

        System.out.println("Insira a quantidade de megabytes pretendida: ");
        megabytes = in.nextInt();
        bytes = megabytes * 1024 * 1024;
        System.out.println(megabytes + " megabytes é iquivalente a " + bytes + " bytes");

    }
}