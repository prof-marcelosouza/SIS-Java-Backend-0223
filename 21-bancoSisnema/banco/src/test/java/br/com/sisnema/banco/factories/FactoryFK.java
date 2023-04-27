package br.com.sisnema.banco.factories;

import br.com.sisnema.banco.dtos.ContaDto;
import br.com.sisnema.banco.entities.Conta;

import static br.com.sisnema.banco.factories.Factory.*;

public class FactoryFK {

    public static Conta criarConta() {
        Conta conta = new Conta(6L, 1, "5541-5", "10445", 250.0, 635.25, criarTipoConta(), criarCliente());
        return conta;
    }

    public static ContaDto criarContaDto() {
        Conta conta = criarConta();
        return new ContaDto(conta);
    }

}
