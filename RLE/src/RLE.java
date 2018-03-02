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
        char[] rleChars = rleString.toCharArray();

        int index = 0;
        int total = 0;

        StringBuilder num = new StringBuilder();

        while(index < rleChars.length)
        {
            if (Character.isDigit(rleChars[index])) {
                num.append(rleChars[index]);
            }
            else {
                String numStr = num.toString();
                try
                {
                    int numInt = Integer.parseInt(numStr);
                    total += numInt;
                }
                catch (NumberFormatException e)
                {
                    total++;
                }
                num.setLength(0);
            }
            index++;
        }
        return total;
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

        assertM(findDecodeLength("2a2b2c") == 6);
        assertM(findDecodeLength("4b16X8uS") == 29);
        assertM(findDecodeLength("100Y17L") == 117);
        assertM(findDecodeLength("abc") == 3);
        assertM(findDecodeLength("3a3b2c2b3a") == 13);
        assertM(findDecodeLength("") == 0);


    }
}
