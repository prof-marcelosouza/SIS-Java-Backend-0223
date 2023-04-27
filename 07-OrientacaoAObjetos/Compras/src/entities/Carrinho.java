package entities;

import java.util.Objects;

public class Carrinho {

    // Atributos
    private int id;
    private String item;
    private int quantidade;
    private double valor;
    private boolean promocao;

    // Construtores
    public Carrinho() {
    }

    public Carrinho(int id, String item, int quantidade, double valor, boolean promocao) {
        this.id = id;
        this.item = item;
        this.quantidade = quantidade;
        this.valor = valor;
        this.promocao = promocao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    // Métodos customizados
    // Sem parâmetros
    public double calcularTotalItem() {
        double totalItem = getQuantidade() * getValor();
        return totalItem;
    }

    // Com parâmetros
    public double alterarValorItem(double novoValor) {
        setValor(novoValor);
        return getValor();
    }

    // Equals e hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return id == carrinho.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", promocao=" + promocao +
                '}';
    }
}
