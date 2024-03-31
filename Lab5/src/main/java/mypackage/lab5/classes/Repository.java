package mypackage.lab5.classes;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repository {
    private final String masterDirectory;

    // Constructor
    public Repository(String masterDirectory) {
        this.masterDirectory = masterDirectory;
    }

    // Metoda pentru afisarea continutului
    public void displayContent() throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(masterDirectory))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        }
    }

    // Metoda pentru obtinerea fisierelor
    public List<Path> getFiles() throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(masterDirectory))) {
            return paths
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
    }
}