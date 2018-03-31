public class Kitty extends Cow {

    private String body = "       (\"`-'  '-/\") .___..--' ' \"`-._\n" +
"         ` *_ *  )    `-.   (      ) .`-.__. `)\n" +
"         (_Y_.) ' ._   )   `._` ;  `` -. .-'\n" +
"      _.. `--'_..-_/   /--' _ .' ,4\n" +
"   ( i l ),-''  ( l i),'  ( ( ! .-'\n";

    public void printBody(String _quote) {
        System.out.println("\n" + _quote);
        System.out.println(quoteLine);
        System.out.println(body);
    }
}
