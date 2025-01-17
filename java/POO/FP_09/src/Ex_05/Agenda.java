package Ex_05;

public class Agenda {
    private Pessoa[] agendar = new Pessoa[1];

    public Agenda() {

    }

    public void testartamanho(){
        System.out.println("\n\n" + agendar.length);
    }

    public void AdicionarPessoaAgenda(Pessoa pessoaAdicionar){
        int tamanho = agendar.length + 1;
        Pessoa[] agendaTemporaria = new Pessoa[tamanho];

        if (agendar[0] == null){
            agendar[0] = pessoaAdicionar;
        }else {
            for (int i = 0; i < agendar.length; i++) {
                agendaTemporaria[i] = agendar[i];
            }

            agendar = new Pessoa[tamanho];

            for (int i = 0; i < agendaTemporaria.length; i++) {
                agendar[i] = agendaTemporaria[i];
            }
            agendar[tamanho - 1] = pessoaAdicionar;
        }
    }

    public boolean MostrarAgenda(){
        if (agendar[0] == null){
            return false;
        }else {
            for (int i = 0; i < agendar.length; i++) {

                agendar[i].ExivirInformacaoPessoa();

            }
            return true;
        }
    }


}
