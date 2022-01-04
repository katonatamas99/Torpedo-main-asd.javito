package torpedo;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws IOException {
        startGame();
    }

    public static void startGame() throws IOException {
        System.out.println("TORPEDÓ játék\n");

        ApplicationContext context = new AnnotationConfigApplicationContext("torpedo");

        GameEngine gameEngine = context.getBean(GameEngine.class);
    }


}
