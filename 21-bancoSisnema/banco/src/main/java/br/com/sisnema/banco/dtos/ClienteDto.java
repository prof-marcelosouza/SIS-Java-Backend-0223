package br.com.sisnema.banco.dtos;

import br.com.sisnema.banco.entities.Cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ClienteDto implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNasc;
    private String email;
    private String telefone;
    private Set<EnderecoDto> enderecoDtos = new HashSet<>();

    public ClienteDto() {
    }

    public ClienteDto(Long id, String nome, String sobrenome, LocalDate dataNasc, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
    }

    public ClienteDto(Cliente entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.sobrenome = entidade.getSobrenome();
        this.dataNasc = entidade.getDataNasc();
        this.email = entidade.getEmail();
        this.telefone = entidade.getTelefone();
        entidade.getEnderecos().forEach(x -> this.enderecoDtos.add(new EnderecoDto(x)));
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<EnderecoDto> getEnderecoDtos() {
        return enderecoDtos;
    }
}
