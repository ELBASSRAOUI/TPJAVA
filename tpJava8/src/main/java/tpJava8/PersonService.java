package tpJava8;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    // Méthode pour filtrer par adresse
    public static List<Person> filterByAddress(String address) {
        List<Person> mockPersonsDatabase = getMockPersons();

        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);

        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }

    // Méthode pour filtrer les adultes
    public static List<Person> filterAdults() {
        List<Person> mockPersonsDatabase = getMockPersons();

        Predicate<Person> isAdult = person -> person.calculateAge() >= 18;

        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }

    // Méthode personnalisée : Trier les adultes par nom et prénom
    public static List<Person> filterAndSortAdults() {
        return filterAdults().stream()
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    // Base de données simulée
    private static List<Person> getMockPersons() {
        return Arrays.asList(
                new Person("Alice", "Doe", LocalDate.of(1990, 5, 12), "123 Rue A"),
                new Person("Bob", "Smith", LocalDate.of(2005, 10, 15), "456 Rue B"),
                new Person("Charlie", "Brown", LocalDate.of(1985, 3, 9), "789 Rue C"),
                new Person("Diana", "Doe", LocalDate.of(2000, 8, 24), "123 Rue A")
        );
    }

    // Classe Person
    public static class Person {
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private String address;

        public Person(String firstName, String lastName, LocalDate birthDate, String address) {
            this.firstName = firstName.trim();
            this.lastName = lastName.trim();
            this.birthDate = birthDate;
            this.address = address;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public String getAddress() {
            return address;
        }

        public int calculateAge() {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + " (" + calculateAge() + " ans), Adresse: " + address;
        }
    }

    // Main pour tester les méthodes
    public static void main(String[] args) {
        System.out.println("Filtrer par adresse (123 Rue A) :");
        filterByAddress("123 Rue A").forEach(System.out::println);

        System.out.println("\nFiltrer les adultes :");
        filterAdults().forEach(System.out::println);

        System.out.println("\nFiltrer et trier les adultes :");
        filterAndSortAdults().forEach(System.out::println);
    }
}
