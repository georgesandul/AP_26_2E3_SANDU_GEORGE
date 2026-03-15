package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Intersection> interList = Stream.iterate(0, i -> i+1)
                .limit(5)
                .map(i-> new Intersection("Intersection" + i))
                .toList();

        List<Street> streets = new LinkedList<>();
        streets.add(new Street("Vitejilor", 15, interList.get(0), interList.get(1)));
        streets.add(new Street("Simionescu", 20, interList.get(1), interList.get(2)));
        streets.add(new Street("Bd. Dacia", 40, interList.get(0), interList.get(3)));

        streets.sort(Comparator.comparingInt(Street::getLength));

        System.out.println(streets);

        Set<Intersection> interSet = new HashSet<>(interList);
        System.out.println(interSet);
        Intersection duplicateIntersection = new Intersection("Intersection4");
        boolean isAdded = interSet.add(duplicateIntersection);
        System.out.println(isAdded);
    }
}
