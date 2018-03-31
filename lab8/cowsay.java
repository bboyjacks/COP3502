import java.util.StringJoiner;

public class cowsay {
  public static void main(String[] args) {

    StringJoiner stringBuilder = new StringJoiner(" ");

    if (args.length > 0)
    {
      if (args[0].equals("-l"))
      {
        System.out.println("Cows available:");
        System.out.println("cow dragon kitty");
      }
      else
      {
        String cowToMake = "cow";
        for (int i = 0; i < args.length; i++)
        {
          if (args[i].equals("-f") && ++i < args.length)
            cowToMake = args[i];
          else
            stringBuilder.add(args[i]);
        }

        String quote = stringBuilder.toString();
        if (cowToMake.equals("cow"))
        {
          Cow cow = new Cow();
          cow.printBody(quote);
        }
        else if (cowToMake.equals("kitty"))
        {
          Kitty kitty = new Kitty();
          kitty.printBody(quote);
        }
        else if (cowToMake.equals("dragon"))
        {
          Dragon dragon = new Dragon();
          dragon.printBody(quote);
        }
        else
        {
          System.out.println("Could not find " + cowToMake + " cow!");
        }
      }
    }
  }
}
