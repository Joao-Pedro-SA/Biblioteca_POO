package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {

    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao; // NOVO

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
    }

    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }

    public void registrarDevolucao() {
        this.dataDevolucao = LocalDate.now();
    }

    public boolean estaAtivo() {
        return dataDevolucao == null;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "--- RECIBO DE EMPRÉSTIMO ---\n" +
                "Usuario: " + usuario.getNome() + "\n" +
                "Livro: " + livro.getTitulo() + "\n" +
                "Data de empréstimo: " + dataEmprestimo.format(formato) + "\n" +
                "Data de devolução: " +
                (dataDevolucao == null ? "PENDENTE" : dataDevolucao.format(formato)) +
                "\n";
    }
}