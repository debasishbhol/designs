package programms.snakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

@AllArgsConstructor
@Builder
public class Game {
    int numOfUsers;
    Board board;
    Queue<User> players;
    Dice dice;

    public String startGame() throws Exception {
        while (true) {
            User currentUser = this.players.poll();
            int diceValue = this.dice.rolDice();
            int updatedPosition = this.updateUserPositionOnBoard(currentUser, diceValue);
            if(updatedPosition == board.boardSize*board.boardSize) {
                return currentUser.userName;
            }
            if(updatedPosition < board.boardSize*board.boardSize) {
                currentUser.currentPosition = updatedPosition;
            }

            this.players.add(currentUser);
            System.out.println(currentUser.userName + " -> " + currentUser.currentPosition);
        }
    }

    private int updateUserPositionOnBoard(User user, int diceValue) {
        // Snake and ladder logic need to implement.
        return user.currentPosition + diceValue;
    }
}
