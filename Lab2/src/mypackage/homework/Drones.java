package mypackage.homework;

/**
 * Clasa care reprezinta dronele
 */
public class Drones extends Vehicle {
    private int maximumFlightDuration;

    /**
     * Constructor
     *
     * @param maximumFlightDuration durata maxima de zbor
     */
    public Drones(int maximumFlightDuration) {
        this.maximumFlightDuration = maximumFlightDuration;
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
        return totalDemand <= maximumFlightDuration;
    }


    /**
     * Metoda care returneaza durata maxima de zbor
     *
     * @return durata maxima de zbor
     */
    public int getMaximumFlightDuration() {
        return maximumFlightDuration;
    }

    /**
     * Metoda care seteaza durata maxima de zbor
     *
     * @param maximumFlightDuration durata maxima de zbor
     */
    public void setMaximumFlightDuration(int maximumFlightDuration) {
        this.maximumFlightDuration = maximumFlightDuration;
    }
}
