package mypackage.lab3;

import java.util.*;

public class Graph {
    //lista de adiacenta a grafului
    private Map<Attraction, List<Attraction>> adjacencyList;

    //constructor
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    //metoda care adauga muchie intre doua noduri
    public void addEdge(Attraction node1, Attraction node2) {
        adjacencyList.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
        adjacencyList.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
    }

    //getter care returneaza lista de adiacenta
    public Map<Attraction, List<Attraction>> getAdjacencyList() {
        return adjacencyList;
    }
}