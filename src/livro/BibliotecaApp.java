package livro;

import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho máximo da biblioteca: ");
        int tamanhoMaximo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        Biblioteca biblioteca = new Biblioteca(tamanhoMaximo);
        int opcao;

        do {
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Pesquisar Livro");
            System.out.println("3. Alterar Livro");
            System.out.println("4. Excluir Livro");
            System.out.println("5. Listar Livros");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano de Publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    boolean adicionado = biblioteca.adicionarLivro(new Livro(titulo, autor, ano));
                    if (adicionado) {
                        System.out.println("Livro adicionado com sucesso.");
                    } else {
                        System.out.println("Não foi possível adicionar o livro. Biblioteca cheia.");
                    }
                    break;

                case 2:
                    System.out.print("Título do livro para pesquisa: ");
                    titulo = scanner.nextLine();
                    Livro livro = biblioteca.pesquisarLivro(titulo);
                    if (livro != null) {
                        System.out.println("Livro encontrado: " + livro);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Título do livro para alterar: ");
                    String tituloAntigo = scanner.nextLine();
                    System.out.print("Novo Título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Novo Autor: ");
                    String novoAutor = scanner.nextLine();
                    System.out.print("Novo Ano de Publicação: ");
                    int novoAno = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    boolean alterado = biblioteca.alterarLivro(tituloAntigo, novoTitulo, novoAutor, novoAno);
                    if (alterado) {
                        System.out.println("Livro alterado com sucesso.");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Título do livro para excluir: ");
                    titulo = scanner.nextLine();
                    boolean excluido = biblioteca.excluirLivro(titulo);
                    if (excluido) {
                        System.out.println("Livro excluído com sucesso.");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 5:
                    biblioteca.listarLivros();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 6);

        scanner.close();
    }
}
