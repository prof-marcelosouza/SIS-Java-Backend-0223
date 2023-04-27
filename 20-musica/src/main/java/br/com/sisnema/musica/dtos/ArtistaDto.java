package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Album;
import br.com.sisnema.musica.entities.Artista;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private boolean banda;
    private Long pais_id;
    private List<AlbumDto> albumDtoList = new ArrayList<>();

    public ArtistaDto() {
    }

    public ArtistaDto(Long id, String nome, boolean banda, Long pais_id) {
        this.id = id;
        this.nome = nome;
        this.banda = banda;
        this.pais_id = pais_id;
    }

    public ArtistaDto(Artista entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.banda = entidade.isBanda();
        this.pais_id = entidade.getPais().getId();
    }

    public ArtistaDto(Artista entidade, List<Album> albunsRec) {
        this(entidade); // Este this chama a linha 29
        albunsRec.forEach(alb -> this.albumDtoList.add(new AlbumDto(alb))); // 0 1 2 ...
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

    public boolean isBanda() {
        return banda;
    }

    public void setBanda(boolean banda) {
        this.banda = banda;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public void setPais_id(Long pais_id) {
        this.pais_id = pais_id;
    }

    public List<AlbumDto> getAlbumDtoList() {
        return albumDtoList;
    }
}
