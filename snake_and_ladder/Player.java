package snake_and_ladder;

public class Player {
    private String playerName;
    private int id;

    public Player(String playerName, int id) {
        this.playerName = playerName;
        id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
