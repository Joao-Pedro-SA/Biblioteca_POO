package model;
import java.time.LocalDate;
public abstract class Usuario {

    String nome;
    LocalDate dataNasc;
    int id;

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

    public abstract void cadastrar(String nome, LocalDate dataNasc, int id);

}
