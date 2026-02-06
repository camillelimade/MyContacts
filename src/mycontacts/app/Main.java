package mycontacts.app;
import mycontacts.controller.Agenda;
import mycontacts.exceptions.ContatoDuplicadoException;
import mycontacts.exceptions.ContatoNaoEncontradoException;
import mycontacts.exceptions.DadosContatoInvalidosException;
import mycontacts.model.Contato;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("════ ⋆ ★ MyContacts - Suas conexões em um só lugar ★ ⋆ ════");
            System.out.println("Nossos Serviços: ");
            System.out.println(" 1. Adicionar novo contato");
            System.out.println(" 2. Listar contatos");
            System.out.println(" 3. Pesquisa por nome");
            System.out.println(" 4. Excluir contato");
            System.out.println(" 5. Sair ");


            int opcao;

            try {
                opcao = sc.nextInt();
                sc.nextLine(); // limpa o buffer

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome: ");
                        String nome = sc.nextLine();

                        System.out.println("Digite o telefone: ");
                        String telefone = sc.nextLine();

                        System.out.println("Digite o e-mail: ");
                        String email = sc.nextLine();

                        try {
                            agenda.adicionarContato(nome, telefone, email);
                            agenda.Divisor();
                            System.out.println("Contato registrado com sucesso! ");
                            agenda.Divisor();
                        } catch (DadosContatoInvalidosException e) {
                            agenda.Divisor();
                            System.out.println(e.getMessage());
                            agenda.Divisor();
                        } catch (ContatoDuplicadoException e) {
                            agenda.Divisor();
                            System.out.println(e.getMessage());
                            agenda.Divisor();
                        }
                        break;
                    case 2:
                        agenda.listarContatos();
                        break;
                    case 3:
                        System.out.println("Digite o nome do contato que deseja: ");
                        String nomePesq = sc.nextLine();
                        try{
                            Contato contato = agenda.pesquisarContato(nomePesq);
                            agenda.Divisor();
                            System.out.println("Conexão não encontrada: ");
                            System.out.println(contato.getNome());
                            agenda.Divisor();
                        } catch (ContatoNaoEncontradoException erro){
                            agenda.Divisor();
                            System.out.println(erro.getMessage());
                            agenda.Divisor();
                        }
                        break;
                    case 4:
                        System.out.println("Digite o nome do contato que deseja excluir: ");
                        String nomeExcluir =  sc.nextLine();
                        try {
                            agenda.excluirContato(nomeExcluir);
                            agenda.Divisor();
                            System.out.println("Conexão" + nomeExcluir + " excluido com sucesso!");
                            agenda.Divisor();
                        } catch (ContatoNaoEncontradoException e) {
                            agenda.Divisor();
                            System.out.println(e.getMessage());
                            agenda.Divisor();
                        }
                        break;
                    case 5:
                        return;
                    default:
                        agenda.Divisor();
                        System.out.println("Opção inválida, tente os valores recomendados!");
                        agenda.Divisor();
                }
            } catch (InputMismatchException e) {
                 agenda.Divisor();
                System.out.println("Por favor, insira um valor numérico inteiro!");
                 agenda.Divisor();
                sc.nextLine(); // descarta a entrada inválida
                continue; // volta para o início do while
            } catch (RuntimeException e) {
                 agenda.Divisor();
                System.out.println("Ocorreu um erro inesperado. Tente novamente.");
                agenda.Divisor();

            }



        }
    }


}
