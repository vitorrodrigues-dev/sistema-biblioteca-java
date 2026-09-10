package model;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private ArrayList<Livro> livrosCadastrados = new ArrayList<>();

    public void cadastrarAlunos(Aluno alunoNovo) {
        alunosCadastrados.add(alunoNovo);
    }

    public void cadastrarLivros(Livro livroNovo) {
        livrosCadastrados.add(livroNovo);
    }

    public void listarAlunos() {
        for (int posicao = 0; posicao < alunosCadastrados.size(); posicao++) {
            System.out.println(alunosCadastrados.get(posicao));
        }
    }

    public void listarLivros() {
        for (int posicao = 0; posicao < livrosCadastrados.size(); posicao++) {
            System.out.println(livrosCadastrados.get(posicao));
        }
    }

    public String buscarAluno(String nomeProcurado) {
        for (int posicao = 0; posicao < alunosCadastrados.size(); posicao++) {
            if (nomeProcurado.equals(alunosCadastrados.get(posicao).getNome())) {
                return "Aluno encontrado: " + nomeProcurado;
            }
        }

        return "Aluno não cadastrado";
    }

    public String buscarLivro(String tituloProcurado) {
        for (int posicao = 0; posicao < livrosCadastrados.size(); posicao++) {
            if (tituloProcurado.equals(livrosCadastrados.get(posicao).getTituloLivro())) {
                return "Livro encontrado: " + tituloProcurado;
            }
        }

        return "Livro não cadastrado";
    }

    public String emprestarLivro(String tituloProcurado) {
        for (int posicao = 0; posicao < livrosCadastrados.size(); posicao++) {

            Livro livro = livrosCadastrados.get(posicao);

            if (tituloProcurado.equals(livro.getTituloLivro())) {

                if (livro.getSituacaoLivro()) {
                    livro.emprestar();
                    return "Livro emprestado: " + tituloProcurado;
                }
            }
        }

        return "Livro não disponível";
    }

    public String devolverLivro(String tituloProcurado) {
        for (int posicao = 0; posicao < livrosCadastrados.size(); posicao++) {

            Livro livro = livrosCadastrados.get(posicao);

            if (tituloProcurado.equals(livro.getTituloLivro())) {

                if (!livro.getSituacaoLivro()) {
                    livro.devolver();
                    return "Livro devolvido: " + tituloProcurado;
                }
            }
        }

        return "Livro já disponível ou não cadastrado";
    }

    public ArrayList<Aluno> getAlunosCadastrados() {
        return alunosCadastrados;
    }

    public ArrayList<Livro> getLivrosCadastrados() {
        return livrosCadastrados;
    }
}