package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Player currentPlayer;
    private ArrayList<Player> players;
    private Board board;
    private Player winner;
    private boolean isGameOver;

    public MancalaGame() {
        // Initialize the game with two players and a new board
        players = new ArrayList<>();
        Player playerOne = new Player(1, "Player One");  // Assuming you have a Player class
        Player playerTwo = new Player(2, "Player Two");
        players.add(playerOne);
        players.add(playerTwo);

        board = new Board();
        board.registerPlayers(playerOne, playerTwo);

        // Set the starting player
        currentPlayer = playerOne;

        // Set initial game state
        isGameOver = false;
        winner = null;
    }

    public Board getBoard() {
        // Return the current game board
        return board;
    }

    public Player getCurrentPlayer() {
        // Return the current player
        return currentPlayer;
    }

    public int getNumStones(int pitNum) {
        // Return the number of stones in the specified pit
        return board.getNumStones(pitNum);
    }

    public ArrayList<Player> getPlayers() {
        // Return the list of players
        return players;
    }

    public int getStoreCount(Player player) {
        // Return the stone count in the specified player's store
        return board.getStores().get(player.getId() - 1).getTotalStones();
    }

    public Player getWinner() {
        // Return the winner of the game
        return winner;
    }

    public boolean isGameOver() {
        // Check if the game is over
        return isGameOver;
    }

    public int move(int startPit) {
        // Make a move in the game
        int stonesSown = board.moveStones(startPit, currentPlayer);

        // Check for game over conditions
        if (board.isSideEmpty(currentPlayer.getId()) || board.isSideEmpty(12 - currentPlayer.getId())) {
            endGame();
        } else {
            // Switch to the next player
            currentPlayer = (currentPlayer == players.get(0)) ? players.get(1) : players.get(0);
        }

        return stonesSown;
    }

    private void endGame() {
        // End the game and determine the winner
        isGameOver = true;
        int stonesPlayerOne = getStoreCount(players.get(0));
        int stonesPlayerTwo = getStoreCount(players.get(1));

        if (stonesPlayerOne > stonesPlayerTwo) {
            winner = players.get(0);
        } else if (stonesPlayerTwo > stonesPlayerOne) {
            winner = players.get(1);
        } else {
            // It's a tie
            winner = null;
        }
    }

    public void setBoard(Board theBoard) {
        // Set the game board based on the provided board
        this.board = theBoard;
    }

    public void setCurrentPlayer(Player player) {
        // Set the current player
        this.currentPlayer = player;
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        // Set the players for the game
        players = new ArrayList<>();
        players.add(onePlayer);
        players.add(twoPlayer);
    }

    public void startNewGame() {
        // Start a new game by resetting the board and game state
        board.resetBoard();
        isGameOver = false;
        winner = null;
        currentPlayer = players.get(0); // Start with the first player
    }

    @Override
    public String toString() {
        // Generate a string representation of the game
        return "Mancala Game\n" +
               "Current Player: " + currentPlayer.getName() + "\n" +
               board.toString();
    }
}
