package entities;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Impressora {

    private long id;
    private String modelo;
    private String tipoconexao;
    private LocalDate dataFabricacao;
    private int folhasDisponiveis;

    public Impressora() {
    }

    public Impressora(long id, String modelo, String tipoconexao, LocalDate dataFabricacao, int folhasDisponiveis) {
        this.id = id;
        this.modelo = modelo;
        this.tipoconexao = tipoconexao;
        this.dataFabricacao = dataFabricacao;
        this.folhasDisponiveis = folhasDisponiveis;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoconexao() {
        return tipoconexao;
    }

    public void setTipoconexao(String tipoconexao) {
        this.tipoconexao = tipoconexao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public int getFolhasDisponiveis() {
        return folhasDisponiveis;
    }

    public void setFolhasDisponiveis(int folhasDisponiveis) {
        this.folhasDisponiveis = folhasDisponiveis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Impressora that = (Impressora) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Impressora{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", tipoconexao='" + tipoconexao + '\'' +
                ", dataFabricacao=" + dataFabricacao +
                ", folhasDisponiveis=" + folhasDisponiveis +
                '}';
    }
}
