package ui;

import mancala.MancalaGame;
import mancala.Player;
import mancala.Board;
import mancala.Pit;
import mancala.Store;
import mancala.InvalidMoveException;
import java.util.Scanner;
import java.util.ArrayList;


public class TextUI {
    private MancalaGame game;
    private Scanner scanner;

    public TextUI() {
        game = new MancalaGame();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Mancala Game is Starting...");// Set up players
        System.out.print("Enter name for Player One: ");
        String playerOneName = scanner.nextLine();
        Player playerOne = new Player(playerOneName);
        System.out.print("Enter name for Player Two: ");
        String playerTwoName = scanner.nextLine();
        Player playerTwo = new Player(playerTwoName);// setting players
        game.setPlayers(playerOne, playerTwo);
        game.startNewGame();//game loop
        while (!game.isGameOver()) {
            System.out.println("Current board:");
            printBoard();
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");
            if(currentPlayer==playerOne){
                System.out.print("Enter the pit number to move stones from(1-6): ");
            }
            if(currentPlayer==playerTwo){
                System.out.print("Enter the pit number to move stones from (7-12): ");
            }
            int startPit;
            try {
                startPit = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid pit number.");
                continue;
            }
            try {
                int stonesMoved = game.getNumStones(startPit-1);
                 game.move(startPit-1);
                System.out.println(currentPlayer.getName() + " moved " + stonesMoved + " stones.");
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
 // Game over print winner information
        System.out.println("Game Over!");
        printBoard();
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println("Player " + winner.getName() + " has won the game!");
        } else {
            System.out.println("It's a tie!");
        }
    }

   

    public void printBoard() {
        Board board = game.getBoard();
        ArrayList<Pit> pits = board.getPits();
        ArrayList<Store> stores = board.getStores();

        // Display Player Two's side
        System.out.print("Player Two's Store ");
       
            System.out.print(stores.get(1).getTotalStones());
        
        System.out.println();

        System.out.println("_____________________________");
        System.out.print("| ");
        for (int i = 11; i >= 6; i--) {
            System.out.print("| " + pits.get(i).getStoneCount() + " ");
        }
        System.out.println("| |");
System.out.print("[" + stores.get(1).getTotalStones()+"]-----------------------["+stores.get(0).getTotalStones()+"]");
        System.out.println();
        System.out.print("| ");
        for (int i = 0; i < 6; i++) {
            System.out.print("| " + pits.get(i).getStoneCount() + " ");
        }
        System.out.println("| |");
        System.out.println("|___________________________|");

        // Display Player One's side
        System.out.print("Player One's Store ");
        System.out.print(stores.get(0).getTotalStones());
        System.out.println();
    }

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.startGame();
    }
}
