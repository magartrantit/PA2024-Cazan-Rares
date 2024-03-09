package mypackage.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care contine datele problemei
 */
public class Problem {
    private Depot[] depots;
    private Client[] clients;

    /**
     * Constructor
     *
     * @param depots  vectorul de depozite
     * @param clients vectorul de clienti
     */
    public Problem(Depot[] depots, Client[] clients) {
        this.depots = depots;
        this.clients = clients;
    }

    /**
     * Metoda care returneaza vehiculele
     *
     * @return vectorul de vehicule
     */
    public Vehicle[] getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Depot depot : depots) {
            for (Vehicle vehicle : depot.getVehicles()) {
                vehicles.add(vehicle);
            }
        }
        return vehicles.toArray(new Vehicle[0]);
    }

    /**
     * Metoda care returneaza depozitele
     *
     * @return vectorul de depozite
     */
    public Depot[] getDepots() {
        return depots;
    }

    /**
     * Metoda care returneaza clientii
     *
     * @return vectorul de clienti
     */
    public Client[] getClients() {
        return clients;
    }
}
