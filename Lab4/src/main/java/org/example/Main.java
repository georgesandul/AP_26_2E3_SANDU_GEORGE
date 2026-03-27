package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        City iasi = new City("Iasi");

        Faker faker = new Faker();

        List<Intersection> interList = Stream.iterate(0, i -> i+1)
                .limit(6)
                .map(i-> new Intersection(faker.address().city()))
                .toList();

        List<Street> streets = new LinkedList<>();
        streets.add(new Street(faker.address().streetName(), 15, interList.get(0), interList.get(1)));
        streets.add(new Street(faker.address().streetName(), 20, interList.get(1), interList.get(2)));
        streets.add(new Street(faker.address().streetName(), 40, interList.get(0), interList.get(3)));
        streets.add(new Street(faker.address().streetName(), 10, interList.get(1), interList.get(4)));
        streets.add(new Street(faker.address().streetName(), 5, interList.get(2), interList.get(0)));
        streets.add(new Street(faker.address().streetName(), 20, interList.get(2),interList.get(5)));
        streets.add(new Street(faker.address().streetName(), 8, interList.get(4),interList.get(5)));

        for (Street s : streets){
            iasi.addStreet(s);
        }

        System.out.println(iasi);

        iasi.longer3();
        iasi.minimumCostSolution(4);

        // compulsory-ul
//        streets.sort(Comparator.comparingInt(Street::getLength));

//        System.out.println(streets);

//        Set<Intersection> interSet = new HashSet<>(interList);
//        System.out.println(interSet);
//        Intersection duplicateIntersection = new Intersection("Intersection4");
//        boolean isAdded = interSet.add(duplicateIntersection);
//        System.out.println(isAdded);
    }
}
