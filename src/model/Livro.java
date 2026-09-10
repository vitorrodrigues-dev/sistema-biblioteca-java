package model;

public class Livro {

    private String tituloLivro;
    private String autor;
    private String genero;
    private boolean situacaoLivro = true;

    public void emprestar() {
        if (situacaoLivro == true) {
            situacaoLivro = false;
        } else {
            System.out.println("Livro indisponivel");
        }
    }

    public void devolver() {
        if (situacaoLivro == false) {
            situacaoLivro = true;
        } else {
            System.out.println("Livro não está emprestado");
        }
    }

    public Livro(String tituloLivro, String autor, String genero) {
        this.tituloLivro = tituloLivro;
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Título: " + getTituloLivro()
                + " | Autor: " + getAutor()
                + " | Gênero: " + getGenero()
                + " | Disponível: " + getSituacaoLivro();
    }

    public boolean getSituacaoLivro() {
        return situacaoLivro;

    }

    public String getGenero() {
        return genero;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public String getAutor() {
        return autor;
    }



}
