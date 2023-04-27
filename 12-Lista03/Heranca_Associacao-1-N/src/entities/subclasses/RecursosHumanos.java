package entities.subclasses;

import entities.Endereco;
import entities.Funcionario;

public class RecursosHumanos extends Funcionario {

    private int metaAlcancada;

    public RecursosHumanos(int id, String nome, String sobrenome, String cpf, Endereco endereco, int metaAlcancada) {
        super(id, nome, sobrenome, cpf, endereco);
        this.metaAlcancada = metaAlcancada;
    }

    public int getMetaAlcancada() {
        return metaAlcancada;
    }

    public void setMetaAlcancada(int metaAlcancada) {
        this.metaAlcancada = metaAlcancada;
    }

    public void trabalhar() {
        System.out.println("Funcionário(a) do(a) Recursos Humanos trabalhando...");
    }

    @Override
    public String toString() {
        return super.toString() +
                "RecursosHumanos{" +
                "metaAlcancada=" + metaAlcancada +
                '}';
    }
}
