import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Estruturas condicionais
        short idade = 19;

        // IF Simples
        if (idade >= 18) { // Executa quando o resultado do teste for TRUE.
            System.out.println("candidato apto ao exame de CNH.");
        }

        // IF Composto
        double salario = 980.52;

        // Ou ele executa o IF, caso seja TRUE, ou executa o ELSE
        if (salario >= 0.0 && salario <= 1950.25) { // FALSE
            System.out.println("Contribuinte isento de IR.");
        } else { // Então
            System.out.println("Contribuinte deve pagar o IR.");
        }

        double sal, deducaoPorDep = 189.59;
        int dependentes;

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o salário: ");
        sal = sc.nextDouble();
        System.out.print("Quantos dependentes: ");
        dependentes = sc.nextInt();

        // 1650.52
        if (sal <= 1903.98) {
            System.out.println("Contribuinte isento de IR.");
        }
        // 2100.50
        if (sal >= 1903.99 && sal <= 2826.65) {
            System.out.printf("Contribuinte com salário de R$ %.2f pagará 7.5%% de IR.%n", sal);
            System.out.printf("Com dedução de %d dependentes.", dependentes);
        }
        // 3550.20
        if (sal >= 2826.66 && sal <= 3751.05) {
            System.out.printf("Contribuinte com salário de R$ %.2f pagará 15%% de IR.%n", sal);
            System.out.printf("Com dedução de %d dependentes.", dependentes);
        }
        // 3955.00
        if (sal >= 3751.06 && sal <= 4664.68) {
            System.out.printf("Contribuinte com salário de R$ %.2f pagará 22.5%% de IR.%n", sal);
            System.out.printf("Com dedução de %d dependentes.", dependentes);
        }
        // 5410.00
        if (sal >= 4664.69) {
            System.out.printf("Contribuinte com salário de R$ %.2f pagará 27.5%% de IR.%n", sal);
            System.out.printf("Com dedução de %d dependentes.", dependentes);
        }

        System.out.println("");

        // IF aninhado
        if (sal <= 1903.98) {
            System.out.println("Contribuinte isento de IR.");
        } else if (sal >= 1903.99 && sal <= 2826.65) {
            System.out.printf("Contribuinte com salário de R$ %.2f pagará 7.5%% de IR.%n", sal);
        } else if (sal >= 2826.66 && sal <= 3751.05) {
            System.out.printf("Contribuinte com salário de R$ %.2f pagará 15%% de IR.%n", sal);
        } else if (sal >= 3751.06 && sal <= 4664.68) {
            System.out.printf("Contribuinte com salário de R$ %.2f pagará 22.5%% de IR.%n", sal);
        } else {
            System.out.printf("Contribuinte com salário de R$ %.2f pagará 27.5%% de IR.%n", sal);
        }

        System.out.printf("Com direito a dedução de %d dependentes.", dependentes);

    }
}