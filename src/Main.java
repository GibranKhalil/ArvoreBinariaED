import br.com.gibran.modelos.ArvoreBinariaBusca;
import br.com.gibran.modelos.Contato;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao seu gerenciador de contatos ");
        Scanner leitura = new Scanner(System.in);
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        int opcao = 0;
        while (opcao != 5){
            System.out.println("""
               (1) Adicione um novo contato
               (2) Pesquisar pelo nome de um contato
               (3) Listar todos os contatos em ordem alfabética
               (4) Remover um contato existente por nome
               (5) Sair
               
               Digite a opção desejada:
                """);
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String nome = leitura.nextLine();
                    System.out.println("Digite o número do contato:");
                    String numero = leitura.nextLine();

                    Contato novoContato = new Contato(nome,numero, null, null);
                    arvore.adicionaContato(novoContato.getNome(), novoContato.getTelefone());
                    break;
                case 2:
                    System.out.println("Digite o nome do contato:");
                    String nomeBuscado = leitura.nextLine();
                    System.out.println(arvore.pegarContatoPorNome(nomeBuscado));
                    break;
                case 3:
                    arvore.imprimirInOrder();
                    break;
                case 4:
                    System.out.println("Digite o nome do contato:");
                    String nomeARemover = leitura.nextLine();
                    arvore.removeContatoPorNome(nomeARemover);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
            }
        }

    }

}