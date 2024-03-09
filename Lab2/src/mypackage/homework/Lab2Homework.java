package mypackage.homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Aceasta clasa reprezinta clasa main pentru rezolvarea acestei probleme
 * Contine metoda pentru alocarea clientilor la vehicule folosind un algoritm greedy
 */

public class Lab2Homework {

    /**
     * Metoda pentru alocarea clientilor la vehicule
     *
     * @param problem Problema continand depozitele si clientii
     * @return Soluția care contine tururile alocate
     */

    public static Solution allocateClientsToVehicles(Problem problem) {
        List<Tour> tours = new ArrayList<>();
        Client[] clients = problem.getClients();
        Vehicle[] vehicles = problem.getVehicles();

        // Iteram peste fiecare client
        for (Client client : clients) {
            boolean clientAllocated = false;

            // Iteram peste fiecare vehicul
            for (Vehicle vehicle : vehicles) {
                int timeToClient = getRandomDistance();
                int remainingCapacity = getRemainingCapacity(vehicle);

                // Verificam daca timpul de asteptare este in intervalul de timp al clientului
                if (client.getMinTime() <= timeToClient && client.getMaxTime() >= timeToClient && remainingCapacity >= 1) {
                    // Adaugam clientul la vehicul
                    tours.add(new Tour(vehicle, new Client[]{client}));
                    remainingCapacity--;
                    clientAllocated = true;
                    break;

                }
            }
        }
        return new Solution(tours.toArray(new Tour[0]));
    }

    static Random random = new Random();

    /**
     * Functie pentru a obtine o distanta random
     *
     * @return Distanta random
     */
    private static int getRandomDistance() {

        return random.nextInt(5);
    }

    /**
     * Functie pentru a obtine capacitatea ramasa a unui vehicul
     *
     * @param vehicle Vehiculul pentru care dorim sa obtinem capacitatea ramasa
     * @return Capacitatea ramasa a vehiculului
     */
    private static int getRemainingCapacity(Vehicle vehicle) {
        if (vehicle instanceof Trucks) {
            return ((Trucks) vehicle).getCapacity();
        } else if (vehicle instanceof Drones) {
            return ((Drones) vehicle).getMaximumFlightDuration();
        }
        return 0;
    }

    /**
     * Metoda main pentru a rula algoritmul
     *
     * @param args Argumentele metodei main (nu sunt folosite)
     */
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
        Trucks vehicul1 = new Trucks(5);
        Drones vehicul2 = new Drones(3);
        Drones vehicul3 = new Drones(4);

        //setarea variabilelor vehiculelor
        vehicul1.setColor("Alb");
        vehicul1.setModel("Vehicul1");
        vehicul1.setDepot(depozit1);
        vehicul2.setColor("Negru");
        vehicul2.setModel("Vehicul2");
        vehicul2.setDepot(depozit2);
        vehicul3.setColor("Gri");
        vehicul3.setModel("Vehicul3");
        vehicul3.setDepot(depozit2);

        //crearea obiectelor client
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();

        //setarea variabilelor clientilor
        client1.setName("Ion");
        client1.setMinTime(2);
        client1.setMaxTime(5);
        client1.setType(ClientType.REGULAR);
        client2.setName("Dan");
        client2.setMinTime(1);
        client2.setMaxTime(3);
        client2.setType(ClientType.PREMIUM);
        client3.setName("Ana");
        client3.setMinTime(3);
        client3.setMaxTime(4);
        client3.setType(ClientType.PREMIUM);
        client4.setName("Laur");
        client4.setMinTime(1);
        client4.setMaxTime(2);
        client4.setType(ClientType.REGULAR);

        //adaugarea vehiculelor in depozite
        depozit1.addVehicle(vehicul1);
        depozit2.addVehicle(vehicul2);
        depozit2.addVehicle(vehicul3);

        // Crearea problemei
        Problem problem = new Problem(new Depot[]{depozit1, depozit2}, new Client[]{client1, client2, client3, client4});


        // Alocarea clientilor la vehicule
        Solution solution = allocateClientsToVehicles(problem);

        // Output
        for (Tour tour : solution.getTours()) {
            System.out.println("Vehicul: " + tour.getVehicle().getModel());
            System.out.println("Client alocat:");
            for (Client client : tour.getClients()) {
                System.out.println("- " + client.getName());
            }
            System.out.println();
        }
    }
}
