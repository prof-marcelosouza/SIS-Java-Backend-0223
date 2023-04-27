package entities;

import Interfaces.IJatoDeTinta;

import java.time.LocalDate;

public class ImpressoraHP extends Impressora implements IJatoDeTinta {

    public ImpressoraHP(long id, String modelo, String tipoconexao, LocalDate dataFabricacao, int folhasDisponiveis) {
        super(id, modelo, tipoconexao, dataFabricacao, folhasDisponiveis);
    }

    @Override
    public void imprimirJatoDeTinta() {
        System.out.println("Impressora da HP com jato de tinta.");
    }
}
