package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Musico;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MusicoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private String sobrenome;
    @NotNull(message = "Campo obrigatório")
    private LocalDate dataNasc;

    private Set<InstrumentoDto> instrumentoDtos = new HashSet<>();

    public MusicoDto() {
    }

    public MusicoDto(Long id, String nome, String sobrenome, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
    }

    public MusicoDto(Musico entidade) {
        id = entidade.getId();
        nome = entidade.getNome();
        sobrenome = entidade.getSobrenome();
        dataNasc = entidade.getDataNasc();
        entidade.getInstrumentos().forEach(x -> this.instrumentoDtos.add(new InstrumentoDto(x)));
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Set<InstrumentoDto> getInstrumentoDtos() {
        return instrumentoDtos;
    }
}
