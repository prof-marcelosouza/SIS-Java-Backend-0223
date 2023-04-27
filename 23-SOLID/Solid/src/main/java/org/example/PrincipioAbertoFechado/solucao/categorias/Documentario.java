package org.example.PrincipioAbertoFechado.solucao.categorias;

import org.example.PrincipioAbertoFechado.solucao.Video;

public class Documentario extends Video {

    @Override
    public String escolhaDeMidia(String tipo) {
        return "Documentário";
    }
}
