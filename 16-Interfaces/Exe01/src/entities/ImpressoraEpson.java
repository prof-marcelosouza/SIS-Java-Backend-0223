package entities;

import Interfaces.IJatoDeTinta;
import Interfaces.ILaser;
import Interfaces.IMatricial;

import java.time.LocalDate;

public class ImpressoraEpson extends Impressora implements IJatoDeTinta, ILaser, IMatricial {

    public ImpressoraEpson(long id, String modelo, String tipoconexao, LocalDate dataFabricacao, int folhasDisponiveis) {
        super(id, modelo, tipoconexao, dataFabricacao, folhasDisponiveis);
    }

    @Override
    public void imprimirJatoDeTinta() {
        System.out.println("Impressora da EPSON com jato de tinta.");
    }

    @Override
    public void imprimirLaser() {
        System.out.println("Impressora da EPSON com tonner(Laser).");
    }

    @Override
    public void imprimirMatricial() {
        System.out.println("Impressora da EPSON com fita(Matricial).");
    }
}
