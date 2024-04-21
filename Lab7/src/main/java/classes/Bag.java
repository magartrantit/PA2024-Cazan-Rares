package classes;

import java.util.*;

public class Bag {
    private final Queue<Pair<Integer, Integer>> tiles;

    public Bag(int n) {
        this.tiles = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                tiles.add(new Pair<>(i, j));
            }
        }
        Collections.shuffle((List<?>) tiles);
    }

    public synchronized Pair<Integer, Integer> extractTile() {
        if (tiles.isEmpty()) {
            return null;
        }
        return tiles.poll();
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }
}