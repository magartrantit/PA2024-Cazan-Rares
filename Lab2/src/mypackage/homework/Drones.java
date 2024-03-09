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
