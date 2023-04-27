import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        1.1.1 Construa um algoritmo que receba 1 (um) número inteiro e informe se ele é par
        ou ímpar no console.
         */

//        int num;
//
//        System.out.print("Digite um número inteiro: ");
//        num = sc.nextInt(); // 13
//
//        if (num % 2 == 0) {
//            System.out.println("O número " + num + " é par!");
//        } else {
//            System.out.println("O número " + num + " NÃO é par!");
//        }

        /*
        1.1.2 Construa um algoritmo que receba 3 (três) números inteiros e informe qual é o
        maior número. 4 2 9
         */

//        int n1, n2, n3;
//
//        for (int i = 1; i <= 3; i++) {
//
//            System.out.println("Digite três números diferentes: ");
//            System.out.print("Digite o número 01: ");
//            n1 = sc.nextInt();
//            System.out.print("Digite o número 02: ");
//            n2 = sc.nextInt();
//            System.out.print("Digite o número 03: ");
//            n3 = sc.nextInt();
//
//            if (n1 > n2 && n1 > n3) {
//                System.out.println("O número " + n1 + " é o maior.");
//            } else if (n2 > n1 && n2 > n3) {
//                System.out.println("O número " + n2 + " é o maior.");
//            } else {
//                System.out.println("O número " + n3 + " é o maior.");
//            }
//
//        } // Fecha o For

        /*
        1.1.3 Construa um algoritmo que receba 6 (seis) notas, do tipo double, entre o
        intervalo de 0.0 – 10.0 e logo após calcule a média aritmética. Ao final o
        programa deve imprimir na tela o status do aluno com base nas seguintes
        regras de avaliação:
         0.0 – 2.99 Aluno reprovado por nota;
         3.0 – 5.99 Aluno em recuperação;
         6.0 – 10.0 Aluno aprovado por nota.
         */

//        double n1, n2, n3, n4, n5, n6, media;
//
//        System.out.print("Digite a N1: ");
//        n1 = sc.nextDouble();
//        System.out.print("Digite a N2: ");
//        n2 = sc.nextDouble();
//        System.out.print("Digite a N3: ");
//        n3 = sc.nextDouble();
//        System.out.print("Digite a N4: ");
//        n4 = sc.nextDouble();
//        System.out.print("Digite a N5: ");
//        n5 = sc.nextDouble();
//        System.out.print("Digite a N6: ");
//        n6 = sc.nextDouble();
//
//        media = (n1 + n2 + n3 + n4 + n5 + n6) / 6;
//
//        if (media < 3.0) {
//            System.out.printf("Média do aluno: %.2f - REPROVADO", media);
//        } else if (media <= 5.99) {
//            System.out.printf("Média do aluno: %.2f - EM RECUPERAÇÃO", media);
//        } else {
//            System.out.printf("Média do aluno: %.2f - APROVADO", media);
//        }

        /*
        1.2.1 Construa um algoritmo que receba um número inteiro no intervalo de 1 – 7 e
        imprima na tela o respectivo dia da semana na seguindo a tabela abaixo:
         1 – domingo
         2 – segunda-feira
         3 – terça-feira
         4 – quarta-feira
         5 – quinta-feira
         6 – sexta-feira
         7 – sábado
        Caso seja digitado um valor fora do intervalo informar a mensagem: “Número
        inválido”.
         */

//        int num;
//
//        System.out.print("Digite um número refernte ao dia da semana: ");
//        num = sc.nextInt();
//
//        switch (num) {
//            case 1:
//                System.out.println("Hoje é domingo.");
//                break;
//            case 2:
//                System.out.println("Hoje é segunda-feira.");
//                break;
//            case 3:
//                System.out.println("Hoje é terça-feira.");
//                break;
//            case 4:
//                System.out.println("Hoje é quarta-feira.");
//                break;
//            case 5:
//                System.out.println("Hoje é quinta-feira.");
//                break;
//            case 6:
//                System.out.println("Hoje é sexta-feira.");
//                break;
//            case 7:
//                System.out.println("Hoje é domingo.");
//                break;
//            default:
//                System.out.println("Número inválido!");
//        }

        /*
        1.3.1 Construa um algoritmo que conte de zero até 50 e imprima somente os números
        ímpares.
         */

