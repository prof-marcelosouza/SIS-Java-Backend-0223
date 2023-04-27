public class Main {
    public static void main(String[] args) {

        String[] names = new String[6];

        names[0] = "Fernando";
        names[1] = "Mário";
        names[2] = "Carlos";
        names[3] = "Simone";
        names[4] = "Tatiana";
        names[5] = "Pedro";

//        System.out.println(names[2]);
//        System.out.println(names[8]);

        // Acessando o array com o For
//        for(int i = 0; i < names.length; i++) {
//            System.out.println("Índice["+i+"]: " + names[i]);
//        }

        // Acessando o array com o while
//        int j = 0;
//        while (j < names.length) {
//            System.out.println("Índice["+j+"]: " + names[j]);
//            j++;
//        }

        // Foreach
        int k = 0;
        for (String key : names) {
            System.out.println("Índice["+k+"]: " + names[k]);
            k++;
        }

    }
}