package mycontacts.app;
import mycontacts.controller.Agenda;
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

            int opcao = sc.nextInt();
            sc.nextLine(); // limpando a entrada para uma nova opção ser carregada posteriormente

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Digite o telefone: ");
                    String telefone = sc.nextLine();

                    System.out.println("Digite o e-mail: ");
                    String email = sc.nextLine();
                    agenda.adicionarContato(nome, telefone, email);
                    break;
                case 2:
                    agenda.listarContatos();
                    break;
                case 3:
                    System.out.println("Digite o nome do contato que deseja: ");
                    String nomePesq = sc.nextLine();
                    agenda.pesquisarContato(nomePesq);
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    agenda.Divisor();
                    System.out.println("Opção inválida, tente os valores recomendados!");
                    agenda.Divisor();
            }

        }
    }


}
