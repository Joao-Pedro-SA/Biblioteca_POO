package model;

import java.time.LocalDate;

public class Aluno extends Usuario{



    @Override
    public boolean podePegarLivro() {
        return  livros.size() < 3;
    }
}
