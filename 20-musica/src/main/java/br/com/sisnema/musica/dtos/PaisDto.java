package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Artista;
import br.com.sisnema.musica.entities.Pais;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaisDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull(message = "Campo obrigatório")
    private String nome;
    private List<ArtistaDto> artistaDtoList = new ArrayList<>();

    public PaisDto() {
    }

    public PaisDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PaisDto(Pais entidade) {
        id = entidade.getId();
        nome = entidade.getNome();
    }

    public PaisDto(Pais entidade, List<Artista> artistasRec) {
        this(entidade);
        artistasRec.forEach(art -> this.artistaDtoList.add(new ArtistaDto(art)));
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

    public List<ArtistaDto> getArtistaDtoList() {
        return artistaDtoList;
    }
}
