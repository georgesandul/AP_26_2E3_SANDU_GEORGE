package org.example;

import java.util.Objects;

public class Street implements Comparable<Street>{
    private int length;
    private String name;
    private Intersection one;
    private Intersection two;

    public Street(int length, String name, Intersection one, Intersection two) {
        this.length = length;
        this.name = name;
        this.one = one;
        this.two = two;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Double.compare(length, street.length) == 0 && Objects.equals(name, street.name) && Objects.equals(one, street.one) && Objects.equals(two, street.two);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, name, one, two);
    }

    @Override
    public int compareTo(Street o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Street{" +
                "length=" + length +
                ", name='" + name + '\'' +
                ", one=" + one +
                ", two=" + two +
                '}';
    }
}
