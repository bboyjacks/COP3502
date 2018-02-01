import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Integer mpg = -1;
        Double tankCapacity = -1.0;
        Double tankPercentage = -1.0;

        System.out.print("Enter your car's MPG rating (miles/gallon) as a positive integer: ");
        if (scanner.hasNextInt()){
            mpg = scanner.nextInt();
            if (mpg <= 0)
            {
                System.out.println("ERROR: ONLY POSITIVE INTEGERS ARE ACCEPTED FOR MPG!!!");
                System.exit(0);
            }
        }

        System.out.print("Enter your car's tank capacity (gallons) as a positive decimal number: ");
        if (scanner.hasNextDouble())
        {
            tankCapacity = scanner.nextDouble();
            if (tankCapacity <= 0.0)
            {
                System.out.println("ERROR: ONLY POSITIVE DECIMAL NUMBERS ACCEPTED FOR TANK CAPACITY!!!");
                System.exit(0);
            }
        }

        System.out.print("Enter the percentage of the gas tank that is currently filled (from 0-100%): ");
        if (scanner.hasNextDouble())
        {
            tankPercentage = scanner.nextDouble();
            if (tankPercentage <= 0.00 || tankPercentage >= 100.00)
            {
                System.out.println("ERROR: PERCENTAGE MUST BE A DECIMAL NUMBER IN THE RANGE OF 0-100(INCLUSIVE)!!!");
                System.exit(0);
            }
        }

        Integer rawRange = (int)((double)mpg * tankCapacity * (tankPercentage * 0.01));
        if (rawRange <= 25)
            System.out.println("Attention! Your current estimated range is running low: " + rawRange + " miles left!!!");
        else
            System.out.println("Keep driving! Your current estimated range is: " + rawRange + " miles!");
    }
}
