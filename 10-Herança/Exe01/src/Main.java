import entities.ContaPF;
import entities.ContaPJ;
import entities.ContaUni;

public class Main {
    public static void main(String[] args) {

        ContaPF contaPF = new ContaPF(1, 2255, 25410, "João Batista", 0.0, 200.0, "122.254.521-54");
        contaPF.depositar(550.0);
        System.out.println("Saldo da Conta PF: " + contaPF.getSaldo());
        contaPF.sacar(356.41);
        System.out.println("Saldo da Conta PF depois do saque: " + contaPF.getSaldo());
        //System.out.println(contaPF);

        ContaPJ contaPJ = new ContaPJ(2, 4125, 25999, "Lojas Macedo", 0.0, 1000.0, "22.124.325/0001-55");
        contaPJ.depositar(1250.0);
        System.out.println("Saldo da Conta PJ: " + contaPJ.getSaldo());
        contaPJ.sacar(965.25);
        System.out.println("Saldo da Conta PJ depois do saque: " + contaPJ.getSaldo());
        //System.out.println(contaPJ);

        ContaUni contaUni = new ContaUni(3, 2554, 54110, "Marilia Santos", 0.0, 450.0, "22563");
        contaUni.depositar(230.0);
        System.out.println("Saldo da Conta Uni: " + contaUni.getSaldo());
        contaUni.sacar(123.58);
        System.out.println("Saldo da Conta Uni depois do saque: " + contaUni.getSaldo());
        //System.out.println(contaUni);

    }

}