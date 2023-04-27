import java.util.*;

public class Main {
    public static void main(String[] args) {

        // A Interface List deve ser implementada pela classe ArrayList.
        List ourList = new ArrayList<>();

        ourList.add("Felipe");
        ourList.add("Roberta");
        ourList.add("Jorge");
        ourList.add("Juliana");
        ourList.add("Ricardo");

//        System.out.println(ourList);

//        System.out.println("List size: " + ourList.size());

//        System.out.println("Accessing the list with FOR:");
//        for (int i = 0; i < ourList.size(); i++) {
//            System.out.println(ourList.get(i));
//        }
//
//        System.out.println("Accessing the list with FOR - desc:");
//        for (int i = ourList.size() - 1; i >= 0; i--) {
//            System.out.println(ourList.get(i));
//        }

//        System.out.println("Accessing the list with ITERATOR:");
//        Iterator it = ourList.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

//        for (Object obj : ourList) {
////            System.out.println(obj);
////        }

        // Interface Set e a classe HashSet
//        Set ourSet = new HashSet();
//        ourSet.add("Brasil");
//        ourSet.add("Argentina");
//        ourSet.add("Uruguai");
//        ourSet.add("Equador");
//        ourSet.add("Suriname");
//        ourSet.add("Uruguai");
//
//        System.out.println("Accessing the SET with FOREACH");
//        for (Object obj : ourSet) {
//            System.out.println(obj);
//        }

        // Interface Map e a classe HashMap
        Map categories = new HashMap();
        categories.put(1, "Desktops");
        categories.put(2, "Notebooks");
        categories.put(3, "Tablets");
        categories.put(4, "Celulares");
        categories.put(5, "Acessórios");

        System.out.println("Search for key three:");
        System.out.println(categories.get(3));

        System.out.println("Accessing the MAP with FOREACH:");
        for (Object obj : categories.values()) {
            System.out.println(obj);
        }

    }
}