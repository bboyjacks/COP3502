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
        if (inputString == null)
            return 0;
        else
        {
            int result = 0;
            char prevChar = '1';
            for (int i = 0; i < inputString.length(); i++)
            {
                if (prevChar != inputString.charAt(i))
                {
                    result++;
                    prevChar = inputString.charAt(i);
                }
            }
            return result;
        }
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

        assertM(findEncodeLength(null) == 0);
        assertM(findEncodeLength("aaaBBXXXAA") == 4);
        assertM(findEncodeLength("aaaaaaaaaaaaaaa") == 1);
        assertM(findEncodeLength("abc") == 3);
        assertM(findEncodeLength("aaabbbccbbbaaa") == 5);
        assertM(findEncodeLength("") == 0);


    }
}
