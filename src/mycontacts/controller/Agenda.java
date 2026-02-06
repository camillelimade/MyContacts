package mycontacts.controller;
import mycontacts.exceptions.ContatoDuplicadoException;
import mycontacts.exceptions.DadosContatoInvalidosException;
import mycontacts.model.Contato;
import java.util.ArrayList;


public class Agenda {
    private ArrayList<Contato> contatos = new ArrayList<>();

    public void Divisor() {
        System.out.println("-----------------------------------");
    }

    public void adicionarContato(String nome, String telefone, String email) throws DadosContatoInvalidosException, ContatoDuplicadoException  {
        if (nome == null || nome.isBlank()
                || telefone == null || telefone.isBlank()
                || email == null || email.isBlank()) {
            throw new DadosContatoInvalidosException(
                    "Nome, telefone e email são obrigatórios."
            );
        }

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                throw new ContatoDuplicadoException(
                        "Já existe um contato com esse nome."
                );
            }
        }

        Contato novoContato = new Contato(nome, telefone, email);
        contatos.add(novoContato);
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            Divisor();
            System.out.println("Não foi encontrada nenhuma conexão, tente registrar alguém antes!");
            Divisor();
            return;
        }
        Divisor();
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("Contato " + (1 + i));
            System.out.println(contatos.get(i).toString());
            Divisor();
        }
    }

    public void pesquisarContato(String nomePesq) {
        if (nomePesq.isEmpty()) {
            Divisor();
            System.out.println("Digite outro nome, ou verifique o que enviou!");
            Divisor();
        } else {
            for (int i = 0; i < contatos.size(); i++) {
                boolean Pesquisa = nomePesq.equalsIgnoreCase(contatos.get(i).getNome());
                if (Pesquisa) {
                    Divisor();
                    System.out.println("A conexão foi encontrada: ");
                    System.out.println(contatos.get(i).toString());
                    Divisor();
                } else if (i == contatos.size() - 1 && Pesquisa == false) {
                    System.out.println("A conexão não foi encontrada! ");
                }

            }
        }
    }

    public void excluirContato(String nomeExcluir) {
        if (nomeExcluir.isEmpty()) {
            Divisor();
            System.out.println("Digite outro nome para a exclusão, ou verifique o que enviou!");
            Divisor();
        } else {
            for (int i = 0; i < contatos.size(); i++) {
                boolean Exclusao = nomeExcluir.equalsIgnoreCase(contatos.get(i).getNome());
                if (Exclusao) {
                    Divisor();
                    System.out.println("A conexão foi excluída! ");
                    contatos.remove(i);
                    Divisor();
                } else if (i == contatos.size() - 1 && Exclusao == false) {
                    System.out.println("A conexão não foi encontrada, verifique a listagem! ");
                }

            }
        }
    }


    public static void main(String[] args) {

    }
}
