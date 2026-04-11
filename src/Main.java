import model.Aluno;
import model.Professor;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int request;

        System.out.println("""
                
                Olá! Seja bem vindo,o que deseja fazer?
                
                1- Cadastrar livro
                2- Cadastrar Usuário
                3- Emprestar Livro
                4-Devolver Livro
                5- Listar Livros Disponiveis
                6- Listar Empréstimos
                0- sair
                """);
        request = scanner.nextInt();

        switch (request){
            case 1: break;

            case 2:
                System.out.println("Deseja cadastrar Aluno ou Professor? Digite 1 para aluno e 2 para professor");
                int resposta = scanner.nextInt();

                scanner.nextLine();

                if (resposta == 1){
                    Aluno aluno = new Aluno();

                    System.out.println("Informe o nome do aluno");
                    String nome = scanner.nextLine();

                    System.out.println("Informe a data de nascimento do aluno (yyyy-mm-dd)");
                    LocalDate data = LocalDate.parse(scanner.next());

                    int id = 1;

                    aluno.cadastrar(nome, data, id);
                    System.out.println("Aluno: " +aluno.getNome()+ " criado com sucesso");

                } else if (resposta == 2) {
                    Professor professor = new Professor();

                    System.out.println("Informe o nome do Professor");
                    String nome = scanner.nextLine();

                    System.out.println("Informe a data de nascimento do professor (yyyy-mm-dd)");
                    LocalDate data = LocalDate.parse(scanner.next());

                    int id = 1;

                    professor.cadastrar(nome, data, id);
                    System.out.println("Professor: " +professor.getNome()+ " criado com sucesso");
                }
                break;
        }

    }
}
