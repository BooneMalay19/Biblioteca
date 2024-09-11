package livro;

public class Biblioteca {
    private Livro[] livros;
    private int contador;

    public Biblioteca(int tamanhoMaximo) {
        this.livros = new Livro[tamanhoMaximo];
        this.contador = 0;
    }

    public boolean adicionarLivro(Livro livro) {
        if (contador < livros.length) {
            livros[contador++] = livro;
            return true;
        }
        return false;
    }

    public Livro pesquisarLivro(String titulo) {
        for (int i = 0; i < contador; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return livros[i];
            }
        }
        return null;
    }

    public boolean alterarLivro(String titulo, String novoTitulo, String novoAutor, int novoAno) {
        Livro livro = pesquisarLivro(titulo);
        if (livro != null) {
            livro.setTitulo(novoTitulo);
            livro.setAutor(novoAutor);
            livro.setAnoPublicacao(novoAno);
            return true;
        }
        return false;
    }

    public boolean excluirLivro(String titulo) {
        for (int i = 0; i < contador; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)) {
                // Move os livros seguintes para a esquerda
                for (int j = i; j < contador - 1; j++) {
                    livros[j] = livros[j + 1];
                }
                livros[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public void listarLivros() {
        if (contador == 0) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(livros[i]);
            }
        }
    }
}

