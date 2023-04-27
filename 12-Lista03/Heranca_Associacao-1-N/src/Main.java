import entities.Endereco;
import entities.Funcionario;
import entities.subclasses.Marketing;
import entities.subclasses.Producao;
import entities.subclasses.RecursosHumanos;

public class Main {
    public static void main(String[] args) {

        Endereco e1 = new Endereco(1, "Rua Montenegro", "254");
        Endereco e2 = new Endereco(2, "Rua Aparício Borges", "2520");
        Endereco e3 = new Endereco(3, "Av. Bento Gonçalves", "1528");

        Funcionario f1 = new Funcionario(1, "Marta", "Moraes", "311.223.662-77", e1);
        Funcionario f2 = new Funcionario(2, "Leandro", "Pacheco", "211.254.527-63", e2);
        Funcionario f3 = new Funcionario(3, "Lilian", "Silveira", "140.210.887-93", e3);
        Funcionario f4 = new Funcionario(4, "Eva", "Santos", "211.456.677-34", e3);
        Funcionario f5 = new Funcionario(5, "Vania", "Albuquerque", "211.212.172-22", e1);

        f1.trabalhar();

        Marketing mk1 = new Marketing(6, "Elias", "Pontes", "214.111.547-99", e3, "Vendas");

        Producao prod1 = new Producao(7, "Monique", "Alves", "441.145.878-66", e1, "5 anos");

        RecursosHumanos rh1 = new RecursosHumanos(8, "Pedro", "Buarque", "225.365.569-88", e3, 6);

        System.out.println(mk1);
        mk1.trabalhar();

        System.out.println(prod1);
        prod1.trabalhar();

        System.out.println(rh1);
        rh1.trabalhar();

//        System.out.println("E1: " + e1);
//        System.out.println("E2: " + e2);
//        System.out.println("E3: " + e3);
//
//        System.out.println("F1: " + f1);
//        System.out.println("F2: " + f2);
//        System.out.println("F3: " + f3);
//        System.out.println("F4: " + f4);
//        System.out.println("F5: " + f5);
    }
}