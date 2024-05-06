package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    public Board() {
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        setUpPits();
        setUpStores();
        registerPlayers(null, null);
        initializeBoard();
    }

    public int captureStones(int stoppingPoint) {
        int stonesCaptured = 0;
        int oppositePitIndex = 11 - stoppingPoint;

        if (stoppingPoint >= 0 && stoppingPoint < 6 && pits.get(stoppingPoint).getStoneCount() == 1
                && pits.get(oppositePitIndex).getStoneCount() > 0) {
            stonesCaptured = pits.get(oppositePitIndex).removeStones();
            stonesCaptured += pits.get(stoppingPoint).removeStones();
        }

        return stonesCaptured;
    }

    public int distributeStones(int startingPoint) {
        int stonesAdded = 0;
        int stonesToDistribute = pits.get(startingPoint).removeStones();
        int currentIndex = startingPoint;

        while (stonesToDistribute > 0) {
            currentIndex = (currentIndex + 1) % 14; // 14 pits in total (12 pits + 2 stores)

            // Skip opponent's store
            if ((currentPlayer == playerOne && currentIndex == 13) || (currentPlayer == playerTwo && currentIndex == 6)) {
                continue;
            }

            pits.get(currentIndex).addStone();
            stonesToDistribute--;
            stonesAdded++;

            if (stonesToDistribute == 0) {
                handleLastStone(currentIndex);
            }
        }

        return stonesAdded;
    }

    private void handleLastStone(int lastIndex) {
        // If the last stone lands in the player's store, they get another turn
        if ((currentPlayer == playerOne && lastIndex == 6) || (currentPlayer == playerTwo && lastIndex == 13)) {
            return;
        }

        int lastPitIndex = lastIndex;
        int lastPitStoneCount = pits.get(lastPitIndex).getStoneCount();

        // If the last stone lands in an empty pit on the player's side, capture stones from opposite pit
        if (lastPitStoneCount == 1 && (lastIndex >= 0 && lastIndex <= 5) && pits.get(11 - lastPitIndex).getStoneCount() > 0) {
            int capturedStones = captureStones(lastPitIndex);
            if (currentPlayer == playerOne) {
                stores.get(0).addStones(capturedStones);
            } else {
                stores.get(1).addStones(capturedStones);
            }
        }
    }

    public int getNumStones(int pitNum) {
        if (pitNum >= 0 && pitNum < 14) {
            return pits.get(pitNum).getStoneCount();
        } else {
            throw new PitNotFoundException();
        }
    }

    public ArrayList<Pit> getPits() {
        return new ArrayList<>(pits.subList(0, 14));
    }

    public ArrayList<Store> getStores() {
        return new ArrayList<>(stores);
    }

    public boolean isSideEmpty(int pitNum) {
        int startIndex = (pitNum <= 5) ? 0 : 7;
        int endIndex = (pitNum <= 5) ? 6 : 13;

        for (int i = startIndex; i <= endIndex; i++) {
            if (pits.get(i).getStoneCount() > 0) {
                return false;
            }
        }
        return true;
    }

    public int moveStones(int startPit, Player player) throws InvalidMoveException {
        currentPlayer = player;

        if (startPit >= 0 && startPit < pits.size() && pits.get(startPit).getStoneCount() > 0) {
            int stones = distributeStones(startPit);
            currentPlayer = null; // Reset current player after the move
            return stones;
        } else {
            throw new InvalidMoveException("Invalid move. Please choose a pit with stones.");
        }
    }

    public void registerPlayers(Player one, Player two) {
        if (one != null && two != null) {
            stores.get(0).setOwner(one);
            stores.get(1).setOwner(two);
            playerOne = one;
            playerTwo = two;
        }
    }

    public void resetBoard() {
        initializeBoard();
    }

    public void setUpPits() {
        for (int i = 0; i < 14; i++) {
            Pit pit = new Pit();
            pit.addStones(4);
            pits.add(pit);
        }
    }

    public void initializeBoard() {
        for (Pit pit : pits) {
            pit.removeStones();
            pit.addStones(4);
        }
        for (Store store : stores) {
            store.emptyStore();
        }
    }

    public void setUpStores() {
        stores.add(new Store());
        stores.add(new Store());
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Mancala Board\n");

        for (int i = 0; i < 14; i++) {
            if (i == 6 || i == 13) {
                boardString.append("Store ").append(i - 6).append(": ").append(stores.get(i - 6).getTotalStones()).append(" stones\n");
            } else {
                boardString.append("Pit ").append(i + 1).append(": ").append(pits.get(i).getStoneCount()).append(" stones\n");
            }
        }

        return boardString.toString();
    }
}
