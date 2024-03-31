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

    // Getter pentru directorul master
    public String getMasterDirectory() {
        return masterDirectory;
    }

    // Metoda pentru obtinerea unui document
    public Document getDocument(Person person, String documentName) throws IOException {
        Path path = Paths.get(masterDirectory, person.uniqueId(), documentName);
        byte[] content = Files.readAllBytes(path);
        String format = getFileExtension(path);
        return new Document(documentName, format, content);
    }


    // Metoda pentru obtinerea extensiei unui fisier
    private String getFileExtension(Path path) {
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}