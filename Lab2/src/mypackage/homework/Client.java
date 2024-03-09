package mypackage.homework;

import java.util.Objects;

/**
 * Clasa Client
 */
public class Client {
    //variabile
    private ClientType type;
    private String name;
    private int visitingIntervalStart;
    private int visitingIntervalEnd;

    /**
     * Constructor
     */
    public Client() {
        //nimic deoarece se folosesc settere
    }

    //getter si setter

    /**
     * Getter pentru tipul clientului
     *
     * @return tipul clientului
     */
    public ClientType getType() {
        return type;
    }

    /**
     * Setter pentru tipul clientului
     *
     * @param type tipul clientului
     */
    public void setType(ClientType type) {
        this.type = type;
    }

    /**
     * Getter pentru numele clientului
     *
     * @return numele clientului
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pentru numele clientului
     *
     * @param name numele clientului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pentru timpul minim de vizitare
     *
     * @return timpul minim de vizitare
     */
    public int getMinTime() {
        return visitingIntervalStart;
    }

    /**
     * Setter pentru timpul minim de vizitare
     *
     * @param minTime timpul minim de vizitare
     */
    public void setMinTime(int minTime) {
        this.visitingIntervalStart = minTime;
    }

    /**
     * Getter pentru timpul maxim de vizitare
     *
     * @return timpul maxim de vizitare
     */
    public int getMaxTime() {
        return visitingIntervalEnd;
    }

    /**
     * Setter pentru timpul maxim de vizitare
     *
     * @param maxTime timpul maxim de vizitare
     */
    public void setMaxTime(int maxTime) {
        this.visitingIntervalEnd = maxTime;
    }

    /**
     * Metoda toString
     *
     * @return un string cu informatiile despre client
     */
    //metoda toString
    @Override
    public String toString() {
        return "Client{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", visitingIntervalStart=" + visitingIntervalStart +
                ", visitingIntervalEnd=" + visitingIntervalEnd +
                '}';
    }

    /**
     * Metoda equals
     *
     * @param o obiectul cu care comparam
     * @return true daca obiectele sunt egale, false altfel
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getMinTime() == client.getMinTime() && getMaxTime() == client.getMaxTime() && getType() == client.getType() && Objects.equals(getName(), client.getName());
    }

    /**
     * Metoda hashCode
     *
     * @return hash-ul obiectului
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getName(), getMinTime(), getMaxTime());
    }
}
