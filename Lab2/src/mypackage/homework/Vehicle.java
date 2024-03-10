package mypackage.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clasa abstracta Vehicle
 */
public abstract class Vehicle {
    //variabile
    protected String model;
    protected String color;
    protected Depot depot;
    protected Client client;
    protected Client[] clients;
    protected int currentN;
    protected int currentM;
    protected int startM;
    protected int startN;

    //constructor

    /**
     * Constructor
     */
    protected Vehicle() {

    }

    public void addClient(Client client) {
        if (clients == null) {
            clients = new Client[1];
            clients[0] = client;
        } else {
            Client[] newClients = new Client[clients.length + 1];
            System.arraycopy(clients, 0, newClients, 0, clients.length);
            newClients[clients.length] = client;
            clients = newClients;
        }
    }

    public Client[] getClients() {
        return clients;
    }


    public abstract boolean canServe(Client client);


    //getter si setter


    /**
     * Setter pentru poziția M de start a vehiculului
     *
     * @return poziția M de start a vehiculului
     */
    public void setStartM(int startM) {
        this.startM = startM;
    }

    /**
     * Setter pentru poziția N de start a vehiculului
     *
     * @return poziția M de start a vehiculului
     */
    public void setStartN(int startN) {
        this.startN = startN;
    }

    /**
     * Setter pentru poziția M curentă a vehiculului
     *
     * @return poziția M curentă a vehiculului
     */
    public void setCurrentM(int currentM) {
        this.currentM = currentM;
    }

    /**
     * Setter pentru poziția N curentă a vehiculului
     *
     * @param currentN
     */
    public void setCurrentN(int currentN) {
        this.currentN = currentN;
    }

    /**
     * Getter pentru modelul vehiculului
     *
     * @return modelul vehiculului
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter pentru modelul vehiculului
     *
     * @param model modelul vehiculului
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Setter pentru clientul vehiculului
     *
     * @param client clientul vehiculului
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Getter pentru culoarea vehiculului
     *
     * @return culoarea vehiculului
     */


    public String getColor() {
        return color;
    }

    /**
     * Setter pentru depozitul vehiculului
     *
     * @param depot depozitul vehiculului
     */
    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    /**
     * Getter pentru depozitul vehiculului
     *
     * @return depozitul vehiculului
     */
    public Depot getDepot() {
        return depot;
    }

    /**
     * Setter pentru culoarea vehiculului
     *
     * @param color culoarea vehiculului
     */
    public void setColor(String color) {
        this.color = color;
    }

    //metoda toString

    /**
     * Metoda toString
     *
     * @return un string cu informatiile despre vehicul
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    /**
     * Metoda equals
     *
     * @param o obiectul cu care se compara
     * @return true daca obiectele sunt egale, false in caz contrar
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getColor(), vehicle.getColor()) && Objects.equals(getDepot(), vehicle.getDepot());
    }

    /**
     * Metoda hashCode
     *
     * @return hashcode-ul obiectului
     */
    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getColor(), getDepot());
    }
}
