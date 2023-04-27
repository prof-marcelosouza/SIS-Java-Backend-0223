package org.example.services;

import java.time.LocalDate;

public class ServicoVacinarProxy implements Vacinar {

    @Override
    public void vacinarPessoa(String rg, LocalDate dataVacina, String nomeDaVacina) {

        if (LocalDate.now().equals(dataVacina)) {
            // Pode vacinar
            System.out.println("Cidadão(ã) liberado(a) para a vacinação!");
            ServicoVacinar servicoVacinar = new ServicoVacinar();
            servicoVacinar.vacinarPessoa(rg, dataVacina, nomeDaVacina);
        } else {
            System.out.println("A data de hoje é anterior a data marcada.");
        }

    }
}
