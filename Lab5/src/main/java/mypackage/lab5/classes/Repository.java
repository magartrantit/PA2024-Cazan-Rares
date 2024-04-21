package mypackage.lab5.classes;

import mypackage.lab5.records.Person;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repository {
    private final String masterDirectory;
    private Map<Person, Set<String>> personAbilities = new HashMap<>();

    // Constructor
    public Repository(String masterDirectory) {
        this.masterDirectory = masterDirectory;
        loadAbilities();
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

    // Metoda pentru incarcarea abilitatilor
    private void loadAbilities() {
        try (FileInputStream fis = new FileInputStream(masterDirectory + "/Lab7.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            boolean firstRow = true;
            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                String cellContent = row.getCell(0).getStringCellValue();
                String[] splitContent = cellContent.split(" ");
                String personId = splitContent[0];
                Person person = new Person(personId, personId);
                Set<String> abilities = new HashSet<>();
                if (splitContent.length > 1) {
                    String[] abilitiesArray = splitContent[1].split(",");
                    for (String ability : abilitiesArray) {
                        abilities.add(ability.trim());
                    }
                }
                if (row.getLastCellNum() > 1) {
                    String[] abilitiesArray = row.getCell(1).getStringCellValue().split(",");
                    for (String ability : abilitiesArray) {
                        abilities.add(ability.trim());
                    }
                }
                personAbilities.put(person, abilities);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda pentru gasirea grupurilor maximale
    public List<Set<Person>> findMaximalGroups() {
        List<Set<Person>> maximalGroups = new ArrayList<>();
        for (Person person : personAbilities.keySet()) {
            boolean added = false;
            for (Set<Person> group : maximalGroups) {
                if (group.stream().allMatch(p -> !Collections.disjoint(personAbilities.get(p), personAbilities.get(person)))) {
                    group.add(person);
                    added = true;
                    break;
                }
            }
            if (!added) {
                Set<Person> newGroup = new HashSet<>();
                newGroup.add(person);
                maximalGroups.add(newGroup);
            }
        }
        return maximalGroups;
    }
}