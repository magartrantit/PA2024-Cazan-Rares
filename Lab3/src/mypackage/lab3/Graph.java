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

    //metoda care returneaza nodul
    public Set<Attraction> getNodes() {
        return adjacencyList.keySet();
    }

    //metoda care returneaza gradul unui nod
    public int getDegree(Attraction node) {
        return adjacencyList.get(node).size();
    }

    //getter care returneaza lista de adiacenta
    public Map<Attraction, List<Attraction>> getAdjacencyList() {
        return adjacencyList;
    }
}