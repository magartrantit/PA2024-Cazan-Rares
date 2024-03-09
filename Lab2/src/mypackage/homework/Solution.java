package mypackage.homework;

/**
 * Clasa care reprezinta solutia problemei
 */
public class Solution {
    private Tour[] tours;

    /**
     * Constructor
     *
     * @param tours array-ul de ture
     */
    public Solution(Tour[] tours) {
        this.tours = tours;
    }

    /**
     * Metoda care returneaza turele
     *
     * @return array-ul de ture
     */
    public Tour[] getTours() {
        return tours;
    }

    /**
     * Metoda care seteaza turele
     *
     * @param tours array-ul de ture
     */
    public void setTours(Tour[] tours) {
        this.tours = tours;
    }
}
