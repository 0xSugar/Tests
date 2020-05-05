package learningRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
    public static void main(String[] args) {
        String line = "cat cats catto cat cat cat.";
        String pat = "\\bcat\\b";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println("|"+matcher.group()+"|");
        }
    }
}
