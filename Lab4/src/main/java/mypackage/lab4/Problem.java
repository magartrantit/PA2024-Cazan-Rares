package mypackage.lab4;
import org.jgrapht.Graph;
import org.jgrapht.alg.matching.MaximumWeightBipartiteMatching;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem {
    private List<Driver> drivers;
    private List<Passenger> passengers;

    public Problem(List<Driver> drivers, List<Passenger> passengers) {
        this.drivers = drivers;
        this.passengers = passengers;
    }

    public Map<Driver, Passenger> matchDriversAndPassengers() {
        Graph<Person, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Add vertices
        for (Driver driver : drivers) {
            g.addVertex(driver);
        }
        for (Passenger passenger : passengers) {
            g.addVertex(passenger);
        }

        // Add edges
        for (Driver driver : drivers) {
            for (Passenger passenger : passengers) {
                if (driver.getDestinations().contains(passenger.getDestination())) {
                    DefaultWeightedEdge e = g.addEdge(driver, passenger);
                    g.setEdgeWeight(e, 1.0);
                }
            }
        }

        // Create sets for the bipartite graph
        Set<Person> driverSet = new HashSet<>(drivers);
        Set<Person> passengerSet = new HashSet<>(passengers);

        // Compute the maximum weight bipartite matching
        MaximumWeightBipartiteMatching<Person, DefaultWeightedEdge> alg = new MaximumWeightBipartiteMatching<>(g, driverSet, passengerSet);
        return alg.getMatching().getEdges().stream()
                .collect(Collectors.toMap(
                        edge -> (Driver) g.getEdgeSource(edge),
                        edge -> (Passenger) g.getEdgeTarget(edge)
                ));
    }
}