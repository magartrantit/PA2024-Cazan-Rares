package mypackage.compulsory;

//clasa pentru clienti
public class Client {
    //variabile
    private ClientType type;
    private String name;
    private int visitingIntervalStart;
    private int visitingIntervalEnd;


    public Client() {
        //constructor
    }

    //getter si setter
    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinTime() {
        return visitingIntervalStart;
    }

    public void setMinTime(int minTime) {
        this.visitingIntervalStart = minTime;
    }

    public int getMaxTime() {
        return visitingIntervalEnd;
    }

    public void setMaxTime(int maxTime) {
        this.visitingIntervalEnd = maxTime;
    }

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
}
