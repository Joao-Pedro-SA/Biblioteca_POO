package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    
    
    // 1. ATRIBUTOS 
    
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal; 
    private boolean statusDevolvido;

    
    // 2. CONSTRUTOR
    public Emprestimo(Usuario usuario, Livro livro, int diasParaDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now(); 
        this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(diasParaDevolucao);
        this.statusDevolvido = false; 
        this.dataDevolucaoReal = null; // Começa vazio, pois ainda não foi devolvido
    }


    // 3. MÉTODOS DE AÇÃO (O que o empréstimo faz)
    // Método para devolver o livro
    public void registrarDevolucao() {
        if (!this.statusDevolvido) {
            this.statusDevolvido = true;
            this.dataDevolucaoReal = LocalDate.now(); // Grava o dia exato em que o livro voltou
            System.out.println("Devolução registrada com sucesso!");
        } else {
            System.out.println("Erro: Este livro já foi devolvido anteriormente.");
        }
    }

    // Método para checar se o usuário tomou multa/atrasou
    public boolean estaAtrasado() {
        if (this.statusDevolvido) {
            return false; // Se já devolveu, não está atrasado
        }
        // Retorna VERDADEIRO se a data de hoje já passou da data limite
        return LocalDate.now().isAfter(this.dataDevolucaoPrevista);
    }

    // 4. GETTERS (Para acessar os dados de fora)
    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public LocalDate getDataDevolucaoReal() { return dataDevolucaoReal; }
    public boolean isStatusDevolvido() { return statusDevolvido; }
    
    // 5. TO STRING (Para imprimir o recibo bonito)
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String status = this.statusDevolvido ? "Devolvido" : "Pendente";
        
        return "--- RECIBO DE EMPRÉSTIMO ---\n" +
               "Data do Empréstimo: " + this.dataEmprestimo.format(formato) + "\n" +
               "Devolução Prevista: " + this.dataDevolucaoPrevista.format(formato) + "\n" +
               "Status Atual: " + status;
    }
}