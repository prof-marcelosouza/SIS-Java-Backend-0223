package org.example.principioDeInversaoDeDependencia.solucao;

public class Filme {

    private Long id;
    private String nome;
    // Interface como relação
    private CategoriaSolucao categoriaSolucao;

    public Filme(Long id, String nome, CategoriaSolucao categoriaSolucao) {
        this.id = id;
        this.nome = nome;
        this.categoriaSolucao = categoriaSolucao;
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

    public CategoriaSolucao getCategoriaSolucao() {
        return categoriaSolucao;
    }

    public void setCategoriaSolucao(CategoriaSolucao categoriaSolucao) {
        this.categoriaSolucao = categoriaSolucao;
    }
}
