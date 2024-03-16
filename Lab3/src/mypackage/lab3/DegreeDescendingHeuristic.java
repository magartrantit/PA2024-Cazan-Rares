package mypackage.lab3;

import java.time.DayOfWeek;
import java.util.*;

public class DegreeDescendingHeuristic implements ColoringHeuristic {
    //override la metoda applyColoring
    @Override
    public Map<Attraction, Integer> applyColoring(Graph graph) {
        //map care contine atractiile si culorile lor
        Map<Attraction, Integer> colorMap = new HashMap<>();
        //lista de atractii
        List<Attraction> nodes = new ArrayList<>(graph.getAdjacencyList().keySet());

        // sortam atractiile in ordinea descrescatoare a gradului
        nodes.sort((node1, node2) -> graph.getAdjacencyList().get(node2).size() - graph.getAdjacencyList().get(node1).size());

        // parcurgem atractiile si le coloram
        for (Attraction node : nodes) {
            int color = 1; // incepem cu culoarea 1
            while (hasColorConflict(graph, node, color, colorMap)) {
                color++;
            }
            colorMap.put(node, color);
        }

        return colorMap;
    }

    //metoda care verifica daca doua atractii pot fi vizitate in aceeasi zi
    private boolean canVisitSameDay(Attraction attraction1, Attraction attraction2) {
        for (DayOfWeek day : DayOfWeek.values()) {
            TimeInterval timeInterval1 = attraction1.getTimeTable().get(day);
            TimeInterval timeInterval2 = attraction2.getTimeTable().get(day);
            if (timeInterval1 != null && timeInterval2 != null) {
                if (timeInterval1.getSecond().isBefore(timeInterval2.getFirst()) || timeInterval2.getSecond().isBefore(timeInterval1.getFirst())) {
                    return true;
                }
            }
        }
        return false;
    }

    //metoda care verifica conflictele de culoare
    private boolean hasColorConflict(Graph graph, Attraction node, int color, Map<Attraction, Integer> colorMap) {
        for (Attraction neighbor : graph.getAdjacencyList().get(node)) {
            if (colorMap.get(neighbor) != null && colorMap.get(neighbor).equals(color)) {
                if (!canVisitSameDay(node, neighbor)) {
                    return true; // true if the neighbor has the same color and the attractions cannot be visited on the same day
                }
            }
        }
        return false;
    }
}