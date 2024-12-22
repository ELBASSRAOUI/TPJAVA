package com.hle;

import java.util.HashSet;
import java.util.Set;

public class TestPersonWithoutIterator {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person(1, "Alice"));
        people.add(new Person(2, "Bob"));
        people.add(new Person(3, "Charlie"));

        // Tentative de suppression sans iterator (provoque une ConcurrentModificationException)
        try {
            for (Person person : people) {
                if (person.getName().equals("Bob")) {
                    people.remove(person); // Erreur ici
                }
            }
        } catch (Exception e) {
            System.out.println("Exception attrapée : " + e);
        }
    }
}
