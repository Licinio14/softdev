package Ex_05;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Clara",28,"clara@gmail.com",918745628);
        Pessoa pessoa2 = new Pessoa("Miguel",80,"Miguel@gmail.com",918785628);
        Pessoa pessoa3 = new Pessoa("Ana",19,"Ana@gmail.com",918259628);
        Pessoa pessoa4 = new Pessoa("Manuel",37,"Manuel@gmail.com",911485628);

        Agenda projectoMain = new Agenda();

        System.out.println("Tenta mostrar a agenda que nao tem ninguem\n");
        boolean existePessoasAgenda = projectoMain.MostrarAgenda();
        if (!existePessoasAgenda) System.out.println("Não existe pessoas na agenda para listar!");

        System.out.println("\n_______________________________________________________\n");

        projectoMain.AdicionarPessoaAgenda(pessoa2);
        projectoMain.AdicionarPessoaAgenda(pessoa1);
        projectoMain.AdicionarPessoaAgenda(pessoa3);
        projectoMain.AdicionarPessoaAgenda(pessoa4);

        System.out.println("Foi adicionada as 4 pessoas, e vai listar a agenda: \n");

        existePessoasAgenda = projectoMain.MostrarAgenda();

        if (!existePessoasAgenda) System.out.println("Não existe pessoas na agenda para listar!");

    }
}
