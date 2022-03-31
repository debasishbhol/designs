package programms.snakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class User {
    int userId;
    String userName;
    int currentPosition = 0;
}
