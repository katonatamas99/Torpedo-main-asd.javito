import org.junit.jupiter.api.Test;
import torpedo.GameEngine;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class gameenginetest
{
    @Test
    public void test() throws IOException {
        GameEngine gameengine=new GameEngine();
        gameengine.startGame();
        InputStream stdin= System.in;

        gameengine.initPlayerOne();
        String str = "\nplayer1\n1\n1\n2\n2\nh\n3\n3\nh\n4\n4\nh\n5\n4\n";
        System.setIn(new ByteArrayInputStream(str.getBytes())); //beallitjuk kamu stin-nek a fenti stringet
        String str2 = "player2\n1\n1\n2\n2\nh\n3\n3\nh\n4\n4\nh\n5\n4\n";
        System.setIn(new ByteArrayInputStream(str2.getBytes())); //beallitjuk kamu stin-nek a fenti stringet
        gameengine.initPlayerTwo();
        String str3 = "1\n1\n 1\n1\n 2\n2\n 2\n2\n 2\n3\n 2\n3\n 3\n3\n 3\n3\n 4\n4\n 4\n4\n 4\n5\n 4\n5\n 4\n6\n 4\n6\n 4\n7\n 4\n7\n 5\n4 5\n4\n 5\n5\n 5\n5 \n5\n6\n5\n6\n 5\n7\n 5\n7\n 5\n8\n 5\n1\n";
        System.setIn(new ByteArrayInputStream(str3.getBytes()));
        assertTrue(gameengine.playerOne.checkWin());
        System.setIn(stdin); //visszaallitjuk a nirmal stdin-t, ez fontos*/

    }


}