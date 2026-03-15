package org.example;

import java.util.Objects;

public class Street implements Comparable<Street>{
    private String name;
    private int length;
    Intersection A;
    Intersection B;

    public Street(String name, int length, Intersection a, Intersection b) {
        this.name = name;
        this.length = length;
        A = a;
        B = b;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Intersection getA() {
        return A;
    }

    public Intersection getB() {
        return B;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return length == street.length && Objects.equals(name, street.name) && Objects.equals(A, street.A) && Objects.equals(B, street.B);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, A, B);
    }

    @Override
    public int compareTo(Street o) {
        return Integer.compare(this.length, o.getLength());
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", A=" + A +
                ", B=" + B +
                '}';
    }
}
