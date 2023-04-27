package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Instrumento;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class InstrumentoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull(message = "Campo obrigatório")
    private String nome;
    private String obs;

    public InstrumentoDto() {
    }

    public InstrumentoDto(Long id, String nome, String obs) {
        this.id = id;
        this.nome = nome;
        this.obs = obs;
    }

    public InstrumentoDto(Instrumento entidade) {
        id = entidade.getId();
        nome = entidade.getNome();
        obs = entidade.getObs();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
