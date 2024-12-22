package com.hle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestPersonWithIterator {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person(1, "Alice"));
        people.add(new Person(2, "Bob"));
        people.add(new Person(3, "Charlie"));

        // Suppression sécurisée avec iterator
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getName().equals("Bob")) {
                iterator.remove(); // Suppression sécurisée
            }
        }

        System.out.println("Set après suppression de 'Bob' : " + people);
    }
}
