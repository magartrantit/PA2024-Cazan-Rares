package classes;

import java.util.*;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = true;
    private List<Pair<Integer, Integer>> tiles = new ArrayList<>();
    private List<List<Pair<Integer, Integer>>> sequences = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void run() {
        while (running) {
            synchronized (game.getMonitor()) {
                while (!game.getCurrentPlayer().equals(this)) {
                    try {
                        game.getMonitor().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Pair<Integer, Integer> tile = game.getBag().extractTile();
                if (tile != null) {
                    tiles.add(tile);
                    System.out.println(name + " extracted: " + tile.getFirst() + ", " + tile.getSecond());
                    addTileToSequences(tile);
                }
                game.nextTurn();
            }
        }
    }

    public void stop() {
        running = false;
    }

    private void addTileToSequences(Pair<Integer, Integer> tile) {
        for (List<Pair<Integer, Integer>> sequence : sequences) {
            Pair<Integer, Integer> lastTileInSequence = sequence.get(sequence.size() - 1);
            if (tile.getFirst() == lastTileInSequence.getSecond() + 1) {
                sequence.add(tile);
                return;
            }
        }
        // If the tile doesn't fit into any existing sequence, start a new sequence
        List<Pair<Integer, Integer>> newSequence = new ArrayList<>();
        newSequence.add(tile);
        sequences.add(newSequence);
    }

    public int getScore() {
        List<List<Pair<Integer, Integer>>> sequencesCopy = new ArrayList<>(sequences);
        return sequencesCopy.stream().mapToInt(List::size).max().orElse(0);
    }
}