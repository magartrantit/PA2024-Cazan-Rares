package classes;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10); // Initialize game with 10 tokens

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        game.addPlayer(player1);
        game.addPlayer(player2);

        game.play(); // Start the game
    }
}