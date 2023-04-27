package org.example.principioDeInversaoDeDependencia.problema;

public class CategoriaFilmeProblema {

    private Long id;
    private String nome;
    private Drama categoria;

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

    // Objeto externo como parâmetro - não indicado
    // Dependência de implementação da classe Drama
    public Drama getCategoria() {
        return new Drama();
    }

    // Objeto externo como parâmetro - não indicado
    // Dependência de implementação da classe Drama
    public void setCategoria(Drama categoria) {
        this.categoria = categoria;
    }

}
