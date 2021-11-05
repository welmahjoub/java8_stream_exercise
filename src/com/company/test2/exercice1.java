package com.company.test2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class exercice1 {


    public static void main(String[] args) throws IOException {

        String chaine="med125po";

        //Utilisez l’API des Streams pour compter le nombre de lettres dans une chaîne de caractères.

        Long nb=chaine .chars().filter(Character::isAlphabetic).count();
        //System.out.println(nb);


        // ex 2

        //ficher csv:  nom du produit, le montant HT du produit et la taxe en pourcentage pour ce produit

        Path fichier = Paths.get("produit.csv");
        Stream<String> linesStream = Files.lines(fichier);


        // 1 .Le premier programme doit retourner le prix TTC moyen de tous les produits
        //linesStream.map(e->e.split(";")).map(e-> e[1]).map(Integer::valueOf).map(e->(e * 20)/100)

//        double d=linesStream.map(e->e.split(";")).mapToDouble(e-> Double.parseDouble(e[1])).map(e->e*1.2).average().getAsDouble();
//        System.out.println(d);

        //filter(e->e[1]==5.5 & )
        // q2 : Le second programme doit afficher la liste des produits taxés à 5,5% et qui coûtent moins de 100€ HT.
        linesStream.map(e->e.split(";")).
                map(e-> new Object(){ double prix=Double.parseDouble(e[1]),tax=Double.parseDouble(e[2]);}).
                filter(e->e.tax==5.5 && e.prix<100).forEach(e->System.out.println(e.tax+" prix : "+e.prix));

    }
}
