package org.example;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        String clasaTarget = "org.example.TargetClass";

        try {
            Class<?> clazz = Class.forName(clasaTarget);
            System.out.println("1. class loaded " + clazz.getName());

            Object instance = clazz.getDeclaredConstructor().newInstance();
            System.out.println("2. obj inst");

            Method runMethod = clazz.getMethod("run");
            System.out.println("3. metoda gasita " + runMethod.getName());

            System.out.println("4. invocare..\n");
            runMethod.invoke(instance);

        } catch (ClassNotFoundException e) {
            System.err.println("nu gasim clasa.");
        } catch (NoSuchMethodException e) {
            System.err.println("nu gasim metoda.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}