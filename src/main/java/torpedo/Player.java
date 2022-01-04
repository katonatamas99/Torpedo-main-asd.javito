package torpedo;

import javax.xml.bind.annotation.XmlElement;

public class Player {
    public Player(){}
    @XmlElement private  int id=0;
    @XmlElement public String nickname;
    @XmlElement OneBoxBoat  oneBoxBoat;
    @XmlElement TwoBoxBoat  twoBoxBoat;
    @XmlElement ThreeBoxBoat threeBoxBoat;
    @XmlElement FourBoxBoat  fourBoxBoat;
    @XmlElement FiveBoxBoat fiveBoxBoat;
    @XmlElement public boolean isAlive;
    @XmlElement public int point;
    @XmlElement Board board;
    @XmlElement Board hitBoard;
    public Player(String _nickname,int _id){
        this.nickname = _nickname;
        this.id= _id;
        this.isAlive = true;
        this.point = 0;
        board = new Board(_id, _nickname);
        hitBoard = new Board(_id,_nickname);
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public int getId() {
        return id;
    }
    public Boolean getIsAlive(){
        return isAlive;
    }
    public String getNickname() {
        return nickname;
    }

    public void addPoint() {
        this.point++;
    }

    public int getPoint() {
        return point;
    }

    public boolean checkWin(){
        int[][] tmpBoard = board.getBoard();
        int counter = 0;
        for(int i=0;i< tmpBoard.length;i++){
            for(int j=0;j<tmpBoard[i].length;j++){
                if(tmpBoard[i][j] == 1 || tmpBoard[i][j] == 2){
                    counter++;
                }
             }
        }
        if(counter == 0){
            setAlive(false);
            return true;
        }
        return false;
    }
    public void addHitPointToHitTable(int _x, int _y){
        hitBoard.getBoard()[_x-1][_y-1] = 8;
    }

}