//        int numero = 0; // É preciso inicializar
//
//        while (numero < 52) {
//            if (numero % 2 != 0) {
//                System.out.println(numero);
//            }
//            numero++;
//        }

        /*
        1.4.1 Construa um algoritmo que leia os salários de 15 funcionários e ao fim mostre a média salarial dos mesmos.
         */
//        double salario, acumulador = 0.0, mediaSalarial;
//
//        for (int i = 1; i <= 3; i++) {
//            System.out.print("Digite o salário: ");
//            salario = sc.nextDouble();
//            acumulador = acumulador + salario;
//        }
//
//        mediaSalarial = acumulador / 3;
//
//        System.out.printf("A média dos salários dos funcionários é de: %.2f", mediaSalarial);

        /*
        1.5.1 Construa um algoritmo que contenha um array com todas as alíquotas do
        Imposto de Renda de Pessoa Física, são elas {0.0, 7.5, 15.0, 22.5, 27.5}.
        Logo após os imprima no console.
        */

//        double[] aliquotas = {0.0, 7.5, 15.0, 22.5, 27.5}; // 0 1 2 3 4
//
//        for (double aliq : aliquotas) {
//            System.out.println(aliq + "%");
//        }

        // Métodos == Funções

        /*
        * 1.6.1 Construa um algoritmo que receba um salário bruto de um funcionário e envie
        para uma função que calcule em qual alíquota de Imposto de Renda de Pessoa Física
        o mesmo estará enquadrado com base nos dados abaixo:
        *
         até R$ 1.903,98 – Isento
         de R$ 1.903,99 a R$ 2.826,65 – 7,5%
         de R$ 2.826,66 a R$ 3.751,05 – 15.0%
         de R$ 3.751,06 a R$ 4.664,68 – 22,5%
         acima de R$ 4.664,68 – 27,5%
        Caso seja isento informe também que será descontado 6% de vale-transporte em
        relação ao salário informado.
        * */

//        double salario;
//
//        System.out.print("Informe o salário bruto do funcionário: ");
//        salario = sc.nextDouble(); // 4210,65
//
//        // Uma função ou método que calculará a alíquota do contribuinte.
//        calculaImposto(salario);

        /*
        1.7.1 Construa um algoritmo que possua um array de 5 (cinco posições). Logo após
        adicione as seguintes marcas: {“Ford”, “Chevrolet”, “Volkswagen”, “Fiat”, “Renault”}.
        Depois busque dentro do vetor todas as palavras (pelas suas posições) e conte
        quantas letras tem cada uma delas. Ao final imprima na tela qual delas possui a maior
        quantidade de letras e quantas elas são.
         */

        String[] marcas = new String[5];
        marcas[0] = "Ford"; // 4
        marcas[1] = "Chevrolet"; // 9
        marcas[2] = "Volkswagen"; // 10
        marcas[3] = "Fiat"; // 4
        marcas[4] = "Renault"; // 7

        int maior = 0, indice = 0;

        for (int i = 0; i <= 4; i++) {
            int qtdeLetras = marcas[i].length();
            // System.out.println("Quantidade de letras: " + qtdeLetras);
            if (qtdeLetras > maior) {
                maior = qtdeLetras; // 10
                indice = i; // 2
            }
        }

        System.out.print("A marca com a maior quatidade de letras é a: " + marcas[indice]);
        System.out.print("\nEla possui " + maior + " letras");
    } // Fecha o método Main

    // Criar um método customizado
//    public static void calculaImposto(double sal) {
//
//        if (sal > 0) {
//
//            if (sal <= 1903.98) {
//                System.out.println("O contribuinte está isento de IR.");
//                System.out.println("Será descontado 6% de vale-transporte.");
//            } else if (sal <= 2826.65) {
//                System.out.println("O contribuinte será tributado em 7.5%.");
//            } else if (sal <= 3751.05) {
//                System.out.println("O contribuinte será tributado em 15%.");
//            } else if (sal <= 4664.68) {
//                System.out.println("O contribuinte será tributado em 22.5%.");
//            } else {
//                System.out.println("O contribuinte será tributado em 27.5%.");
//            }
//
//        } else {
//
//            System.out.print("ERRO: Salário inválido!");
//
//        }
//
//    }

} // Fecha a classe Main
