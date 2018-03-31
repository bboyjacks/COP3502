public class Cow {

    //cut and paste a cow here
    private String body = "        ^__^\n" +
"        (oo)\\_______\n" +
"        (__)\\       )\\/\\\n" +
"            ||----w |\n" +
"            ||     ||\n";

    protected String quoteLine = "    \\\n" +
"     \\\n" +
"      \\";

    public void printBody(String _quote) {
        System.out.println("\n" + _quote);
        System.out.println(quoteLine);
        System.out.println(body);
    }
}

