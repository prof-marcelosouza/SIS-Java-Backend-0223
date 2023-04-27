package org.example.entities.fretes;

import org.example.entities.Frete;

public class FretePJ implements Frete {

    @Override
    public double calcular(double valor) {
        return valor * 0.06; // 6%
    }

}
