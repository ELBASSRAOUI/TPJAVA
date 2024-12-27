package src.main.java.com.example;

public class Person {
    private String address;

    public Person(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{address='" + address + "'}";
    }
}
