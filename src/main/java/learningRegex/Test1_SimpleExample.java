package learningRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1_SimpleExample {
    public static void main(String[] args) {
        String pat = "ao";
        String text = "My chaos is among every ao people here";

        Pattern patter = Pattern.compile(pat);
        Matcher matcher = patter.matcher(text);

        while (matcher.find()) {
            System.out.printf("I found the matches! Here's it - %s, index  %d - %d%n",
                    matcher.group(), matcher.start(), matcher.end());
        }
    }
}
