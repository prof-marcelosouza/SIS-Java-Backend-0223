package org.example.entities;

public class Conta {

    public static Double TAXADEDEPOSITO = 0.02;
    public static Double TAXADESAQUE = 0.06;

    private Long id;
    private Double saldo;

    public Conta(Long id, Double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            valor = valor - (valor * TAXADEDEPOSITO); // 100.0 - 100.0 * 0.02
            this.saldo = this.saldo + valor; // 98.00
        }
    }

    public void sacar(Double valor) {
        if (valor <= this.saldo - (valor * TAXADESAQUE)) {
            valor = valor + (valor * TAXADESAQUE);
            this.saldo = this.saldo - valor;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Double sacarTodoSaldo() {
        double aux = this.saldo; // 200.00
        this.saldo = 0.0;
        return aux;
    }

}
