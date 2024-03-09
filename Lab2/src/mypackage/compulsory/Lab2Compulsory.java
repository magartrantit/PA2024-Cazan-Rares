package mypackage.compulsory;

public class Lab2Compulsory {

    public static void main(String[] args) {


        //crearea obiectelor depozit
        Depot depozit1 = new Depot();
        Depot depozit2 = new Depot();

        //setarea variabilelor depozitelor
        depozit1.setName("Depozit1");
        depozit2.setName("Depozit2");
        depozit1.setLocation("Strada Stefan Cel Mare");
        depozit2.setLocation("Strada Mihai Vizteazu");

        //crearea obiectelor vehicul
        Vehicle vehicul1 = new Vehicle();
        Vehicle vehicul2 = new Vehicle();
        Vehicle vehicul3 = new Vehicle();

        //setarea variabilelor vehiculelor
        vehicul1.setColor("Alb");
        vehicul1.setModel("Dacia");
        vehicul1.setDepot(depozit1);
        vehicul2.setColor("Negru");
        vehicul2.setModel("BMW");
        vehicul2.setDepot(depozit2);
        vehicul3.setColor("Gri");
        vehicul3.setModel("Audi");
        vehicul3.setDepot(depozit2);

        //crearea obiectelor client
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();

        //setarea variabilelor clientilor
        client1.setName("Ion");
        client1.setMinTime(1);
        client1.setMaxTime(2);
        client1.setType(ClientType.REGULAR);
        client2.setName("Dan");
        client2.setMinTime(2);
        client2.setMaxTime(3);
        client2.setType(ClientType.PREMIUM);
        client3.setName("Ana");
        client3.setMinTime(3);
        client3.setMaxTime(4);
        client3.setType(ClientType.PREMIUM);
        client4.setName("Laur");
        client4.setMinTime(4);
        client4.setMaxTime(5);
        client4.setType(ClientType.REGULAR);

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