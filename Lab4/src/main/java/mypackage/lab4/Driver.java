package mypackage.lab4;

import java.util.List;

public class Driver extends Person {
    private Passenger passenger;
    private List<String> destinations;


    // Constructor
    public Driver(String name, String destination, List<String> destinations) {
        super(name, destination);
        this.destinations = destinations;
    }

    // Getter pentru destinatie
    @Override
    public String getDestination() {
        return super.getDestination();
    }

    // Getter pentru destinatii
    public List<String> getDestinations() {
        return destinations;
    }

    // Getter pentru nume
    @Override
    public String getName() {
        return super.name;
    }

    // Getter pentru varsta
    @Override
    public int getAge() {
        return super.age;
    }

    // Setter pentru pasaager
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Getter pentru pasager
    public Passenger getPassenger() {
        return passenger;
    }
}
