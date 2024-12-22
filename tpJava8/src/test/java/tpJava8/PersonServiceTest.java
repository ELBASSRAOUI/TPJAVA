package tpJava8;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonServiceTest {

    @Test
    public void testFilterByAddress() {
        List<PersonService.Person> filtered = PersonService.filterByAddress("123 Rue A");

        assertThat(filtered).hasSize(2);
        assertThat(filtered.get(0).getFirstName()).isEqualTo("Alice");
        assertThat(filtered.get(1).getFirstName()).isEqualTo("Diana");
    }

    @Test
    public void testFilterAdults() {
        List<PersonService.Person> adults = PersonService.filterAdults();

        // Attendu : 4 adultes (Alice, Bob, Charlie, Diana)
        assertThat(adults).hasSize(4);
        assertThat(adults).extracting("firstName").contains("Alice", "Bob", "Charlie", "Diana");
    }

    @Test
    public void testFilterAndSortAdults() {
        List<PersonService.Person> sortedAdults = PersonService.filterAndSortAdults();

        // Attendu : 4 adultes triés par nom, puis prénom
        assertThat(sortedAdults).hasSize(4);
        assertThat(sortedAdults.get(0).getLastName()).isEqualTo("Brown"); // Charlie
        assertThat(sortedAdults.get(1).getFirstName()).isEqualTo("Alice"); // Alice Doe
        assertThat(sortedAdults.get(2).getFirstName()).isEqualTo("Diana"); // Diana Doe
        assertThat(sortedAdults.get(3).getFirstName()).isEqualTo("Bob");   // Bob Smith
    }
}
