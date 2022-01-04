package torpedo;

import javax.xml.bind.annotation.XmlElement;

public class Coordinate {


    @XmlElement private  int x;
    @XmlElement private  int y;

    public Coordinate(int _x, int _y) {
         this.x = _x;
        this.y = _y;

    }
    public Coordinate (){}

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
