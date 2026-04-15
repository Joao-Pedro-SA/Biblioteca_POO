package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

    private String nome;
    private LocalDate dataNasc;
    private int id;
    protected List<Livro> livros = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public abstract boolean podePegarLivro();


    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void devolverLivro(Livro livro) {
        if (livros.contains(livro)) {
            livros.remove(livro);
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nData de nascimento: " + dataNasc;
    }
}