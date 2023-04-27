package org.example.services;

import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDate;

public class ServicoVacinar implements Vacinar {

    @Override
    public void vacinarPessoa(String rg, LocalDate dataVacina, String nomeDaVacina) {
        System.out.println("Usuário(a) " + rg + " vacinado(a) em " + dataVacina + " com sucesso.");
        System.out.println("Vacina aplicada: "+nomeDaVacina);
    }
}
