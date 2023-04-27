package org.example;

import org.example.entities.Pedido;
import org.example.entities.PedidoEletro;
import org.example.entities.fretes.FreteComum;
import org.example.entities.fretes.FreteExpresso;
import org.example.entities.fretes.FreteGratis;
import org.example.entities.fretes.FretePJ;

public class Main {
    public static void main(String[] args) {

        FreteComum freteComum = new FreteComum();
        FreteExpresso freteExpresso = new FreteExpresso();
        FreteGratis freteGratis = new FreteGratis();
        FretePJ fretePJ = new FretePJ();

        Pedido pe1 = new PedidoEletro(1000.0, "DVD Player");
        System.out.println("Pedido do setor de Eletro:");
        pe1.setTipoFrete(freteComum);
        System.out.println("Frete comum: R$ " + pe1.calcFrete());

        System.out.println("-------------------------------------------");

        Pedido pe2 = new PedidoEletro(1000.0, "DVD Player");
        System.out.println("Pedido do setor de Eletro:");
        pe2.setTipoFrete(freteExpresso);
        System.out.println("Frete expresso: R$ " + pe2.calcFrete());

        System.out.println("-------------------------------------------");

        Pedido pe3 = new PedidoEletro(1000.0, "DVD Player");
        System.out.println("Pedido do setor de Eletro:");
        pe3.setTipoFrete(freteGratis);
        System.out.println("Frete grátis: R$ " + pe3.calcFrete());

        System.out.println("-------------------------------------------");

        Pedido pe4 = new PedidoEletro(1000.0, "DVD Player");
        System.out.println("Pedido do setor de Eletro:");
        pe4.setTipoFrete(fretePJ);
        System.out.println("Frete PJ: R$ " + pe4.calcFrete());

    }
}