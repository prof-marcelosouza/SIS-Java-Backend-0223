package br.com.sisnema.banco.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErroDeValidacao extends ErroPadrao {
    private static final long serialVersionUID = 1L;

    // Uma lista para concatenar as mensagens de erro;
    private List<MensagemPorCampo> erros = new ArrayList<>();

    public List<MensagemPorCampo> getErros() {
        return erros;
    }

    public void addErro(String nomeDoCampo, String mensagem) {
        erros.add(new MensagemPorCampo(nomeDoCampo, mensagem));
    }
}
