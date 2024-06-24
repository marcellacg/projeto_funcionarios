package entities;

import java.lang.String;
import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimentoPessoa;


    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate data_nascimento) {
        this.nome = nome;
        this.dataNascimentoPessoa = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascimento() {
        return dataNascimentoPessoa;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.dataNascimentoPessoa = data_nascimento;
    }


    @Override
    public String toString() {
        return nome + " " + dataNascimentoPessoa;
    }
}
