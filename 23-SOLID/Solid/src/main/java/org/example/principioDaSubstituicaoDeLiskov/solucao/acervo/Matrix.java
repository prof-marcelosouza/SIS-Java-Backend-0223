package org.example.principioDaSubstituicaoDeLiskov.solucao.acervo;


import org.example.principioDaSubstituicaoDeLiskov.solucao.ControleVolume;
import org.example.principioDaSubstituicaoDeLiskov.solucao.FilmeSolucao;

public class Matrix extends FilmeSolucao implements ControleVolume {
    @Override
    public void aumentarVolume() {
    }

    @Override
    public void diminuirVolume() {
    }
}
