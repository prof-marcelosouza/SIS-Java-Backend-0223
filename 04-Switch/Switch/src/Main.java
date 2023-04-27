import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double valorCompra; // Camel case
        int perc;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor da compra: ");
        valorCompra = sc.nextDouble();
        System.out.println("Digite o percentual de desconto: ");
        perc = sc.nextInt(); // 5

        switch (perc) {
            case 5:
                System.out.println("Desconto de 5%.");
                break;
            case 15:
                System.out.println("Desconto de 15%.");
                break;
            case 20:
                System.out.println("Desconto de 20%.");
                break;
            default:
                System.out.println("Desconto indisponível.");
        }

        sc.close();
    }
}