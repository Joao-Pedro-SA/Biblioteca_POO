package model;

import java.time.LocalDate;
import java.util.Date;

public class Professor extends Usuario{

    @Override
    public void cadastrar(String nome, LocalDate dataNasc, int id) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.id = id;

    }
}
