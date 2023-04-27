package org.example.entities.fretes;

import org.example.entities.Frete;

public class FreteGratis implements Frete {

    @Override
    public double calcular(double valor) {
        return 0.0;
    }

}
