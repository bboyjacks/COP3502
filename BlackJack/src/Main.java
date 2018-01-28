import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Gets the difference between Expected output
     * and MyOutput
     */
    public static void getDiffs() {
        
    }

    /**
     * Test the game with non random cards
     */
    public static void TestGame()  throws Exception {
        // create file
        PrintStream originalOut = System.out;

        FileOutputStream f = new FileOutputStream("MyOutput.txt");
        Player player = new FakeHumanPlayer(new PrintStream(f));
        Player dealer = new FakeBotPlayer();

        ByteArrayInputStream in = new ByteArrayInputStream("1 1".getBytes());
        Game game = new Game(player, dealer, in, new PrintStream(f));
        game.start();

        System.setOut(originalOut);
    }


    public static void main(String[] arg) {
        try {
            TestGame();
        } catch (Exception e) {

        }
    }
}
