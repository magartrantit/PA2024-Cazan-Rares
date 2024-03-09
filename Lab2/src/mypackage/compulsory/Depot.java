package mypackage.compulsory;

import java.util.ArrayList;
import java.util.List;

//clasa pentru depozite

public class Depot {
    //variabile
    private String name;
    private String location;
    private List<Vehicle> vehicles;

    //constructor
    public Depot() {

        this.vehicles = new ArrayList<>();
    }

    //metoda pentru adaugarea vehiculelor
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    //getter si setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //metoda toString
    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
