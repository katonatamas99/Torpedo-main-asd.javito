package torpedo;

import javax.xml.bind.annotation.XmlElement;

public class TwoBoxBoat extends Boats{
    public TwoBoxBoat() {
    }

    @XmlElement int x;
    @XmlElement int y;
    public TwoBoxBoat(int _x, int _y,int _whoOwn, boolean _isVertical){
        this.x = _x;
        this.y  =_y;
        this.setLength(2);
        this.setWhoOwn(_whoOwn);
        this.setVertical(_isVertical);
        this.addCoordinate(_x,_y);
        setCoordinates();
    }
    public void setCoordinates(){
        if(this.getVertical()){
            for(int i=1;i<getLength();i++){
                this.addCoordinate(this.x+i,this.y);
            }//vertical
        }
        else{
            for(int i=1;i<getLength();i++){
                this.addCoordinate(this.x,this.y+i);
            } // horizontal
        }
    }

}
