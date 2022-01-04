import org.junit.jupiter.api.Test;
import torpedo.Board;

import static org.junit.jupiter.api.Assertions.assertTrue;
class fivebox
{
@Test
public void Boardnotnull() {
        Board gameBoard = new Board();
        assertTrue(gameBoard.board.length==10);

        }
}