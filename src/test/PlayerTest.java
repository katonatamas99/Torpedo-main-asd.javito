
import org.junit.jupiter.api.Test;
import torpedo.Board;
import torpedo.Player;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {


    @Test
    void Elemegplayer() {
        Player player= new Player();
        assertTrue((new Player(" nickname", 1)).getIsAlive());
    }
    @Test
    void Elemegplayer2() {
        Player player2= new Player();
        assertTrue((new Player(" nickname", 2)).getIsAlive());
    }
}