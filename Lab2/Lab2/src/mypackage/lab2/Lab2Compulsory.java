package mypackage.lab2;

import java.util.ArrayList;
import java.util.List;

public class Lab2Compulsory {

    enum ClientType {REGULAR, PREMIUM}

    //clasa pentru depozite
    public class Depot {
        //variabile
        private String name;
        private String location;
        private List<Vehicle> vehicles;

        //constructor
        public Depot(String name, String location) {
            this.name = name;
            this.location = location;
            this.vehicles = new ArrayList<>();
        }

        //metoda pentru adaugarea vehiculelor
        public void addVehicle(Vehicle vehicle) {
            vehicles.add(vehicle);
        }

        //getter si setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        //metoda toString
        @Override
        public String toString() {
            return "Depot{" +
                    "name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    ", vehicles=" + vehicles +
                    '}';
        }
    }

    //clasa pentru vehicule
    public class Vehicle {
        //variabile
        private String model;
        private String color;
        private List<Client> clients;

        //constructor
        public Vehicle(String model, String color) {
            this.model = model;
            this.color = color;
            this.clients = new ArrayList<>();
        }

        //metoda pentru adaugarea clientilor
        public void addClient(Client client) {
            clients.add(client);
        }

        //getter si setter
        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        //metoda toString
        @Override
        public String toString() {
            return "Vehicle{" +
                    "model='" + model + '\'' +
                    ", color='" + color + '\'' +
                    ", clients=" + clients +
                    '}';
        }
    }

    //clasa pentru clienti
    public class Client {
        //variabile
        private ClientType type;
        private String name;
        private int visitingIntervalStart;
        private int visitingIntervalEnd;

        //constructor
        public Client(ClientType type, String name, int visitingIntervalStart, int visitingIntervalEnd) {
            this.type = type;
            this.name = name;
            this.visitingIntervalStart = visitingIntervalStart;
            this.visitingIntervalEnd = visitingIntervalEnd;
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

    public static void main(String[] args) {


        //crearea obiectelor depozit
        Depot depozit1 = new Lab2Compulsory().new Depot("Depozit 1", "Strada Stefan cel Mare");
        Depot depozit2 = new Lab2Compulsory().new Depot("Depozit 2", "Strada Mihai Viteazu");

        //crearea obiectelor vehicul
        Vehicle vehicul1 = new Lab2Compulsory().new Vehicle("Dacia", "Alb");
        Vehicle vehicul2 = new Lab2Compulsory().new Vehicle("Audi", "Negru");
        Vehicle vehicul3 = new Lab2Compulsory().new Vehicle("BMW", "Gri");

        //crearea obiectelor client
        Client client1 = new Lab2Compulsory().new Client(ClientType.REGULAR, "Ion", 8, 12);
        Client client2 = new Lab2Compulsory().new Client(ClientType.PREMIUM, "Vasile", 10, 14);
        Client client3 = new Lab2Compulsory().new Client(ClientType.REGULAR, "Gheorghe", 9, 13);
        Client client4 = new Lab2Compulsory().new Client(ClientType.PREMIUM, "Mihai", 11, 15);

        //adaugarea vehiculelor in depozite
        depozit1.addVehicle(vehicul1);
        depozit2.addVehicle(vehicul2);
        depozit2.addVehicle(vehicul3);

        //adaugarea clientilor la vehicule
        vehicul1.addClient(client1);
        vehicul2.addClient(client2);
        vehicul2.addClient(client3);
        vehicul3.addClient(client4);

        //afisarea depozitelor
        System.out.println(depozit1);
        System.out.println(depozit2);


    }
}
//Cazan Rares