package programms.snakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int boardSize;
    List<Snake> snakes;
    List<Ladder> ladders;

    public Board() {
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }
}
