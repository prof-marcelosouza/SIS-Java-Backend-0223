public class Main {

    public static void main(String[] args) {

        int valor = 50;

//        // Estruturas de repetição: WHILE (Enquanto)
//        while (valor <= 100) {
//            System.out.println(valor); // 50 51
//            valor++; // valor = valor + 1 (incrementar)
//        }
//
//        int numero = 0;
//        // Estruturas de repetição: FOR (Para)
//        for (int i = 10; i >= numero; i--) {
//            System.out.println("Número: " + i);
//        }

        int numeroFinal = 200;
        // Estruturas de repetição: FOR (Para)
        // Inicialização; condição; incremento/decremento
//        for (int i = 0; i <= numeroFinal; i = i+10) {
//            System.out.println("Número: " + i);
//        }

        // Declaração de array
        double[] notas = {6.5, 7.8, 4.1, 1.5, 9.2, 6.4, 9.9, 10.0};

        System.out.println("Impressão por índice:");
        System.out.println("Nota 1: " + notas[0]);
        System.out.println("Nota 2: " + notas[1]);
        System.out.println("Nota 3: " + notas[2]);
        System.out.println("Nota 4: " + notas[3]);
        System.out.println("Nota 5: " + notas[4]);

        int cont = 1;
        System.out.println("Impressão por laço de repetição:");
        for (double var : notas) {
            System.out.println("Nota " + cont +": " + var);
            cont++;
        }
    }

}