package entities;

import exceptions.ClienteException;

public class Cliente {

    private int id;
    private String nome;
    private String sobrenome;
    private String rg;
    private double saldo;
    private double limite;
    private double divida;

    public Cliente() {
    }

    public Cliente(int id, String nome, String sobrenome, String rg, double saldo, double limite, double divida) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.saldo = saldo;
        this.limite = limite;
        this.divida = divida;
    }

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }

    // Métodos customizados
    public void depositar(double valor) throws ClienteException {
        if (valor <= 0) {
            throw new ClienteException("Valor inválido para depósito...");
        } else {
            saldo = saldo + valor;
        }
    }

    public void sacar(double valor) throws ClienteException {
        if (valor <= (saldo + limite)) {
            saldo = saldo - valor;
        } else {
            throw new ClienteException("Valor inválido para saque...");
        }

    }

    // Valor máximo de emprétimo: R$ 5000,00
    public void emprestimo(double valor) {
        divida = divida + valor;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", rg='" + rg + '\'' +
                ", saldo=" + saldo +
                ", limite=" + limite +
                ", divida=" + divida +
                '}';
    }

} // Fecha a Classe Cliente
