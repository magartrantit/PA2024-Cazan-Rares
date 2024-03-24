package mypackage.lab4;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();
        Faker faker = new Faker();

        // Generam o lista de destinatii comune
        List<String> commonDestinations = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            commonDestinations.add(faker.address().fullAddress());
        }

        // Generam persoane random
        for (int i = 0; i < 10; i++) {
            String name = faker.name().fullName();
            String destination = faker.address().fullAddress();

            List<String> passDestinations = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                    passDestinations.add(commonDestinations.get(j));
            }

            if (random.nextBoolean()) {
                persons.add(new Driver(name, destination, passDestinations));
            } else {
                // Half of the passengers have common destinations
                if (random.nextBoolean()) {
                    persons.add(new Passenger(name, commonDestinations.get(random.nextInt(commonDestinations.size()))));
                } else {
                    persons.add(new Passenger(name, destination));
                }
            }
        }

        // Filtram soferii
        List<Driver> drivers = persons.stream()
                .filter(Driver.class::isInstance)
                .map(Driver.class::cast)
                .collect(Collectors.toList());

        // Setam varsta random pentru soferi
        for (Driver driver : drivers) {
            driver.setAge(random.nextInt(100));
        }

        // Filtram pasagerii
        List<Passenger> passengers = persons.stream()
                .filter(Passenger.class::isInstance)
                .map(Passenger.class::cast)
                .collect(Collectors.toList());

        LinkedList<Driver> driverLinkedList = new LinkedList<>(drivers);

        System.out.println("Soferii:");
        // Sortam soferii dupa varsta
        driverLinkedList.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(driver -> System.out.println("NUME: " + driver.getName() + " VARSTA: " + driver.getAge() + " DESTINATIE: " + driver.getDestination()));

        TreeSet<Passenger> passengerTreeSet = new TreeSet<>(passengers);
        System.out.println("\nPasagerii:");
        // Sortam pasagerii dupa nume
        passengerTreeSet.forEach(passenger -> System.out.println("NUME: " + passenger.getName() + " DESTINATIE: " + passenger.getDestination()));

        // Lista cu destinatiile prin care soferii trec
        List<String> destinations = drivers.stream()
                .map(Driver::getDestination)
                .collect(Collectors.toList());

        // Mapa cu destinatiile si oamenii care vor sa ajunga acolo
        Map<String, List<Person>> destinationMap = Stream.concat(drivers.stream(), passengers.stream())
                .collect(Collectors.groupingBy(Person::getDestination));


        System.out.println("\nMatch-uri:");
        // Asociem soferii cu pasagerii greedy
        for (Driver driver : drivers) {
            for (Iterator<Passenger> iterator = passengers.iterator(); iterator.hasNext();) {
                Passenger passenger = iterator.next();
                if (driver.getDestinations().contains(passenger.getDestination())) {
                    System.out.println("Match found: " + driver.getName() + " - " + passenger.getName());
                    driver.setPassenger(passenger);
                    iterator.remove();
                    break;
                }
            }
        }
    }
}