package programms.snakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Client {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board();
        Queue<User> players = new LinkedList<>();
        Dice dice = Dice.builder().build();
        initBoard(board);
        initPlayers(players);
//        initDice();

        Game game = Game.builder()
                .board(board)
                .players(players)
                .dice(dice)
                .build();

        try {
            String winner = game.startGame();
            System.out.println("Booyah!! " + winner + " won");
        } catch (Exception e) {
            // Some error occurred Hence, game aborted
            // game.abort();
        }

    }

    private static void initPlayers(Queue<User> players) {
        System.out.println("Enter total number of players");
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.print("Enter player name: ");
            String name = sc.next(); // Debasish Bhol
            User user = User.builder()
                    .userName(name)
                    .userId(i)
                    .build();

            players.add(user);
        }
    }

    private static void initBoard(Board board) {
        System.out.print("Enter board size in( m X m ): ");
        board.boardSize = sc.nextInt();

        System.out.println("Enter number of ladders: ");
        int numOfLadders = sc.nextInt();

        for(int i=0;i<numOfLadders;i++) {
            System.out.println("Enter the bottom and top for ladder " + i+1);
            int bottom  = sc.nextInt();
            int top = sc.nextInt();
            Ladder ladder = Ladder.builder().bottom(bottom).top(top).build();
            board.ladders.add(ladder);
        }

        System.out.println("Enter number of snakes: ");
        int numOfSnakes = sc.nextInt();

        for(int i=0;i<numOfSnakes;i++) {
            System.out.println("Enter the tail and mouth of snake " + i+1);
            int tail  = sc.nextInt();
            int mouth = sc.nextInt();
            Snake snake = Snake.builder()
                    .tail(tail)
                    .mouth(mouth)
                    .build();
            board.snakes.add(snake);
        }
    }
}
