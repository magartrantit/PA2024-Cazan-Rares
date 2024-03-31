package mypackage.lab5.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import mypackage.lab5.classes.Repository;
import mypackage.lab5.interfaces.Command;

import java.io.File;
import java.io.IOException;

public class ExportCommand implements Command {
    private Repository repository;

    // Constructor
    public ExportCommand(Repository repository) {
        this.repository = repository;
    }

    // Metoda pentru export
    @Override
    public void execute() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("repository.json"), repository.getFiles());
    }
}