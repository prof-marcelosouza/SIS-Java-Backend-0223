package entities;

import java.time.Instant;

public class Produto {

    // Declaração dos atributos (substantivos)
    // O Encapsulamento é necessário para a segurança do sistema
    private int id;
    private String nome;
    private String desc;
    private double valor;
    private int estoque;
    private Instant dataCadastro;

    // Contrutores
    // Quando não se cria mais de um construtor o construtor padrão está implícito.
    public Produto() {
    }

    public Produto(int id, String nome, String desc, double valor, int estoque, Instant dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.valor = valor;
        this.estoque = estoque;
        this.dataCadastro = dataCadastro;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    //

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desc='" + desc + '\'' +
                ", valor=" + valor +
                ", estoque=" + estoque +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
