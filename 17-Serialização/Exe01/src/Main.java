import entities.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cachorro> cachorroList = new ArrayList<>();

        Cachorro c1 = new Cachorro("Pluto", "Fila", 5, "Av. Bento Gonçalves, 254");
        Cachorro c2 = new Cachorro("Tob", "Beagle", 3, "Rua das Hortências, 211");
        Cachorro c3 = new Cachorro("Puk", "Beagle", 2, "Rua Farroupilha, 255");

        cachorroList.add(c1);
        cachorroList.add(c2);
        cachorroList.add(c3);

        // Salvar esta coleção de cachorros em um arquivo: saida.txt
//        FileOutputStream fo = null;
//
//        try {
//            fo = new FileOutputStream("saida.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fo);
//            oos.writeObject(cachorroList);
//            System.out.println("Serializando a lista de cachorros...");
//        }
//        catch (FileNotFoundException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//        catch (Exception e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }

        // Recuperar a coleção de cachorros
        List<Cachorro> recuperaCachorros = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("saida2.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            // Aqui precisamos utilizar um casting
            recuperaCachorros = (ArrayList) ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for (Cachorro cach : recuperaCachorros) {
            System.out.println(
                    cach.getNome() + " | " +
                    cach.getRaca() + " | " +
                    cach.getIdade() + " | " +
                    cach.getEndereco()
            );
        }

    }
}