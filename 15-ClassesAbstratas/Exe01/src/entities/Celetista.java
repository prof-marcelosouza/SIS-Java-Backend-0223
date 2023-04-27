package entities;

public class Celetista extends Professor {

    private double ppl = 0.08; // 8%

    public Celetista(int id, String nome, String email) {
        super(id, nome, email);
    }

    @Override // Sobrescrita de método = annotation
    public double calcularSalario(double base, double percDesc) {
        double salario = (base + (base * ppl)) - (base * percDesc / 100);
        return salario;
    }

}
