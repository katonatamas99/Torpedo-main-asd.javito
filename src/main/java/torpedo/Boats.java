package torpedo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.NONE) public class Boats {
    @XmlElement private Boolean isVertical;
    @XmlElement private int length;
    @XmlElement ArrayList<Coordinate> coordinates;
    @XmlElement private int whoOwn;

    public Boats(){
        length  = 0;
        coordinates  =new ArrayList<>();
    }

    public void setVertical(Boolean vertical) {
        isVertical = vertical;
    }

    public Boolean getVertical() {
        return isVertical;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
    public void addCoordinate(int _x, int _y){
        coordinates.add(new Coordinate(_x,_y));
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public int getWhoOwn() {
        return whoOwn;
    }

    public void setWhoOwn(int whoOwn) {
        this.whoOwn = whoOwn;
    }
}
