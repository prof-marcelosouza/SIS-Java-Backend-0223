package entities.subclasses;

import entities.Endereco;
import entities.Funcionario;

public class Marketing extends Funcionario {

    private String area;

    public Marketing(int id, String nome, String sobrenome, String cpf, Endereco endereco, String area) {
        super(id, nome, sobrenome, cpf, endereco);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void trabalhar() {
        System.out.println("Funcionário(a) do(a) Marketing trabalhando...");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Marketing{" +
                "area='" + area + '\'' +
                '}';
    }
}
