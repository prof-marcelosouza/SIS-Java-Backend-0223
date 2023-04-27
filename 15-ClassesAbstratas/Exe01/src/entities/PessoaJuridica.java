package entities;

public class PessoaJuridica extends Professor {

    private double premio = 0.1;

    public PessoaJuridica(int id, String nome, String email) {
        super(id, nome, email);
    }

    @Override
    public double calcularSalario(double base, double percDesc) {
        double salario = (base + (base * premio));
        return salario;
    }
}
