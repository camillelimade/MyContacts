package mycontacts.controller;

import mycontacts.exceptions.ContatoDuplicadoException;
import mycontacts.exceptions.ContatoNaoEncontradoException;
import mycontacts.exceptions.DadosContatoInvalidosException;
import mycontacts.model.Contato;

import java.util.ArrayList;


public class Agenda {
    private ArrayList<Contato> contatos = new ArrayList<>();

    public void Divisor() {
        System.out.println("-----------------------------------");
    }

    public void adicionarContato(String nome, String telefone, String email) throws DadosContatoInvalidosException, ContatoDuplicadoException {
        if (nome == null || nome.isBlank()
                || telefone == null || telefone.isBlank()
                || email == null || email.isBlank()) {

            throw new DadosContatoInvalidosException(
                    "Nome, telefone e email são obrigatórios."
            );
        }

        if (!emailValido(email)) {
            throw new DadosContatoInvalidosException(
                    "E-mail inválido. Verifique o formato."
            );
        }
        if (!telefoneValido(telefone)) {
            throw new DadosContatoInvalidosException(
                    "Telefone inválido. Use apenas números (10 ou 11 dígitos)."
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

    public Contato pesquisarContato(String nomePesq) throws ContatoNaoEncontradoException {
        if (nomePesq == null || nomePesq.isBlank()) {
            throw new ContatoNaoEncontradoException(
                    "O nome para pesquisa não pode ser vazio."
            );
        }
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nomePesq)) {
                return contato;
            }
        }
        throw new ContatoNaoEncontradoException(
                "A conexão não foi encontrada! Verifique as listadas e volte aqui depois. "
        );
    }

    public void excluirContato(String nomeExcluir) throws ContatoNaoEncontradoException {
        if (nomeExcluir == null || nomeExcluir.isBlank()) {
            throw new ContatoNaoEncontradoException(
                    "O nome para a exclusão não deve ser vazio! "
            );
        }
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().equalsIgnoreCase(nomeExcluir)) {
                contatos.remove(i);
                return;
            }
        }
        throw new ContatoNaoEncontradoException(
                "A conexão não foi encontrada para a exclusão! "
        );
    }

    private boolean emailValido(String email) {
        if (email == null) return false;

        return email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }

    private boolean telefoneValido(String telefone) {
        if (telefone == null) return false;

        return telefone.matches("^\\d{10,11}$");
    }

} // fecha Agenda


