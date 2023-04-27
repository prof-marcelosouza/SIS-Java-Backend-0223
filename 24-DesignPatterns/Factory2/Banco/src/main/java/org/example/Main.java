package org.example;

import org.example.entities.Banco;
import org.example.entities.BoletoSimpleFactory;

public class Main {
    public static void main(String[] args) throws Exception {

        BoletoSimpleFactory boletoSimpleFactory = new BoletoSimpleFactory();

        Banco banco = new Banco(boletoSimpleFactory);
        banco.gerarBoleto(10, 1000.0);
        banco.gerarBoleto(30, 1000.0);
        banco.gerarBoleto(60, 1000.0);
        banco.gerarBoleto(90, 1000.0);
    }

}