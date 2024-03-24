package mypackage.lab4;

public class Person implements Comparable<Person> {
    protected final String name;
    protected String destination;
    protected int age;

    // Constructor
    public Person(String name, String destination) {
        this.name = name;
        this.destination = destination;
    }

    // Getter pentru destinatie
    protected String getDestination() {
        return destination;
    }

    // Getter pentru varsta
    protected int getAge() {
        return age;
    }

    // Setter pentru varsta
    public void setAge(int age) {
        this.age = age;
    }

    // Getter pentru nume
    public String getName() {
        return name;
    }

    // Metoda compareTo pentru a sorta persoanele
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}
