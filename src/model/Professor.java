package model;

public class Professor extends Usuario {

    @Override
    public boolean podePegarLivro() {
        return livros.size() < 5;
    }
}