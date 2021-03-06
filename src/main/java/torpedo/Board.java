package torpedo;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class Board {
    public Board() {
        this.board = new int[10][10];
    }

    /* 0 - alap állapot
           1 - player 1 hajója
           2 - player 2 hajója
        * */
    public int[][] board;
    @XmlElement private  int playerId;
    @XmlElement private String playerName;
        Boolean boatAdded;
   @XmlElement public ArrayList<Integer>board_;
    public void beforesave() {
        board_=new ArrayList<>(board.length * board.length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                 board_.add(board[i][j]);
            }
        }
    }
    public void afterload() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]=board_.get(i*board.length+j);
            }
        }
    }

    public Board(int _id, String _playerName){
        this.playerId = _id;
        this.playerName = _playerName;
        boatAdded = false;
        this.board = new int[10][10];
        initBoard();
    }

    public void initBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[i].length;j++){
                board[i][j]=0;
            }
        }
    }

    public Boolean getBoatAdded() {
        return this.boatAdded;
    }

    public void setBoatAdded(Boolean boatAdded) {
        this.boatAdded = boatAdded;
    }

    public void printBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[i].length;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void addBoat(Boats boats){
        ArrayList<Coordinate> coordinates = boats.getCoordinates();
        if(checkIndex(coordinates)){
        if(checkPlaceIsEmpty(coordinates)) {
            for (Coordinate coordinate : coordinates) {
                board[coordinate.getX() - 1][coordinate.getY() - 1] = boats.getWhoOwn();
            }
            setBoatAdded(true);
        }
        else{
            System.out.println("Már van itt hajód! Helyezd máshová!");
             }
        }
        else{
            System.out.println("Hibás koordináta, próbáld újra!!");
        }
    }

    public boolean checkPlaceIsEmpty(ArrayList<Coordinate> coordinates){
        for (Coordinate coordinate : coordinates) {
            if(board[coordinate.getX()-1][coordinate.getY()-1] != 0 ){
                return false;
            }
        }
        return true;
    }

    public boolean checkIndex(ArrayList<Coordinate> coordinates){
        for (Coordinate coordinate : coordinates) {
            if(coordinate.getX()-1 < 0 || coordinate.getX() > 10 ){
                return false;
            }
            else if(coordinate.getY()-1 < 0 || coordinate.getY() > 10){
                return false;
            }
        }
        return true;

    }
    public boolean checkHitIndex(int _x, int _y){
        if(_x > 10 || _x <= 0){
            System.out.println("Hibás koordináta, próbáld újra!");
            return false;
        }
        else if(_y > 10 || _y <= 0){
            System.out.println("Hibás koordináta, próbáld újra!");
            return false;
        }
       return true;
    }

    public int getPlace(int _x, int _y){
        return board[_x-1][_y-1];
    }

    public void setHit(int _x, int _y){
        board[_x-1][_y-1] = 8;
    }

    public int[][] getBoard(){
        return this.board;
    }

}
