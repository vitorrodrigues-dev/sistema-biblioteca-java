package model;

public class Aluno extends Pessoa {

    public Aluno(String nome, int id) {
        super(nome, id);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | ID: " + getId();
    }
}