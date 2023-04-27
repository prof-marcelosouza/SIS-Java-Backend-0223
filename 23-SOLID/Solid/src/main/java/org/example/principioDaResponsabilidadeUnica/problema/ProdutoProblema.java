package org.example.principioDaResponsabilidadeUnica.problema;

import java.sql.Connection;

public class ProdutoProblema {

    private Long id;
    private String produto;
    private String descricao;
    private String categoria;
    private Double preco;

    public ProdutoProblema() {
    }

    // Chamar uma conexão com o H2
    public Connection conexao() {
        // Parâmetros de conexão
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double calcularDesconto(double percentual) {
        double desconto = this.preco - (this.preco * percentual / 100);
        return desconto;
    }
}
