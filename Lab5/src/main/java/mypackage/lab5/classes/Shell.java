// Shell.java
package mypackage.lab5.classes;

import mypackage.lab5.records.Document;
import mypackage.lab5.records.Person;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Shell {
    private DocumentManager documentManager;

    public Shell(String masterDirectory) {
        this.documentManager = new DocumentManager(masterDirectory);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            try {
                switch (parts[0]) {
                    case "export":
                        new ExportCommand(new Repository(documentManager.getMasterDirectory())).execute();
                        break;
                    case "report":
                        new ReportCommand(new Repository(documentManager.getMasterDirectory())).execute();
                        break;
                    case "view":
                        if (parts.length < 3) {
                            System.out.println("Nu ai dat suficiente argumente!");
                            continue;
                        }
                        Document document = documentManager.getDocument(new Person(parts[1], parts[2]), parts[3]);
                        System.out.println("Document content: " + new String(document.content(), StandardCharsets.UTF_8));
                        break;
                    default:
                        System.out.println("Comanda invalida!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}