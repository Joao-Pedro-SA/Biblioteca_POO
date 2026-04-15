import model.Aluno;
import model.Professor;
import model.Usuario;
import service.Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        List<Usuario> usuarios = new ArrayList<>();

        int request;

        do {
            System.out.println("""
                    
                    Olá! Seja bem vindo, o que deseja fazer?
                    
                    1- Cadastrar livro
                    2- Cadastrar Usuário
                    3- Emprestar Livro
                    4- Devolver Livro
                    5- Listar Livros Disponíveis
                    6- Listar Empréstimos
                    0- Sair
                    """);

            request = scanner.nextInt();
            scanner.nextLine();

            switch (request) {

                case 1:
                    System.out.println("Título do livro:");
                    String titulo = scanner.nextLine();

                    System.out.println("Autor do livro:");
                    String autor = scanner.nextLine();

                    biblioteca.adicionarLivro(titulo, autor);
                    break;

                case 2:
                    System.out.println("1 - Aluno | 2 - Professor");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nome:");
                    String nome = scanner.nextLine();

                    System.out.println("Data de nascimento (yyyy-mm-dd):");
                    LocalDate data = LocalDate.parse(scanner.nextLine());

                    Usuario usuario;

                    if (tipo == 1) {
                        usuario = new Aluno();
                    } else {
                        usuario = new Professor();
                    }

                    usuario.setNome(nome);
                    usuario.setDataNasc(data);
                    usuario.setId(usuarios.size() + 1);

                    usuarios.add(usuario);
                    biblioteca.cadastrarUsuario(usuario);

                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("ID do usuário:");
                    int idEmprestimo = scanner.nextInt();
                    scanner.nextLine();

                    Usuario uEmprestimo = buscarUsuario(usuarios, idEmprestimo);

                    if (uEmprestimo == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.println("Nome do livro:");
                    String nomeLivro = scanner.nextLine();

                    biblioteca.emprestarLivro(uEmprestimo, nomeLivro);
                    break;

                case 4:
                    System.out.println("ID do usuário:");
                    int idDevolucao = scanner.nextInt();
                    scanner.nextLine();

                    Usuario uDevolucao = buscarUsuario(usuarios, idDevolucao);

                    if (uDevolucao == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.println("Nome do livro:");
                    String livroDevolver = scanner.nextLine();

                    biblioteca.devolverLivro(uDevolucao, livroDevolver);
                    break;

                case 5:
                    biblioteca.listarLivros();
                    break;

                case 6:
                    biblioteca.listarEmprestimos();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (request != 0);

        scanner.close();
    }
    public static Usuario buscarUsuario(List<Usuario> usuarios, int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}