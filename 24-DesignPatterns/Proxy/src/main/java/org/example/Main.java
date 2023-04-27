package org.example;

import org.example.entities.Pessoa;
import org.example.services.ServicoVacinar;
import org.example.services.ServicoVacinarProxy;
import org.example.services.Vacinar;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate diaDaVacinaAnterior = LocalDate.now().minusDays(10);
        System.out.println("Dia da vacinação errado: " + diaDaVacinaAnterior);

        Pessoa p1 = new Pessoa(1L, "Paola", "Marques", "4555221102", diaDaVacinaAnterior, "Comirnaty (Pfizer/Wyeth)");

        Vacinar vacinar = new ServicoVacinarProxy();
        vacinar.vacinarPessoa(p1.getRg(), p1.getDataVacina(), p1.getNomeDaVacina());
        System.out.println(p1);

        System.out.println("-------------------------------------------------------------");

        LocalDate diaVacina = LocalDate.now();
        System.out.println("O dia da vacinação é hoje: " + diaVacina);

        Pessoa p2 = new Pessoa(2L, "Jonas", "Santos", "4122556698", diaVacina, "Coronavac (Butantan)");

        Vacinar vacinar2 = new ServicoVacinarProxy();
        vacinar2.vacinarPessoa(p2.getRg(), p2.getDataVacina(), p2.getNomeDaVacina());
        System.out.println(p2);

    }
}