import org.junit.jupiter.api.Test;
import torpedo.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class boardtest {

    @Test
    public void Boardnotnull() {
        Board gameBoard = new Board();
        assertTrue(gameBoard.board.length == 10);

    }

    @Test
    public void sucessAddBoat() {
        Board board = new Board();
        board.addBoat(new OneBoxBoat(1, 1, 1));
        assertTrue(board.getBoatAdded());

    }

    @Test
    public void sucessAddBoat2() {
        Board board = new Board();
        board.addBoat(new OneBoxBoat(1, 1, 2));
        assertTrue(board.getBoatAdded());

    }

    @Test
    public void sucessAddBoat3() {
        Board board = new Board();
        board.addBoat(new TwoBoxBoat(2,2,1,true));
        assertTrue(board.getBoatAdded());

    }
    @Test
    public void sucessAddBoat4() {
        Board board = new Board();
        board.addBoat(new TwoBoxBoat(2,2,2,true));
        assertTrue(board.getBoatAdded());


    }
    @Test
    public void sucessAddBoat5() {
        Board board = new Board();
        board.addBoat(new ThreeBoxBoat(3,3,1,true));
        assertTrue(board.getBoatAdded());


    }
    @Test
    public void sucessAddBoat6() {
        Board board = new Board();
        board.addBoat(new ThreeBoxBoat(3,3,2,true));
        assertTrue(board.getBoatAdded());


    }
    @Test
    public void sucessAddBoat7() {
        Board board = new Board();
        board.addBoat(new FourBoxBoat(4,4,1,true));
        assertTrue(board.getBoatAdded());


    }
    @Test
    public void sucessAddBoat8() {
        Board board = new Board();
        board.addBoat(new FourBoxBoat(4,4,2,true));
        assertTrue(board.getBoatAdded());


    }

    @Test
    public void sucessAddBoat11() {
        Board board = new Board();
        board.addBoat(new FiveBoxBoat(5,4,1,true));
        assertTrue(board.getBoatAdded());


    }
    @Test
    public void sucessAddBoat12() {
        Board board = new Board();
        board.addBoat(new FiveBoxBoat(5,4,2,true));
        assertTrue(board.getBoatAdded());


    }
}