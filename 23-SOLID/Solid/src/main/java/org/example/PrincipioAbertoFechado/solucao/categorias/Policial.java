package org.example.PrincipioAbertoFechado.solucao.categorias;

import org.example.PrincipioAbertoFechado.solucao.Video;

public class Policial extends Video {

    @Override
    public String escolhaDeMidia(String tipo) {
        return "Policial";
    }
}
