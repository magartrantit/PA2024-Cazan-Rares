package mypackage.lab4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Problem {
    private List<Driver> drivers;
    private List<Passenger> passengers;

    public Problem(List<Driver> drivers, List<Passenger> passengers) {
        this.drivers = drivers;
        this.passengers = passengers;
    }

    public Map<Driver, Passenger> matchDriversAndPassengers() {
        return drivers.stream()
                .collect(Collectors.toMap(
                        driver -> driver,
                        driver -> passengers.stream()
                                .filter(passenger -> passenger.getDestination().equals(driver.getDestination()))
                                .findFirst()
                                .orElse(null)
                ));
    }
}