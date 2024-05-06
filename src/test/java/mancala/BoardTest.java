package mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private Player playerOne;
    private Player playerTwo;

    @BeforeEach
    void setUp() {
        board = new Board();
        playerOne = new Player("ME");
        playerTwo = new Player("YOU");
    }

    @Test
    void testCaptureStones() throws PitNotFoundException {
        int stoppingPoint = 5; // Example stopping point
        int capturedStones = board.captureStones(stoppingPoint);
        assertEquals(0, capturedStones); // Initial assumption
    }

    @Test
    void testDistributeStones() throws PitNotFoundException {

        
        board.resetBoard();
        board.registerPlayers(playerOne, playerTwo);
        int startingPoint = 0; // Example starting point
        board.getPits().get(startingPoint).addStone();
        
        int stonesAdded = board.distributeStones(startingPoint);
        assertTrue(stonesAdded > 0);
    }

    @Test
    void testGetNumStones() throws PitNotFoundException {
        int pitNum = 2; // Example pit number
        int numStones = board.getNumStones(pitNum);
        assertEquals(4, numStones); // Initial assumption, update based on your implementation
    }

    @Test
    void testIsSideEmpty() throws PitNotFoundException {
        int pitNum = 2; // Example pit number
        assertFalse(board.isSideEmpty(pitNum)); // Initial assumption, update based on your implementation
    }

    @Test
    void testResetBoard() {
        assertDoesNotThrow(() -> board.resetBoard()); // Initial assumption, update based on your implementation
    }

    @Test
    void testRegisterPlayers() {
        assertDoesNotThrow(() -> board.registerPlayers(playerOne, playerTwo)); // Initial assumption, update based on your implementation
    }
}