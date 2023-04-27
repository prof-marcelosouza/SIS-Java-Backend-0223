package entities.subclasses;

import entities.Endereco;
import entities.Funcionario;

public class Producao extends Funcionario {

    private String tempoExperiencia;

    public Producao(int id, String nome, String sobrenome, String cpf, Endereco endereco, String tempoExperiencia) {
        super(id, nome, sobrenome, cpf, endereco);
        this.tempoExperiencia = tempoExperiencia;
    }

    public String getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(String tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public void trabalhar() {
        System.out.println("Funcionário(a) do(a) Produção trabalhando...");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Producao{" +
                "tempoExperiencia='" + tempoExperiencia + '\'' +
                '}';
    }
}
