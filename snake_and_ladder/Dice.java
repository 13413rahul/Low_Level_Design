package snake_and_ladder;

public class Dice {
    private int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    public int rollDice() {
        return ((int)(Math.random() * (5 * noOfDice))) + 1;
    }

}
