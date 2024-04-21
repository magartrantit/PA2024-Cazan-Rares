package classes;

import java.util.*;

public class Game {
    private final Bag bag;
    private final List<Player> players = new ArrayList<>();
    private final int n;
    private final Object monitor = new Object();
    private Player currentPlayer;
    private long startTime;

    public Game(int n) {
        this.n = n;
        this.bag = new Bag(n);
    }

    public Bag getBag() {
        return bag;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        startTime = System.currentTimeMillis();
        if (players.isEmpty()) {
            return;
        }
        currentPlayer = players.get(0);
        for (Player player : players) {
            new Thread(player).start();
        }
        Thread timeKeeperThread = new Thread(new TimeKeeper(this, 60000)); // 60 seconds time limit
        timeKeeperThread.setDaemon(true); // Set the timekeeper thread as a daemon thread
        timeKeeperThread.start();
        synchronized (monitor) {
            monitor.notifyAll();
        }
        while (true) {
            synchronized (monitor) {
                if (bag.isEmpty()) {
                    stopGame();
                    break;
                }
                for (Player player : players) {
                    if (player.getScore() == n) {
                        stopGame();
                        break;
                    }
                }
            }
        }
    }

    public void nextTurn() {
        synchronized (monitor) {
            int currentIndex = players.indexOf(currentPlayer);
            int nextIndex = (currentIndex + 1) % players.size();
            currentPlayer = players.get(nextIndex);
            monitor.notifyAll();
        }
    }

    public Object getMonitor() {
        return monitor;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void stopGame() {
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Game running for " + elapsedTime + " milliseconds");
        for (Player player : players) {
            player.stop();
        }
        Player winner = players.stream().max(Comparator.comparing(Player::getScore)).orElse(null);
        if (winner != null) {
            System.out.println(winner.getName() + " has won the game with a score of " + winner.getScore() + "!");
        } else {
            System.out.println("No player has won the game.");
        }
        System.out.println("Game over");
    }
}