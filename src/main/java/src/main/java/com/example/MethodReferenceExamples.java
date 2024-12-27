package src.main.java.com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceExamples {

    public static void demonstrateMethodReferences() {
        // 1. Class::method
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);

        // 2. Instance::method
        List<String> names = Arrays.asList("Youssef", "Fatima", "Ahmed");
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        // 3. Class::new
        List<String> addresses = Arrays.asList("123 Rue A", "456 Rue B");
        List<Person> persons = addresses.stream()
                .map(Person::new) // Utilise le constructeur Person(String address)
                .collect(Collectors.toList());
        persons.forEach(System.out::println); // Affiche les objets Person créés
    }
}
