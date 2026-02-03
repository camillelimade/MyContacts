package mycontacts.controller;

import mycontacts.model.Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Contato> contatos = new ArrayList<>();

    public void Divisor() {
        System.out.println("-----------------------------------");
    }

    public void adicionarContato(String nome, String telefone, String email) {
        Contato novoContato = new Contato(nome, telefone, email);
        contatos.add(novoContato);
        Divisor();
        System.out.println("Contato " + nome + " adicionado com sucesso!");
        Divisor();
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
        if (nomePesq.isEmpty()){
            Divisor();
            System.out.println("Digite outro nome, ou verifique o que enviou!");
            Divisor();
        }else {
            for (int i = 0; i < contatos.size(); i++) {
                boolean Pesquisa = nomePesq.equalsIgnoreCase(contatos.get(i).getNome());
                if (Pesquisa){
                    Divisor();
                    System.out.println("A conexão foi encontrada: ");
                    System.out.println(contatos.get(i).toString());
                    Divisor();
                } else if (i == contatos.size() -1 && Pesquisa == false) {
                    System.out.println("A conexão não foi encontrada! ");
                }

            }
        }
    }


    public static void main(String[] args) {

    }
}
