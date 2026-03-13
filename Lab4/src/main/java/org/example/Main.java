package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        List<Intersection> nodes = IntStream.rangeClosed(0,9)
                .mapToObj(i -> new Intersection("intersection" + i))
                .collect(Collectors.toList());

        List<Street> streetsList = new LinkedList<>();
        streetsList.add(new Street(10,"street1", nodes.get(0), nodes.get(1)));
        streetsList.add(new Street(15,"street2", nodes.get(1), nodes.get(2)));
        streetsList.add(new Street(25,"street3", nodes.get(0), nodes.get(2)));
        streetsList.add(new Street(10,"street4", nodes.get(1), nodes.get(3)));

        streetsList.sort(Comparator.comparingInt(Street::getLength));
        System.out.println(streetsList);
    }
}
