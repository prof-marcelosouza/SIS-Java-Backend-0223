package br.com.sisnema.banco.dtos;

import br.com.sisnema.banco.entities.Endereco;

import java.io.Serializable;

public class EnderecoDto implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    public EnderecoDto() {
    }

    public EnderecoDto(Long id, String logradouro, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoDto(Endereco entidade) {
        this.id = entidade.getId();
        this.logradouro = entidade.getLogradouro();
        this.numero = entidade.getNumero();
        this.complemento = entidade.getComplemento();
        this.bairro = entidade.getBairro();
        this.cep = entidade.getCep();
        this.cidade = entidade.getCidade();
        this.estado = entidade.getEstado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
