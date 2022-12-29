package Part2_Ch04._03;

public class TextBlockTest {

    public static void main(String [] args) {

        String textBlocks = """
               Hello,
               hi,
               how r u """;
        System.out.println(textBlocks);
        System.out.println(getBlockOfHtml());
    }

    public static String getBlockOfHtml() {
        return """
               <html>
                    <body>
                        <span>example test</span>
                    </body>
               </html>
                """;
    }

}