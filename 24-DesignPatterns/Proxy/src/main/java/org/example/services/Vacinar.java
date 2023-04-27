package org.example.services;

import java.time.LocalDate;

public interface Vacinar {

    void vacinarPessoa(String rg, LocalDate dataVacina, String nomeDaVacina);

}
