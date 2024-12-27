package test.java.com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodReferenceExamplesTest {

    @Test
    public void testMethodReferences() {
        // Test 1: Class::method
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> expectedOutput = Arrays.asList("1", "2", "3", "4", "5");
        List<String> actualOutput = numbers.stream()
                                           .map(String::valueOf)
                                           .collect(Collectors.toList());
        assertEquals(expectedOutput, actualOutput);

        // Test 2: Instance::method
        List<String> names = Arrays.asList("Youssef", "Fatima", "Ahmed");
        List<String> upperCaseNames = names.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());
        assertEquals(Arrays.asList("YOUSSEF", "FATIMA", "AHMED"), upperCaseNames);

        // Test 3: Class::new
        List<String> addresses = Arrays.asList("123 Rue A", "456 Rue B");
        List<Person> persons = addresses.stream()
                                         .map(Person::new)
                                         .collect(Collectors.toList());
        assertEquals(2, persons.size());
        assertEquals("Person{address='123 Rue A'}", persons.get(0).toString());
        assertEquals("Person{address='456 Rue B'}", persons.get(1).toString());
    }

    // Mock class for Person (if not already defined in your project)
    static class Person {
        private final String address;

        public Person(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{address='" + address + "'}";
        }
    }
}
