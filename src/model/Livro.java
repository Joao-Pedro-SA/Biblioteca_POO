package model;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;
    
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
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

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    public String toString() {
        return "Livro{titulo= '" + titulo + "', autor='" + autor + "', disponivel=" + disponivel + "}";
    }
}
