package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

    private int id;
    private String nomeCompleto;
    private String rg;
    private String cpf;
    private LocalDate dataNasc;
    private String tipoSang;
    private String email;
    private String telFixo;
    private String telCel;

    public Pessoa() {
    }

    public Pessoa(int id, String nomeCompleto, String rg, String cpf, LocalDate dataNasc, String tipoSang, String email, String telFixo, String telCel) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.tipoSang = tipoSang;
        this.email = email;
        this.telFixo = telFixo;
        this.telCel = telCel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTipoSang() {
        return tipoSang;
    }

    public void setTipoSang(String tipoSang) {
        this.tipoSang = tipoSang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id == pessoa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoa {" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNasc=" + dataNasc +
                ", tipoSang='" + tipoSang + '\'' +
                ", email='" + email + '\'' +
                ", telFixo='" + telFixo + '\'' +
                ", telCel='" + telCel + '\'' +
                '}';
    }
}