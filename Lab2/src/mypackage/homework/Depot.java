package mypackage.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clasa pentru depozite
 */
public class Depot {
    //variabile
    private String name;
    private String location;
    private List<mypackage.homework.Vehicle> vehicles;
    private int id;
    private int posN;
    private int posM;

    //constructor

    /**
     * Constructor
     */
    public Depot() {

        this.vehicles = new ArrayList<>();
    }

    //metoda pentru adaugarea vehiculelor

    /**
     * Metoda pentru adaugarea vehiculelor
     *
     * @param vehicle vehiculul care se adauga
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    //getter si setter

    /**
     * Setter pentru pozitia M a depozitului
     *
     * @return pozitia M a depozitului
     */
    public void setPosM(int posM) {
        this.posM = posM;
    }

    /**
     * Setter pentru pozitia N a depozitului
     *
     * @return pozitia N a depozitului
     */
    public void setPosN(int posN) {
        this.posN = posN;
    }

    /**
     * Getter pentru pozitia M a depozitului
     *
     * @return pozitia M a depozitului
     */
    public int getPosM() {
        return posM;
    }

    /**
     * Getter pentru pozitia N a depozitului
     *
     * @return pozitia N a depozitului
     */
    public int getPosN() {
        return posN;
    }

    /**
     * Getter pentru id-ul depozitului
     *
     * @return id-ul depozitului
     */
    public int getId() {
        return id;
    }

    /**
     * Setter pentru id-ul depozitului
     *
     * @param id id-ul depozitului
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter pentru numele depozitului
     *
     * @return numele depozitului
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pentru numele depozitului
     *
     * @param name numele depozitului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pentru locatia depozitului
     *
     * @return locatia depozitului
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter pentru locatia depozitului
     *
     * @param location locatia depozitului
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter pentru vehiculele depozitului
     *
     * @return vehiculele depozitului
     */
    public Vehicle[] getVehicles() {
        return vehicles.toArray(new Vehicle[0]);
    }

    //metoda toString

    /**
     * Metoda toString
     *
     * @return un string cu informatiile despre depozit
     */
    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", vehicles=" + vehicles +
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
        Depot depot = (Depot) o;
        return Objects.equals(getName(), depot.getName()) && Objects.equals(getLocation(), depot.getLocation()) && Objects.equals(vehicles, depot.vehicles);
    }

    /**
     * Metoda hashCode
     *
     * @return hashcode-ul obiectului
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation(), vehicles);
    }
}
