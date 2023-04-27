import entities.Veiculo;

public class Main {
    public static void main(String[] args) {

        Veiculo v1 = new Veiculo(1, "Renault", "Sandero 1.0 Flex", 2015, "KKT-2254", "Porto Alegre", "RS", "98G12214D54F5EE", "022254411225");

        System.out.println(v1);

        Veiculo v2 = new Veiculo(); // Isto não é null

        v2.setId(2);
        v2.setMarca("Renault");
        v2.setModelo("Logan 1.6");
        v2.setAno(2020);
        v2.setPlaca("JCB5W21");
        v2.setCidade("Santa Maria");
        v2.setEstado("RS");
        v2.setChassi("234R3EW23121");
        v2.setRenavam("215544114475");

        System.out.println(v2);
    }
}