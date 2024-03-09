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
    private Depot depot;

    //constructor

    /**
     * Constructor
     */
    protected Vehicle() {

    }


    //getter si setter

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
