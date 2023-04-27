package org.example.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

    private Long id;
    private String nome;
    private String sobrenome;
    private String rg;
    private LocalDate dataVacina;
    private String nomeDaVacina;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String sobrenome, String rg, LocalDate dataVacina, String nomeDaVacina) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataVacina = dataVacina;
        this.nomeDaVacina = nomeDaVacina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(LocalDate dataVacina) {
        this.dataVacina = dataVacina;
    }

    public String getNomeDaVacina() {
        return nomeDaVacina;
    }

    public void setNomeDaVacina(String nomeDaVacina) {
        this.nomeDaVacina = nomeDaVacina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", rg='" + rg + '\'' +
                ", dataVacina=" + dataVacina +
                ", nomeDaVacina='" + nomeDaVacina + '\'' +
                '}';
    }
}
