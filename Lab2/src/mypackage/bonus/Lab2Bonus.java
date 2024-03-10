package mypackage.bonus;

import mypackage.homework.*;

import java.util.*;

public class Lab2Bonus {

    /**
     * Initializeaza matricea de distante
     *
     * @param distance   matricea de distante
     * @param gridMatrix matricea de grid
     */
    private static void initializeDistanceMatrix(int[][] distance, int[][] gridMatrix) {
        int n = gridMatrix.length;
        int m = gridMatrix[0].length;

        // Initializam cu valoarea maxima toate distantele
        for (int i = 0; i < MAX_NODES; i++) {
            for (int j = 0; j < MAX_NODES; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        // Calculam distantele intre noduri bazate pe matricea de grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currentNode = i * m + j;
                if (gridMatrix[i][j] != 0) {
                    // Dacs exista vecinul actualizam distanta
                    if (i > 0 && gridMatrix[i - 1][j] != 0) {
                        int neighbor = (i - 1) * m + j;
                        distance[currentNode][neighbor] = gridMatrix[i - 1][j];
                        distance[neighbor][currentNode] = gridMatrix[i - 1][j];
                    }
                    if (j > 0 && gridMatrix[i][j - 1] != 0) {
                        int neighbor = i * m + (j - 1);
                        distance[currentNode][neighbor] = gridMatrix[i][j - 1];
                        distance[neighbor][currentNode] = gridMatrix[i][j - 1];
                    }
                }
            }
        }
    }

    /**
     * Variabilele pentru matricea de grid
     */
    private static final int N = 3;
    private static final int M = 4;
    private static final int MAX_NODES = N * M;
    private static Random random = new Random();
    private static final Random random1 = new Random();
    private static final int DEPOTS = random.nextInt(MAX_NODES / 2) + 1;
    private static final int CLIENTS = MAX_NODES - DEPOTS;

    /**
     * Metoda main in care am implementat logicca pentru alocarea clientilor la vehicule
     *
     * @param args argumente
     */
    public static void main(String[] args) {
        // Matricea grid
        int[][] gridMatrix = new int[N][M];

        // 1. Cream o lista de pozitii pentru a le amesteca random
        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                positions.add(new int[]{i, j});
            }
        }

        // 2. Le amestecam
        Collections.shuffle(positions);

        // 3. Alocam primele DEPOTS pozitii pentru depozite si urmatoarele CLIENTS pentru clienti
        List<int[]> depotPositions = positions.subList(0, DEPOTS);
        List<int[]> clientPositions = positions.subList(DEPOTS, DEPOTS + CLIENTS);

        // 4. Setam pozitiile depozitelor si clientilor in matricea de grid
        for (int[] position : depotPositions) {
            gridMatrix[position[0]][position[1]] = -1; // -1 reprezinta un depozit
        }
        for (int[] position : clientPositions) {
            gridMatrix[position[0]][position[1]] = random1.nextInt(10) + 1; // Valoare random pentru clienti care va reprezenta si costul
        }

        List<Depot> depots = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (gridMatrix[i][j] == -1) {
                    //initializarea clientilor si depozitelor
                    Depot depot = new Depot();
                    depot.setId(depots.size() + 1);
                    depot.setPosN(i);
                    depot.setPosM(j);
                    depots.add(depot);

                    //initializarea vehiculelor la aceleasi pozitii de start ca depozitele
                    if (random.nextInt(2) == 0) {
                        vehicle = new Trucks(5);
                    } else {
                        vehicle = new Drones(3);
                    }
                    vehicle.setDepot(depot);
                    vehicle.setModel("Vehicle" + (vehicles.size() + 1));
                    vehicles.add(vehicle);
                    vehicle.setStartN(i);
                    vehicle.setStartM(j);
                    vehicle.setCurrentN(i);
                    vehicle.setCurrentM(j);

                } else if (gridMatrix[i][j] > 0) {
                    // initializarea clientilor
                    Client client = new Client();
                    client.setId(clients.size() + 1);
                    client.setPosN(i);
                    client.setPosM(j);
                    clients.add(client);
                    client.setDemand(gridMatrix[i][j]);
                }
            }

        }

        // Afisam matricea grid
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(gridMatrix[i][j] + " ");
            }
            System.out.println();
        }
        // Numarul de depozite si clienti
        System.out.println("Number of depots: " + DEPOTS);
        System.out.println("Number of clients: " + CLIENTS);

        int[][] distance = new int[MAX_NODES][MAX_NODES];
        initializeDistanceMatrix(distance, gridMatrix);

        /**
         * Aplicam algortimul Floyd-Warshall pentru a calcula distantele minime intre toate nodurile
         */
        for (int k = 0; k < MAX_NODES; k++) {
            for (int i = 0; i < MAX_NODES; i++) {
                for (int j = 0; j < MAX_NODES; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        /**
         * Folosim cel mai scurt drum pentru a aloca clientii la vehicule
         */
        for (Client client : clients) {
            // Initializam variabilele pentru a gasi cel mai bun candidat
            Vehicle bestCandidate = null;
            int minTravelCost = Integer.MAX_VALUE;

            // Iteram peste fiecare vehicul
            for (Vehicle vehiclee : vehicles) {
                // Calculam costul de a calatori de la depozit la client
                int depotIndex = vehiclee.getDepot().getPosN() * M + vehiclee.getDepot().getPosM();
                int clientIndex = client.getPosN() * M + client.getPosM();
                int travelCost = distance[depotIndex][clientIndex];

                // Updatam cel mai bun candidat
                if (travelCost < minTravelCost && vehiclee.canServe(client)) {
                    minTravelCost = travelCost;
                    bestCandidate = vehiclee;
                }
            }

            // Asignam clientul la cel mai bun candidat
            if (bestCandidate != null) {
                bestCandidate.addClient(client);
            } else {
                System.out.println("No suitable vehicle found for client " + client.getId());
            }
        }

        // Afisam vehiculele si clientii alocati
        for (Vehicle vehiclee : vehicles) {
            System.out.println("Vehicle: " + vehiclee.getModel());
            System.out.print("Assigned Clients: ");
            if (vehiclee.getClients() != null) {
                for (Client c : vehiclee.getClients()) {
                    System.out.print(c.getId() + " ");
                }
            } else {
                System.out.print("None");
            }
            System.out.println();
        }

    }


}