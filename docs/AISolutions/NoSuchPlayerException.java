package mancala;
public class NoSuchPlayerException extends RuntimeException {
    private String playerName;

    public NoSuchPlayerException(String playerName) {
        super("Player not found: " + playerName);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
