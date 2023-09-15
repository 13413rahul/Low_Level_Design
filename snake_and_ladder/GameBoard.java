package snake_and_ladder;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> ladders;
    private List<Jumper> snakes;
    private Map<String, Integer> playersCurrentPosition;
    private int boardSize;

    public GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> ladders, List<Jumper> snakes, Map<String, Integer> playersCurrentPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.ladders = ladders;
        this.snakes = snakes;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

    public void startGame() {
        while(nextTurn.size() > 1) {
            Player player = nextTurn.poll();
            int currentPosition = playersCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDice();
            int nextPosition = diceValue + currentPosition;
            if(nextPosition > boardSize) {
                nextTurn.offer(player);
            }else if(nextPosition == boardSize){
                System.out.println(player.getPlayerName() + " won the game");
            }else {
                // check For Snake
                nextPosition = isLadderOrSnake(snakes, nextPosition, Type.SNAKE, player);

                // check For Ladders
                nextPosition = isLadderOrSnake(ladders, nextPosition, Type.LADDER, player);

                if(nextPosition == boardSize) {
                    System.out.println(player.getPlayerName() + " won the game");
                }else {
                    playersCurrentPosition.put(player.getPlayerName(), nextPosition);
                    System.out.println(player.getPlayerName() + " is at position "+ nextPosition);
                    nextTurn.offer(player);
                }
            }
        }
    }

    private int isLadderOrSnake(List<Jumper> laddersOrSnake, int nextCell, Type type, Player player) {
        int[] nextPosition = {nextCell};
        boolean[] b = {false};
        laddersOrSnake.forEach(v-> {
            if(v.getStartPosition() == nextCell) {
                nextPosition[0] = v.getEndPosition();
                b[0]=true;
            } } );

        if(nextCell != nextPosition[0] && b[0]) {
            if(type.equals(Type.SNAKE)) {
                System.out.println(player.getPlayerName() + " Bitten by Snake present at: "+ nextCell);
            }else {
                System.out.println(player.getPlayerName() + " Got ladder present at: " + nextCell);
            }
        }

        return nextPosition[0];
    }
}
