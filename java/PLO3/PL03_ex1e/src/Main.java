import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        int menu1;

        do {
            System.out.println("Bem-vindo\nEscolha uma opção:\n1 - Calculadora\n2 - lista\n3 - Calendário\n4 - Jogar Pedra-papel-tesoura\n0 - Sair");
            menu1 = in.nextInt();

            switch (menu1) {
                case 0:
                    break;
                case 1:
                    clear();
                    Calculadora();
                    break;
                case 2:
                    clear();
                    Lista();
                    break;
                case 3:
                    clear();
                    Calendario();
                    break;
                case 4:
                    clear();
                    Jogo();
                    break;
                default:
                    System.out.println("Insira uma opção válida!!!");
                    break;

            }

        } while (menu1 != 0);


    }

    private static void Jogo() {
        int resposta = 0, ai = 0;

        do {

            System.out.println("Escolha uma opção: \n 1 - Pedra\n 2 - Papel\n 3 - Tesoura\n 0 - Terminar");
            resposta = in.nextInt();
            ai = (int) (Math.random() * 3);

            if (resposta == 1 || resposta == 2 || resposta == 3){
                switch (ai) {
                    case 0:
                        System.out.println("Computador: Pedra");
                        break;
                    case 1:
                        System.out.println("Computador: Papel");
                        break;
                    case 2:
                        System.out.println("Computador: Tesoura");
                        break;
                    default:
                        System.out.println("erro na ai");
                        break;
                }
            }

            switch (resposta) {
                case 0:
                    break;
                    // 0 - Pedra / 1 - Papel / 2 - Tesoura
                case 1:
                    switch (ai) {
                        case 0:
                            System.out.println("Empate!");
                            break;
                        case 1:
                            System.out.println("Perdeu!");
                            break;
                        case 2:
                            System.out.println("Ganhou!");
                            break;
                        default:
                            System.out.println("erro na ai");
                            break;
                    }
                    break;
                    // 0 - Pedra / 1 - Papel / 2 - Tesoura
                case 2:
                    switch (ai) {
                        case 0:
                            System.out.println("Ganha!");
                            break;
                        case 1:
                            System.out.println("Empate!");
                            break;
                        case 2:
                            System.out.println("Perdeu!");
                            break;
                        default:
                            System.out.println("erro na ai");
                            break;
                    }
                    break;
                    // 0 - Pedra / 1 - Papel / 2 - Tesoura
                case 3:
                    switch (ai) {
                        case 0:
                            System.out.println("Perdeu!");
                            break;
                        case 1:
                            System.out.println("Ganhou!");
                            break;
                        case 2:
                            System.out.println("Empate!");
                            break;
                        default:
                            System.out.println("erro na ai");
                            break;
                    }
                    break;
                default:
                    System.out.println("Insira uma resposta valida!!!");
                    break;
            }


        } while (resposta != 0);
        clear();

    }

    private static void Calculadora() {
        int menu2;

        do {
            System.out.println("\nAplicação 1: Calculadora\n1 - Somar\n2 - Subtrair\n3 - Multiplicar\n4 - Dividir\n0 - Voltar ao menu anterior");
            menu2 = in.nextInt();

            switch (menu2) {
                case 0:
                    clear();
                    break;
                case 1:
                    clear();
                    Somar();
                    break;
                case 2:
                    clear();
                    Subtrair();
                    break;
                case 3:
                    clear();
                    Multiplicar();
                    break;
                case 4:
                    clear();
                    Dividir();
                    break;
                default:
                    System.out.println("Insira uma opção válida!!!");
            }

        } while (menu2 != 0);
    }

    private static void Dividir() {
        double div, num1, num2;
        System.out.println("Insira os dois números para somar");
        System.out.println("Insira o 1º número: ");
        num1 = in.nextDouble();
        System.out.println("Insira o 2º número: ");
        num2 = in.nextDouble();
        div = num1 / num2;
        System.out.println("A divisão entre os números " + num1 + " e " + num2 + " é " + div);
    }

    private static void Multiplicar() {
        double mul, num1, num2;
        System.out.println("Insira os dois números para somar");
        System.out.println("Insira o 1º número: ");
        num1 = in.nextDouble();
        System.out.println("Insira o 2º número: ");
        num2 = in.nextDouble();
        mul = num1 * num2;
        System.out.println("A multiplicação entre os números " + num1 + " e " + num2 + " é " + mul);
    }

    private static void Somar() {
        double soma, num1, num2;
        System.out.println("Insira os dois números para somar");
        System.out.println("Insira o 1º número: ");
        num1 = in.nextDouble();
        System.out.println("Insira o 2º número: ");
        num2 = in.nextDouble();
        soma = num1 + num2;
        System.out.println("A soma entre os números " + num1 + " e " + num2 + " é " + soma);
    }

    private static void Subtrair() {
        double sub, num1, num2;
        System.out.println("Insira os dois números para subtrair");
        System.out.println("Insira o 1º número: ");
        num1 = in.nextDouble();
        System.out.println("Insira o 2º número: ");
        num2 = in.nextDouble();
        sub = num1 - num2;
        System.out.println("A subtração ente os números " + num1 + " e " + num2 + " é " + sub);
    }

    private static void Lista() {

        int num1, num2;

        System.out.println("Digites o primeiro e ultimo número da lista: ");
        System.out.println("Número para começar: ");
        num1 = in.nextInt();
        System.out.println("Número para terminar: ");
        num2 = in.nextInt();

        if (num1 < num2) {
            for (int i = num1; i <= num2; i++) {
                System.out.println(i);
            }
        } else if (num1 == num2) {
            System.out.println("Os números sao iguais");
        } else {
            for (int i = num1; i >= num2; i--) {
                System.out.println(i);
            }
        }
    }

    private static void Calendario() {
        int resp = 0, menu3 = 0;

        do {
            System.out.println("\nAplicação 3: Calendario:\n1 - Saber se é bissexto\n2 - Converter dias em anos/semanas/dias\n0 - Voltar ao menu anterior");
            menu3 = in.nextInt();

            switch (menu3) {
                case 0:
                    clear();
                    break;
                case 1:
                    clear();
                    Bissexto();
                    break;
                case 2:
                    clear();
                    Converdias();
                    break;
                default:
                    System.out.println("Insira uma opção válida!!!");
            }

        } while (menu3 != 0);

    }

    private static void Converdias() {
        int dias = 0, semanas = 0, anos = 0, resposta = 0, teste = 0;
        String an, di, se;

        System.out.println("Insira o número de dias: ");
        resposta = in.nextInt();
        teste = resposta;

        if (teste > 0) {
            while (teste >= 365) {
                teste = teste - 365;
                anos++;
            }
            while (teste >= 7) {
                teste = teste - 7;
                semanas++;
            }
            while (teste > 0) {
                teste = teste - 1;
                dias++;
            }
        } else {
            System.out.println("Resposta invaliada!");
            return;
        }

        if (anos == 1) {
            an = " ano ";
        } else {
            an = " anos ";
        }
        if (semanas == 1) {
            se = " semana ";
        } else {
            se = " semanas ";
        }
        if (dias == 1) {
            di = " dia.";
        } else {
            di = " dias.";
        }


        System.out.println(resposta + " dias são " + anos + an + semanas + se + dias + di);

    }

    private static void Bissexto() {
        int resp;
        System.out.println("Insira o ano: ");
        resp = in.nextInt();

        if ((resp % 4) != 0) {
            System.out.println("O ano não é bissexto");
        } else if ((resp % 100) != 0) {
            System.out.println("O ano é bissexto");
        } else if ((resp % 400) == 0) {
            System.out.println("O ano é bissexto");
        } else {
            System.out.println("Erro!");
        }
    }

    private static void clear() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("\n");
        }
    }
    

}