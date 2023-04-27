import java.util.*;

public class Main {
    public static void main(String[] args) {

        // List
//        List selecoesList = new ArrayList<>();
//        selecoesList.add("Equador"); selecoesList.add("Holanda"); selecoesList.add("Catar");
//        selecoesList.add("Senegal"); selecoesList.add("Inglaterra"); selecoesList.add("Irã");
//        selecoesList.add("Estados Unidos"); selecoesList.add("País de Gales"); selecoesList.add("Argentina");
//        selecoesList.add("México"); selecoesList.add("Polônia"); selecoesList.add("Arábia Saudita");
//        selecoesList.add("Austrália"); selecoesList.add("Dinamarca"); selecoesList.add("França");
//        selecoesList.add("Tunísia"); selecoesList.add("Costa Rica"); selecoesList.add("Alemanha");
//        selecoesList.add("Japão"); selecoesList.add("Espanha"); selecoesList.add("Bélgica,");
//        selecoesList.add("Canadá"); selecoesList.add("Brasil"); selecoesList.add("Marrocos");
//        selecoesList.add("Portugal"); selecoesList.add("Croácia"); selecoesList.add("Gana");
//        selecoesList.add("Suíça"); selecoesList.add("Coreia do Sul"); selecoesList.add("Uruguai");
//        selecoesList.add("Sérvia"); selecoesList.add("Camarões");
//
//        Collections.sort(selecoesList);
//        System.out.println(selecoesList);

        // Set
//        Set selecoesSet = new HashSet<>();
//        selecoesSet.add("Equador"); selecoesSet.add("Holanda"); selecoesSet.add("Catar");
//        selecoesSet.add("Senegal"); selecoesSet.add("Inglaterra"); selecoesSet.add("Irã");
//        selecoesSet.add("Estados Unidos"); selecoesSet.add("País de Gales"); selecoesSet.add("Argentina");
//        selecoesSet.add("México"); selecoesSet.add("Polônia"); selecoesSet.add("Arábia Saudita");
//        selecoesSet.add("Austrália"); selecoesSet.add("Dinamarca"); selecoesSet.add("França");
//        selecoesSet.add("Tunísia"); selecoesSet.add("Costa Rica"); selecoesSet.add("Alemanha");
//        selecoesSet.add("Japão"); selecoesSet.add("Espanha"); selecoesSet.add("Bélgica,");
//        selecoesSet.add("Canadá"); selecoesSet.add("Brasil"); selecoesSet.add("Marrocos");
//        selecoesSet.add("Portugal"); selecoesSet.add("Croácia"); selecoesSet.add("Gana");
//        selecoesSet.add("Suíça"); selecoesSet.add("Coreia do Sul"); selecoesSet.add("Uruguai");
//        selecoesSet.add("Sérvia"); selecoesSet.add("Camarões");
//
//        System.out.println(selecoesSet);

        // Map
        Map selecoesMap = new HashMap<>();
        selecoesMap.put(1, "Canadá");
        selecoesMap.put(2, "Croácia");
        selecoesMap.put(3, "Camarões");
        selecoesMap.put(4, "Tunísia");
        selecoesMap.put(5, "Bélgica");

        System.out.println("Search for key three:");
        System.out.println(selecoesMap.get(3));

        System.out.println("Accessing the MAP with FOREACH:");
        for (Object obj : selecoesMap.values()) {
            System.out.println(obj);
        }

    }
}