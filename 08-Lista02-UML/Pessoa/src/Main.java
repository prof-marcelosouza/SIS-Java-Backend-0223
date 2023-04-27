import entities.Pessoa;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Airton Senna", "2541225569", "214.255.652-47", LocalDate.of(1971, Month.NOVEMBER, 5), "AB", "senna@gmail.com", "(51) 3366.5520", "(51) 99980.5005");

        System.out.println("Dados do P1:");
        System.out.println(p1);

        Pessoa p2 = new Pessoa(1, "Nigel Mansel", "3566987410", "221.165.520-69", LocalDate.of(1968, Month.MARCH, 12), "B", "mansel@gmail.com", "(51) 3028.4122", "(51) 98411.3200");

        System.out.println("Dados do P2:");
        System.out.println(p2);

        System.out.println(p1.equals(p2));
    }
}