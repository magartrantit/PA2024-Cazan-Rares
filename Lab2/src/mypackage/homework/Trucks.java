package mypackage.homework;

/**
 * Clasa care reprezinta camioanele
 */
public class Trucks extends Vehicle {
    private int capacity;

    /**
     * Constructor
     *
     * @param capacity capacitatea camionului
     */
    public Trucks(int capacity) {
        this.capacity = capacity;
    }

    // Inside the Vehicle class

    public boolean canServe(Client client) {
        if (clients == null)
            return true;

        // Check if adding the client will exceed the vehicle's capacity
        int totalDemand = client.getDemand();
        for (Client c : clients) {
            totalDemand += c.getDemand();
        }
        return totalDemand <= capacity;
    }


    /**
     * Metoda care returneaza capacitatea camionului
     *
     * @return capacitatea camionului
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Metoda care seteaza capacitatea camionului
     *
     * @param capacity capacitatea camionului
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
