import entities.Pessoa;
import entities.Pet;

public class Main {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Pedro");
        Pessoa p2 = new Pessoa(2, "Paula");
        Pessoa p3 = new Pessoa(3, "Moises");

        Pet pet1 = new Pet(1, "Fila", p1);
        Pet pet2 = new Pet(2, "Dogue Alemão", new Pessoa(4, "Luis"));
        Pet pet3 = new Pet(3, "Beagle", p2);
        Pet pet4 = new Pet(4, "Basset", p2);
        Pet pet5 = new Pet(5, "Golden retrievier", p3);

        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);
        System.out.println(pet4);
        System.out.println(pet5);


    }
}