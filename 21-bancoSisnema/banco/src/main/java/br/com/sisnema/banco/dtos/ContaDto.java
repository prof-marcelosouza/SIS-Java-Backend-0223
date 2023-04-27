package br.com.sisnema.banco.dtos;

import br.com.sisnema.banco.entities.Conta;

public class ContaDto {

    private Long id;
    private Integer banco;
    private String agencia;
    private String numero;
    private Double limite;
    private Double saldo;
    private Long tipo_conta_id;
    private Long cliente_id;

    public ContaDto() {
    }

    public ContaDto(Long id, Integer banco, String agencia, String numero, Double limite, Double saldo, Long tipo_conta_id, Long cliente_id) {
        this.id = id;
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.limite = limite;
        this.saldo = saldo;
        this.tipo_conta_id = tipo_conta_id;
        this.cliente_id = cliente_id;
    }

    public ContaDto(Conta entidade) {
        this.id = entidade.getId();
        this.banco = entidade.getBanco();
        this.agencia = entidade.getAgencia();
        this.numero = entidade.getNumero();
        this.limite = entidade.getLimite();
        this.saldo = entidade.getSaldo();
        this.tipo_conta_id = entidade.getTipoConta().getId();
        this.cliente_id = entidade.getCliente().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBanco() {
        return banco;
    }

    public void setBanco(Integer banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getTipo_conta_id() {
        return tipo_conta_id;
    }

    public void setTipo_conta_id(Long tipo_conta_id) {
        this.tipo_conta_id = tipo_conta_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }
}
