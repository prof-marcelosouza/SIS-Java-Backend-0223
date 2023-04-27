package br.com.sisnema.banco.dtos;

import br.com.sisnema.banco.entities.TipoConta;
import br.com.sisnema.banco.repositories.TipoContaRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TipoContaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String tipo;

    private List<ContaDto> contaDtoList = new ArrayList<>();

    public TipoContaDto() {
    }

    public TipoContaDto(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoContaDto(TipoConta entidade) {
        this.id = entidade.getId();
        this.tipo = entidade.getTipo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ContaDto> getContaDtoList() {
        return contaDtoList;
    }
}