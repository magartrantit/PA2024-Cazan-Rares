package mypackage.lab5.records;

public record Person(String name, String id) {
    public String uniqueId() {
        return id;
    }
}