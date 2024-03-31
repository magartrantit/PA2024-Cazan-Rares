package mypackage.lab5.classes;

import mypackage.lab5.interfaces.Command;
import mypackage.lab5.records.Person;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    private DocumentManager documentManager;
    private Person person;
    private String documentName;
    private String format;

    // Constructor
    public ViewCommand(DocumentManager documentManager, Person person, String documentName, String format) {
        this.documentManager = documentManager;
        this.person = person;
        this.documentName = documentName;
        this.format = format;
    }

    // Metoda pentru vizualizarea unui document
    @Override
    public void execute() throws IOException {
        File file = new File(documentManager.getMasterDirectory(), person.uniqueId() + File.separator + documentName + "." + format);
        Desktop.getDesktop().open(file);
    }
}