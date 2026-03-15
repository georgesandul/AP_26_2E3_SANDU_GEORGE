package org.example;

import java.util.Objects;

public class Intersection implements Comparable<Intersection> {
    private String name;

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Intersection o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }
}
