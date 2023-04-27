package org.example.entities;

public class Banco {

    // Para acessar o método criarBoleto
    private BoletoSimpleFactory boletoSimpleFactory;

    // Construtor com argumento
    public Banco(BoletoSimpleFactory boletoSimpleFactory) {
        this.boletoSimpleFactory = boletoSimpleFactory;
    }

    public Boleto gerarBoleto(int vencimento, double valor) throws Exception{

        Boleto boleto = this.boletoSimpleFactory.criarBoleto(vencimento, valor);

        System.out.println("Valor do boleto gerado: " + valor);
        System.out.println("Valor do juro: " + boleto.calcularJuro());
        System.out.println("Valor do desconto: " + boleto.calcularDesconto());
        System.out.println("Valor do multa: " + boleto.calcularMulta());

        return boleto;
    }

}
