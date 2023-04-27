package org.example.entities;

public abstract class Pedido {

    private Double valor;
    private Frete tipoFrete;

    public Pedido() {
    }

    public Pedido(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    // Métodos customizados
    public void setTipoFrete(Frete freteEscolhido) {
        this.tipoFrete = freteEscolhido;
    }

    public double calcFrete() {
        return this.tipoFrete.calcular(this.valor);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "valor=" + valor +
                '}';
    }
}
