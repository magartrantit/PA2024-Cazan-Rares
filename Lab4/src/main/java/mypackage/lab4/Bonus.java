package mypackage.lab4;

import com.github.javafaker.Faker;
import java.util.*;

public class Bonus {
    private static final int NUM_PERSONS = 5000;
    private static final double EDGE_PROBABILITY = 0.1;

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();

        // Generam persoanele
        List<Driver> drivers = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < NUM_PERSONS; i++) {
            String name = faker.name().fullName();
            String destination = faker.address().fullAddress();

            List<String> destinations = new ArrayList<>();
            for (int j = 0; j < NUM_PERSONS; j++) {
                if (random.nextDouble() < EDGE_PROBABILITY) {
                    destinations.add(faker.address().fullAddress());
                }
            }

            drivers.add(new Driver(name, destination, destinations));
            passengers.add(new Passenger(name, faker.address().fullAddress()));
        }

        // Cream problema
        Problem problem = new Problem(drivers, passengers);

        // Rulam algoritmul de matching
        long startTime = System.currentTimeMillis();
        Map<Driver, Passenger> matching = problem.matchDriversAndPassengers();
        long endTime = System.currentTimeMillis();
        System.out.println("Algoritmul de matching:");
        System.out.println("Numarl de match-uri: " + matching.size());
        System.out.println("Timp de rulare: " + (endTime - startTime) + " ms");

    }
}
