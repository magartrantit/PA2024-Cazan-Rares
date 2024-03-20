package mypackage.lab3;

import java.time.DayOfWeek;
import java.util.*;

public class DSaturHeuristic implements ColoringHeuristic {
    //override la metoda applyColoring

    @Override
    public Map<Attraction, Integer> applyColoring(Graph graph) {
        //mapa de atractii si culori
        Map<Attraction, Integer> colorMap = new HashMap<>();
        //lista de atractii
        List<Attraction> nodes = new ArrayList<>(graph.getNodes());
        //sortarea atractiilor in functie de saturatie
        nodes.sort((node1, node2) -> calculateDSatur(graph, node2, colorMap) - calculateDSatur(graph, node1, colorMap));
        for (Attraction node : nodes) {
            for (int color = 0; color < nodes.size(); color++) {
                if (!hasColorConflict(graph, node, color, colorMap) && node.isOpenOnDay(color)) {
                    colorMap.put(node, color);
                    break;
                }
            }
        }
        return colorMap;
    }

    //metoda care calculeaza saturatia
    private int calculateDSatur(Graph graph, Attraction node, Map<Attraction, Integer> colorMap) {
        Set<Integer> neighborColors = new HashSet<>();
        for (Attraction neighbor : graph.getAdjacencyList().get(node)) {
            neighborColors.add(colorMap.get(neighbor));
        }
        return neighborColors.size();
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