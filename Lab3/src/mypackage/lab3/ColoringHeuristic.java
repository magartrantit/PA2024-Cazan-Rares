package mypackage.lab3;

import java.util.Map;

//interfata ColoringHeuristic care coloreaza graful
public interface ColoringHeuristic {
    //metoda care coloreaza graful
    Map<Attraction, Integer> applyColoring(Graph graph);
}