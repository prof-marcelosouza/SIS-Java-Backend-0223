import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1, num2, div;

        try {
            System.out.print("Digite o número 01: ");
            num1 = sc.nextInt();
            System.out.print("Digite o número 02: ");
            num2 = sc.nextInt();
            div = num1 / num2;
            System.out.print("Resultado da divisão: " + div);
        }
        catch (InputMismatchException e) {
            System.err.println("Erro na entrada de dados.");
        }
        catch (ArithmeticException e) {
            System.err.println("Erro na divisão. O denominador não pode ser zero.");
        }
        finally {
            System.out.println("O software está sendo encerrado ...");
            sc.close();
        }

    }
}