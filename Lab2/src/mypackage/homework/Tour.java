package mypackage.homework;

/**
 * Clasa Tour reprezinta un tur al unui vehicul care viziteaza un set de clienti.
 */
public class Tour {
    private Vehicle vehicle;
    private Client[] clients;
    private Client client;

    /**
     * Constructor
     *
     * @param vehicle vehiculul care face turul
     * @param clients clientii vizitati
     */
    public Tour(Vehicle vehicle, Client[] clients) {
        this.vehicle = vehicle;
        this.clients = clients;
    }

    public Tour(Vehicle vehicle, Client client) {
        this.vehicle = vehicle;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    /**
     * Metoda care returneaza clientii vizitati
     *
     * @return vectorul de clienti
     */
    public Client[] getClients() {
        return clients;
    }

    /**
     * Metoda care returneaza vehiculul
     *
     * @return vehiculul
     */
    public Vehicle getVehicle() {
        return vehicle;
    }
}
