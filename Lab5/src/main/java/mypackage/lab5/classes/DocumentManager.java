package mypackage.lab5.classes;

import mypackage.lab5.records.Document;
import mypackage.lab5.records.Person;

import java.io.*;
import java.nio.file.*;

public class DocumentManager {
    private final String masterDirectory;

    // Constructor
    public DocumentManager(String masterDirectory) {
        this.masterDirectory = masterDirectory;
    }

    // Metoda pentru crearea unui director pentru o persoana
    public void createPersonDirectory(Person person) throws IOException {
        Path path = Paths.get(masterDirectory, person.uniqueId());
        Files.createDirectories(path);
    }

    // Metoda pentru adaugarea unui document in folderul unei persoane
    public void addDocument(Person person, Document document) throws IOException {
        Path path = Paths.get(masterDirectory, person.uniqueId(), document.name() + "." + document.format());
        Files.write(path, document.content());
    }

    // Metoda pentru obtinerea unui document
    public Document getDocument(Person person, String documentName, String format) throws IOException {
        Path path = Paths.get(masterDirectory, person.uniqueId(), documentName + "." + format);
        byte[] content = Files.readAllBytes(path);
        return new Document(documentName, format, content);
    }
}