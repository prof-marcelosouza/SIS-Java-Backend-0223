import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n1, n2, adicao, subtracao, mult, div;
        double d1, d2, adicaodouble, subtracaodouble, multdouble, divdouble;

        // Atribuição de um objeto Scanner na variável sc;
        Scanner sc = new Scanner(System.in); // Instância

        System.out.print("Digite o valor de n1: ");
        n1 = sc.nextInt();
        System.out.println("N1: " + n1);

        System.out.print("Digite o valor de n2: ");
        n2 = sc.nextInt();
        System.out.println("N2: " + n2);

        adicao = n1 + n2;
        System.out.println("O resultado da adição int é: " + adicao);

        subtracao = n1 - n2;
        System.out.println("O resultado da subtração int é: " + subtracao);

        mult = n1 * n2;
        System.out.println("O resultado da multiplicação int é: " + mult);

        div = n1 / n2;
        System.out.println("O resultado da divisão int é: " + div);

        // --------------------------------------------------------------------

        System.out.print("Digite o valor de d1: ");
        d1 = sc.nextDouble();

        System.out.print("Digite o valor de d2: ");
        d2 = sc.nextDouble();

        adicaodouble = d1 + d2;
        System.out.println("O resultado da adição double é: " + adicaodouble);

        subtracaodouble = d1 - d2;
        System.out.println("O resultado da subtração double é: " + subtracaodouble);

        multdouble = d1 * d2;
        System.out.println("O resultado da multiplicação double é: " + multdouble);

        divdouble = d1 / d2;
        System.out.println("O resultado da divisão double é: " + divdouble);

        sc.close(); // Destroi o objeto na memória RAM;
    }
}