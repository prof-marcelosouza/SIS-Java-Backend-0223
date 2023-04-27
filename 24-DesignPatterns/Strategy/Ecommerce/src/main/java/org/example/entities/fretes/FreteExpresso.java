package org.example.entities.fretes;

import org.example.entities.Frete;

public class FreteExpresso implements Frete {

    @Override
    public double calcular(double valor) {
        return valor * 0.1; // 10%
    }

}
