import java.util.ArrayList;
import java.util.Scanner;

public class _Exer_3 {

    public static class Livro {
        String titulo;
        String autor;
        String status; // "disponível" ou "emprestado"

        public Livro(String titulo, String autor, String status) {
            this.titulo = titulo;
            this.autor = autor;
            this.status = status;
        }
    }

    public static class Biblioteca {
        ArrayList<Livro> livros;

        public Biblioteca() {
            livros = new ArrayList<>();
        }

        public void adicionarLivro(Livro livro) {
            livros.add(livro);
        }

        public void emprestarLivro(String titulo) {
            for (Livro livro : livros) {
                if (livro.titulo.equals(titulo) && livro.status.equals("disponível")) {
                    livro.status = "emprestado";
                    System.out.println("\nLivro " + titulo + " emprestado com sucesso!\n");
                    return;
                }
            }
            System.out.println("\nLivro não disponível para empréstimo.\n");
        }

        public void devolverLivro(String titulo) {
            for (Livro livro : livros) {
                if (livro.titulo.equals(titulo) && livro.status.equals("emprestado")) {
                    livro.status = "disponível";
                    System.out.println("\nLivro " + titulo + " devolvido com sucesso!\n");
                    return;
                }
            }
            System.out.println("\nLivro não encontrado.\n");
        }

        public void exibirLivros() {
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.titulo + ", Autor: " + livro.autor + ", Status: " + livro.status);
            }
        }
    }

    public static void main(String[] args) {

        Scanner dado = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "disponível");
        Livro livro2 = new Livro("1984", "George Orwell", "disponível");
        Livro livro3 = new Livro("A Guerra dos Tronos", "George R.R. Martin", "disponível");
        Livro livro4 = new Livro("O Nome do Vento", "Patrick Rothfuss", "disponível");
        Livro livro5 = new Livro("O Aprendiz", "Joseph Delaney", "disponível");


        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);

        biblioteca.exibirLivros();

        System.out.println("\nDigite o nome do livro que deseja pegar emprestado: ");
        String pegarEmprestado = dado.nextLine();

        biblioteca.emprestarLivro(pegarEmprestado);

        biblioteca.exibirLivros();

        System.out.println("\nDeseja devolver algum livro? ");
        String resposta = dado.nextLine();

        if (resposta.equals("não") || resposta.equals("Não")) {
            System.out.println("Beleza! Até a próxima.");
        } else {
            System.out.println("\nDigite o nome do livro que deseja devolver: ");
            String devolver = dado.nextLine();

            biblioteca.devolverLivro(devolver);

            biblioteca.exibirLivros();
        }
    }
}