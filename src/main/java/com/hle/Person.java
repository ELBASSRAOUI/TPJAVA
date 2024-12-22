package com.hle;

// Classe Person avec id, name, et méthodes essentielles
class Person {
    private int id;
    private String name;

    // Constructeur
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter pour le nom
    public String getName() {
        return name;
    }

    // Méthode equals basée sur l'attribut id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id;
    }

    // Méthode hashCode
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    // Méthode toString pour afficher les informations de la personne
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }
}
