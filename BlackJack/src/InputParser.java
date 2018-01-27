import java.util.Scanner; /**
 * This defines an InputParser
 */
public class InputParser {

    private Scanner mScanner;

    /**
     * This creates a InputParser object
     * @param _Scanner
     */
    public InputParser(Scanner _Scanner) {
        mScanner = _Scanner;
    }

    /**
     * This gets input from user
     * @return Integer
     */
    public Integer getInput() {
        Integer input = -1;
        do {
            System.out.print("Choose an option: ");
            while (!mScanner.hasNextInt()) {
                mScanner.next();
            }
            input = mScanner.nextInt();
            System.out.println();
        } while (input < 1 || input > 4);
        return input;
    }
}
