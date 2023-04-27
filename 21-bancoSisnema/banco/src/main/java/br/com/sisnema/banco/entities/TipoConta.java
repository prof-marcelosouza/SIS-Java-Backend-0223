package br.com.sisnema.banco.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_tipo_conta")
public class TipoConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;

    @OneToMany(mappedBy = "tipoConta")
    private List<Conta> contas = new ArrayList<>();

    public TipoConta() {
    }

    public TipoConta(Long id) {
        this.id = id;
    }

    public TipoConta(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoConta tipoConta = (TipoConta) o;
        return Objects.equals(id, tipoConta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TipoConta{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
