import java.util.Scanner;

public class Main {

    public static void recursivePrinter(int levels) {
        if (levels == 0)
            return;
        System.out.println("Going down! " + levels);
        recursivePrinter(levels - 1);
        System.out.println("Coming back up! " + levels);
    }

    public static void reversePrint(String str)
    {
        int strLength = str.length();
        if (strLength == 0)
            return;
        System.out.print(str.charAt(strLength - 1));
        reversePrint(str.substring(0, strLength - 1));
    }

    public static int factorial(int num)
    {
        if (num == 0)
            return 1;
        return num * factorial(num - 1);
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the method you want to run: ");
        String inputStr = scanner.nextLine();
        int num = -1;
        switch (inputStr)
        {
            case "recursivePrinter":
                System.out.println("Please enter input for the method: ");
                num = scanner.nextInt();
                recursivePrinter(num);
            case "reversePrint":
                System.out.println("Please enter input for the method: ");
                String str = scanner.nextLine();
                reversePrint(str);
            case "factorial":
                System.out.println("Please enter input for the method: ");
                num = scanner.nextInt();
                System.out.println(factorial(num));
        }
    }
}
