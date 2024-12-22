package com.tp5;

public class Person implements Comparable<Person> {
    private String lastName;
    private String firstName;

    public Person(String lastName, String firstName) {
        this.lastName = lastName.trim();
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int compareTo(Person other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        } else {
            return this.firstName.compareTo(other.firstName);
        }
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
}
