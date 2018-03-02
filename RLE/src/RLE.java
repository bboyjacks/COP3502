import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class RLE {

    public static int numOfDigits(int num)
    {
        return (int)(Math.log10(num) + 1);
    }

    public static char[] toCharArray(int charCount, char strchar)
    {
        int numArray = numOfDigits(charCount) + 1;
        char[] result = new char[numArray];
        String intString = Integer.toString(charCount);
        for (int i = 0; i < intString.length(); i++)
            result[i] = intString.charAt(i);
        result[numArray - 1] = strchar;

        return result;
    }

    public static int findEncodeLength(String inputString)
    {
        return 0;
    }

    public static int findDecodeLength(String rleString)
    {
        return 0;
    }

    public static char[] decodeRLE(String rleString)
    {
        return new char[]{'a', 'b'};
    }

    public static char[][] encodeRLE(String inputString)
    {
        return new char[][] { {'a', 'b'}, {'a', 'b'}};
    }

    public static void assertM(boolean condition)
    {
        if (condition)
            System.out.println("Assert Passed!");
        else
            System.out.println("Failed!");
    }

    public static void main(String[] args)
    {
        // Scanner scanner = new Scanner(System.in);

        // WORKING INPUT TESTED
        /*
        while(scanner.hasNext())
        {
            if (scanner.hasNextInt())
                System.out.println(scanner.nextInt());
            else
            {
                System.out.println("Error! Invalid input. Please enter an integer from 1-4");
                scanner.next();
            }
        }*/

        assertM(Arrays.equals(toCharArray(100, 'C'),    new char[]{'1', '0', '0', 'C'}));
        assertM(Arrays.equals(toCharArray(9, 'A'),      new char[]{'9', 'A'}));
        assertM(Arrays.equals(toCharArray(10, 'b'),     new char[]{'1', '0', 'b'}));
        assertM(Arrays.equals(toCharArray(50, 'l'),     new char[]{'5', '0', 'l'}));
        assertM(Arrays.equals(toCharArray(2, 'Z'),      new char[]{'2', 'Z'}));

    }
}
