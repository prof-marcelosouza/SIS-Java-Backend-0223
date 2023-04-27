import exceptions.ClienteException;
import entities.Cliente;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente(1, "Michele", "Monteiro", "2255413269", 0.0, 1000.0, 0.0);

        try {
            System.out.println("Saldo inicial: R$ " + c1.getSaldo());
            System.out.println("Depositando R$ 500,00...");
            c1.depositar(500.0);
            System.out.println("Saldo atualizado: R$ " + c1.getSaldo());
//            System.out.println("Sacando R$ 3000,00...");
//            c1.sacar(3000.0);
            System.out.println("Sacando R$ 1000,00...");
            c1.sacar(1000.0);
            System.out.println("Saldo atualizado: R$ " + c1.getSaldo());
        }
        catch (ClienteException e) {
            System.out.println(e.toString());
        }
        finally {
            System.out.println("\nPrograma finalizado com sucesso.");
        }

    }
}