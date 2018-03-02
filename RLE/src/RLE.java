import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class RLE {

    public static int numOfDigits(int num)
    {
        return 0;
    }

    public static char[] toCharArray(int charCount, char strchar)
    {
        return new char[] { 'a', 'b' };
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

    public static void main(String[] args)
    {
        // Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new ByteArrayInputStream("1 2 a 3 45 word 20".getBytes()));
        while(scanner.hasNext())
        {
            if (scanner.hasNextInt())
                System.out.println(scanner.nextInt());
            else
            {
                System.out.println("Error! Invalid input. Please enter an integer from 1-4");
                scanner.next();
            }
        }
    }
}
