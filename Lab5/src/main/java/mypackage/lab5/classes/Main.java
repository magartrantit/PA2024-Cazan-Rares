package mypackage.lab5.classes;

import mypackage.lab5.records.Document;

import mypackage.lab5.records.Person;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String masterDirectory = "C:\\Users\\Rares\\Desktop\\Java\\Lab5\\Master";
        Repository repository = new Repository(masterDirectory);
        DocumentManager documentManager = new DocumentManager(masterDirectory);

        //folderele persoana
        Person person1 = new Person("John Doe", "123");
        Person person2 = new Person("Jane Doe", "456");

        //documentele din foldere
        Document document1 = new Document("file1", "txt", "Hello, John!".getBytes(StandardCharsets.UTF_8));
        Document document2 = new Document("file2", "txt", "Hello, Jane!".getBytes(StandardCharsets.UTF_8));

        try {
            // Cream folderele pentru persoane
            documentManager.createPersonDirectory(person1);
            documentManager.createPersonDirectory(person2);

            // Adaugam documentele in foldere
            documentManager.addDocument(person1, document1);
            documentManager.addDocument(person2, document2);

            // Afisam continutul
            repository.displayContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //lista pentru grupuri
        List<Set<Person>> maximalGroups = repository.findMaximalGroups();

        //afisam grupurile
        for (int i = 0; i < maximalGroups.size(); i++) {
            System.out.println("Group " + (i + 1) + ":");
            for (Person person : maximalGroups.get(i)) {
                System.out.println(person.name());
            }
            System.out.println();
        }

        Shell shell = new Shell(masterDirectory);
        shell.start();


    }
}