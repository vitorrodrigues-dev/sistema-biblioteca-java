# Sistema de Biblioteca (Java, terminal)

Aplicação de linha de comando para cadastro de alunos e livros, com empréstimo e devolução.

Escrevi o projeto para praticar os fundamentos de POO em Java fora do contexto de exercício isolado: modelar um domínio pequeno, distribuir responsabilidades entre classes e fazer isso rodar de ponta a ponta.

**Os dados ficam em memória.** Ao encerrar a execução, tudo é perdido. Persistência em banco relacional é o próximo passo.

## O que o sistema faz

- Cadastro de alunos e de livros
- Listagem de alunos e de livros cadastrados
- Busca de aluno por nome e de livro por título
- Empréstimo e devolução, com controle de disponibilidade do exemplar
- Validação básica das entradas digitadas no menu

## Organização do código

```text
src/
├── model/
│   ├── Pessoa.java
│   ├── Aluno.java
│   ├── Livro.java
│   └── Biblioteca.java
│
└── view/
    └── Main.java
```

- **`Pessoa`** — classe abstrata com os dados comuns a quem usa a biblioteca. Existe para que outros tipos de usuário (professor, funcionário) possam ser adicionados sem duplicar código.
- **`Aluno`** — herda de `Pessoa`.
- **`Livro`** — dados do exemplar e o próprio estado de disponibilidade. Quem decide se um livro pode ser emprestado é o livro, não o menu.
- **`Biblioteca`** — concentra as operações sobre as listas: cadastrar, buscar, emprestar, devolver.
- **`Main`** — menu, leitura do terminal e exibição das mensagens.

Não é MVC: não existe camada de controller. A separação é entre model (entidades e regras) e view (interação com o usuário), com `Main` acumulando também a coordenação das chamadas.

## Limitações conhecidas

- Sem persistência — os dados existem apenas durante a execução
- Sem testes automatizados
- Model ainda acoplado ao terminal: os métodos de listagem imprimem direto no console e as buscas devolvem mensagem já formatada em vez do objeto encontrado
- Empréstimo não distingue "livro não cadastrado" de "livro já emprestado" — os dois casos retornam a mesma mensagem
- Um empréstimo por exemplar, sem histórico, data de devolução ou controle de atraso
- Busca por correspondência exata, sem tratamento de acentuação ou busca parcial

## Como executar

Pré-requisitos: Java JDK instalado.

```bash
git clone https://github.com/vitorrodrigues-dev/sistema-biblioteca-java.git
cd sistema-biblioteca-java
```

Abra o projeto na IDE e execute `src/view/Main.java`.

## Tecnologias

Java · Collections (`ArrayList`) · tratamento de exceções · Git

## Autor

Vitor Rodrigues — estudante de Análise e Desenvolvimento de Sistemas, com foco em back-end.

[github.com/vitorrodrigues-dev](https://github.com/vitorrodrigues-dev)
