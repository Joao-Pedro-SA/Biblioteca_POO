package service;

import model.Livro;
import model.Usuario;
import model.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> listagemLivros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {

        listagemLivros.add(new Livro("Fast Furiosos", "Juca Lopez"));
        listagemLivros.add(new Livro("Diário de um Banana", "Marcelo Falcão"));
        listagemLivros.add(new Livro("Pequeno Príncipe", "Mario Jardim"));
        listagemLivros.add(new Livro("Divisa de Valores", "Fabio Portiola"));
        listagemLivros.add(new Livro("Mais Forte que o Mundo", "Fabio Monte Negro"));
    }

    public void listarLivros() {
        System.out.println("\n===== LIVROS =====");

        for (Livro livro : listagemLivros) {
            System.out.println("Titulo: "+ livro.getTitulo() + "\nAutor: " + livro.getAutor() +
                    " \n|Disponível: " + livro.isDisponivel() + "\n --------------------");
        }
    }

    public void adicionarLivro(String titulo, String autor) {
        Livro novo = new Livro(titulo, autor);
        listagemLivros.add(novo);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public Livro buscarLivro(String nome) {
        for (Livro livro : listagemLivros) {
            if (livro.getTitulo().equalsIgnoreCase(nome)) {
                return livro;
            }
        }
        return null;
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }


    public void emprestarLivro(Usuario usuario, String nomeLivro) {

        Livro livro = buscarLivro(nomeLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println("Livro já está emprestado.");
            return;
        }

        if (!usuario.podePegarLivro()) {
            System.out.println("Usuário atingiu o limite de empréstimos.");
            return;
        }


        Emprestimo emp = new Emprestimo(usuario, livro);

        emprestimos.add(emp);

        usuario.adicionarLivro(livro);

        livro.emprestar();

        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void devolverLivro(Usuario usuario, String nomeLivro) {

        Livro livro = buscarLivro(nomeLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        for (Emprestimo emp : emprestimos) {

            if (emp.getLivro().equals(livro) &&
                    emp.getUsuario().equals(usuario) &&
                    emp.estaAtivo()) {

                emp.registrarDevolucao();
                usuario.devolverLivro(livro);
                livro.devolver();

                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado.");
    }

    public void listarEmprestimos() {
        System.out.println("\n===== EMPRÉSTIMOS =====");

        for (Emprestimo emp : emprestimos) {
            System.out.println(emp);
        }
    }
}