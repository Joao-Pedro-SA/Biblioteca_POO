package model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel;
    
    public Livro(String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }
    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String toString() {
        return "Livro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "', disponivel=" + disponivel + "}";
    }
}
