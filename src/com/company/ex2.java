package com.company.test2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test2 {

    public static void main(String[] args) {
//        List<String> liste = Arrays.asList("une chaine", "une autre chaine", "encore une chaine");
//        Optional<String> chaineLaPlusLongue = liste.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        // System.out.println(chaineLaPlusLongue.get()); // "encore une chaine"

//        List<Voiture> liste = Arrays.asList(new Voiture("citroen"),
//                new Voiture("renault"),
//                new Voiture("audi"),
//                new Voiture("citroen"));
//
//
//        Map<String, List<Voiture>> map = liste.stream().collect(Collectors.groupingBy(Voiture::getMarque));
//        //System.out.println(map.toString());
//        System.out.println(map.get("citroen").size()); // 2
//        System.out.println(map.get("renault").size()); // 1
//        System.out.println(map.get("audi").size());    // 1
//
//        List<String> list = Arrays.asList("un", "deux", "trois", "quatre", "cinq");
//        String resultat = list.stream().collect(Collectors.joining(", "));
//
//        System.out.println(resultat); // "un, deux, trois, quatre, cinq"
//
//
//
//        IntStream.iterate(1, n -> n + 1)// commence de 1 et chaque fois il fait i+=2
//                .filter(n -> n % 7 != 0)
//                .filter(n -> n % 2 != 0)
//                .limit(500)// il s'arrete au 500 premier element
//                .forEach(System.out::println);
//
//
//
//
//// mapping du stream de voiture en stream de String
//        Set<String> marques = liste.stream()
//                .map(Voiture::getMarque)
//                .collect(Collectors.toSet());
//
//        System.out.println(marques); // ["audi", "citroen", "renault", "volkswagen"]
//
//
//        // Affichage de la racine carré des 100 premiers entiers
//        IntStream.range(1, 101)
//                .mapToDouble(Math::sqrt)
//                .forEach(System.out::println);

        IntStream.range(1, 101).parallel().forEach(System.out::println);

    }
}
