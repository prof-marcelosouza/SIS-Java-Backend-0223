import entities.Celetista;
import entities.PessoaJuridica;

public class Main {
    public static void main(String[] args) {

        Celetista celetista = new Celetista(1, "Paula", "paulap@gmail.com");
        double salCeletista = celetista.calcularSalario(3000.0, 9.65);
        System.out.println("Salário do professor celetista: " + salCeletista);

        PessoaJuridica pessoaJuridica = new PessoaJuridica(2, "David", "dv@gmail.com");
        double salPJ = pessoaJuridica.calcularSalario(3000.0, 0.0);
        System.out.println("Salário do professor PJ: " + salPJ);
    }

}