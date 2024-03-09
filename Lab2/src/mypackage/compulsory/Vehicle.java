package mypackage.compulsory;

import java.util.ArrayList;
import java.util.List;

//clasa pentru vehicule
public class Vehicle {
    //variabile
    private String model;
    private String color;
    private List<Client> clients;
    private Depot depot;

    //constructor
    public Vehicle() {
        this.clients = new ArrayList<>();
    }

    //metoda pentru adaugarea clientilor
    public void addClient(Client client) {
        clients.add(client);
    }

    //getter si setter
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //metoda toString
    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", clients=" + clients +
                '}';
    }
}