package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class City {
    private String name;
    Set<Intersection> intersections = new HashSet<>();
    List<Street> streets = new ArrayList<>();

    public void addStreet(Street street, Intersection A, Intersection B){
        streets.add(street);
        intersections.add(A);
        intersections.add(B);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", intersections=" + intersections +
                ", streets=" + streets +
                '}';
    }
}
