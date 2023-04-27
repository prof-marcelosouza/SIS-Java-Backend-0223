package br.com.sisnema.musica.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_musico")
public class Musico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNasc;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_musico_instrumento",
            joinColumns = @JoinColumn(name = "musico_id"),
            inverseJoinColumns = @JoinColumn(name = "instrumento_id"))
    private Set<Instrumento> instrumentos = new HashSet<>();

    public Musico() {
    }

    public Musico(Long id, String nome, String sobrenome, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Set<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musico musico = (Musico) o;
        return Objects.equals(id, musico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Musico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNasc=" + dataNasc +
                ", instrumentos=" + instrumentos +
                '}';
    }
}
