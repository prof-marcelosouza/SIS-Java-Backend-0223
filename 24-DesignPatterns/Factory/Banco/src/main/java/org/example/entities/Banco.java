package org.example.entities;

import org.example.entities.types.Boleto10d;
import org.example.entities.types.Boleto30d;
import org.example.entities.types.Boleto60d;

public class Banco {

    public Boleto gerarBoleto(int venc, double valor) throws Exception{

        Boleto boleto = null;

        switch (venc) { // 10, 20 ou 60
            case 10:
                boleto = new Boleto10d(valor);
                break;
            case 30:
                boleto = new Boleto30d(valor);
                break;
            case 60:
                boleto = new Boleto60d(valor);
                break;
            default:
                throw new Exception("Vencimento inválido. Tente outra vez!");
        }

        System.out.println("Valor do boleto gerado: " + valor);
        System.out.println("Valor do juro: " + boleto.calcularJuro());
        System.out.println("Valor do desconto: " + boleto.calcularDesconto());
        System.out.println("Valor do multa: " + boleto.calcularMulta());

        return boleto;
    }

}
