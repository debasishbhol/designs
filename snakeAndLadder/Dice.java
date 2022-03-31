package programms.snakeAndLadder;

import lombok.Builder;

import java.util.Random;

@Builder
public class Dice {
    public int rolDice() {
        // TODO Generate rand num from 1 to 6
        return (int) (Math.random()*(6)+1);
    }
}
