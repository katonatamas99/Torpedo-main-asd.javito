package torpedo;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GameState{
    public Player playerOne;
    public Player playerTwo;
    public static GameState read() {

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(GameState.class);
            GameState gameState= (GameState) context.createUnmarshaller()
            .unmarshal(new FileReader(".Gamestate.xml"));
            gameState.playerOne.board.afterload();
            gameState.playerTwo.board.afterload();
            gameState.playerOne.hitBoard.afterload();
            gameState.playerTwo.hitBoard.afterload();
            return gameState;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
    public void write(GameState gameState) {
    gameState.playerOne.board.beforesave();
    gameState.playerTwo.board.beforesave();
    gameState.playerOne.hitBoard.beforesave();
    gameState.playerTwo.hitBoard.beforesave();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(GameState.class);
            Marshaller mar= context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(gameState, new File(".GameState.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
