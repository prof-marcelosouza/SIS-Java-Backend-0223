package org.example.entities.types;

import org.example.entities.Boleto;

public class Boleto30d extends Boleto {

    public Boleto30d(double valor) {
        super(valor);
        juro = 0.05;
        desconto = 0.05;
        multa = 0.1;
    }

}
