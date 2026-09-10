package view;

import model.Aluno;
import model.Biblioteca;
import model.Livro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca bibli = new Biblioteca();

        int opcao = 0;

        while (opcao != 9) {

            System.out.println("\n--- Sistema de Biblioteca ---");
            System.out.println("--- Escolha uma opção ---");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Listar Alunos");
            System.out.println("4 - Listar Livros");
            System.out.println("5 - Buscar Aluno");
            System.out.println("6 - Buscar Livro");
            System.out.println("7 - Emprestar Livro");
            System.out.println("8 - Devolver Livro");
            System.out.println("9 - Sair");
            System.out.print("Digite uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {

                    case 1:

                        String nomeRecebido = "";
                        int idRecebido = 0;
                        boolean entradaValida = false;

                        while (!entradaValida) {

                            System.out.print("Digite o nome do aluno: ");
                            nomeRecebido = sc.nextLine();

                            if (nomeRecebido.trim().isEmpty()) {
                                System.out.println("ERRO! O nome não pode ser vazio.");
                            } else {
                                entradaValida = true;
                            }
                        }

                        entradaValida = false;

                        while (!entradaValida) {

                            try {
                                System.out.print("Digite o ID do aluno: ");
                                idRecebido = sc.nextInt();
                                sc.nextLine();

                                if (idRecebido <= 0) {
                                    System.out.println("ERRO! O ID deve ser maior que zero.");
                                } else {
                                    entradaValida = true;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("ERRO! Digite um ID numérico válido.");
                                sc.nextLine();
                            }
                        }

                        Aluno alunoNovo = new Aluno(nomeRecebido, idRecebido);
                        bibli.cadastrarAlunos(alunoNovo);

                        System.out.println("Aluno cadastrado com sucesso!");

                        break;


                    case 2:

                        String tituloLivro = "";
                        String autorLivro = "";
                        String generoLivro = "";

                        System.out.print("Digite o título do livro: ");
                        tituloLivro = sc.nextLine();

                        while (tituloLivro.trim().isEmpty()) {
                            System.out.println("ERRO! O título não pode ser vazio.");
                            System.out.print("Digite o título do livro: ");
                            tituloLivro = sc.nextLine();
                        }

                        System.out.print("Digite o autor do livro: ");
                        autorLivro = sc.nextLine();

                        while (autorLivro.trim().isEmpty()) {
                            System.out.println("ERRO! O autor não pode ser vazio.");
                            System.out.print("Digite o autor do livro: ");
                            autorLivro = sc.nextLine();
                        }

                        System.out.print("Digite o gênero do livro: ");
                        generoLivro = sc.nextLine();

                        while (generoLivro.trim().isEmpty()) {
                            System.out.println("ERRO! O gênero não pode ser vazio.");
                            System.out.print("Digite o gênero do livro: ");
                            generoLivro = sc.nextLine();
                        }

                        Livro livroNovo = new Livro(
                                tituloLivro,
                                autorLivro,
                                generoLivro
                        );

                        bibli.cadastrarLivros(livroNovo);

                        System.out.println("Livro cadastrado com sucesso!");

                        break;


                    case 3:

                        System.out.println("\n--- Alunos cadastrados ---");
                        bibli.listarAlunos();

                        break;


                    case 4:

                        System.out.println("\n--- Livros cadastrados ---");
                        bibli.listarLivros();

                        break;


                    case 5:

                        System.out.print("Digite o nome do aluno que deseja buscar: ");
                        String alunoProcurado = sc.nextLine();

                        System.out.println(
                                bibli.buscarAluno(alunoProcurado)
                        );

                        break;


                    case 6:

                        System.out.print("Digite o título do livro que deseja buscar: ");
                        String livroProcurado = sc.nextLine();

                        System.out.println(
                                bibli.buscarLivro(livroProcurado)
                        );

                        break;


                    case 7:

                        System.out.print("Digite o título do livro que deseja emprestar: ");
                        String livroParaEmprestar = sc.nextLine();

                        System.out.println(
                                bibli.emprestarLivro(livroParaEmprestar)
                        );

                        break;


                    case 8:

                        System.out.print("Digite o título do livro que deseja devolver: ");
                        String livroParaDevolver = sc.nextLine();

                        System.out.println(
                                bibli.devolverLivro(livroParaDevolver)
                        );

                        break;


                    case 9:

                        System.out.println("Saindo do sistema. Até logo!");

                        break;


                    default:

                        System.out.println(
                                "Opção inválida! Digite um número de 1 a 9."
                        );

                        break;
                }

            } catch (InputMismatchException e) {

                System.out.println("ERRO! Digite apenas números.");
                sc.nextLine();
            }
        }

        sc.close();
    }
}