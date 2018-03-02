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

        StringBuilder numBuilder = new StringBuilder();

        while(index < rleChars.length)
        {
            if (Character.isDigit(rleChars[index]))
                numBuilder.append(rleChars[index]);
            else {
                String numStr = numBuilder.toString();
                try
                {
                    int numInt = Integer.parseInt(numStr);
                    total += numInt;
                }
                catch (NumberFormatException nfe)
                {
                    total++;
                }
                numBuilder.setLength(0);
            }
            index++;
        }
        return total;
    }

    public static char[] decodeRLE(String rleString)
    {
        char[] rleChars = rleString.toCharArray();
        char[] result = new char[findDecodeLength(rleString)];
        StringBuilder numBuilder = new StringBuilder();

        int curIndex = 0;
        for (char character :
             rleChars) {
            if (Character.isDigit(character))
                numBuilder.append(character);
            else {
                int curNum = 0;
                try {
                    curNum = Integer.parseInt(numBuilder.toString());
                } catch (NumberFormatException nfe)
                {
                    curNum = 1;
                }
                int limit = curNum + curIndex;
                while(curIndex < limit) {
                    result[curIndex] = character;
                    curIndex++;
                }
                numBuilder.setLength(0);
            }
        }
        return result;
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

        assertM(Arrays.equals(decodeRLE("2A5BC"), new char[] {'A', 'A', 'B', 'B', 'B', 'B', 'B', 'C'}));
        assertM(Arrays.equals(decodeRLE("3L3o3L"), new char[] {'L', 'L', 'L', 'o', 'o', 'o', 'L', 'L', 'L'}));
        assertM(Arrays.equals(decodeRLE(""), new char[] {}));
        assertM(Arrays.equals(decodeRLE("abc"), new char[] {'a', 'b', 'c'}));
    }
}
