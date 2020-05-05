package learningRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test5_SomeHints {
    public static void main(String[] args) {
        String first = "Copy everything from here ?don't copy symbol";
//        String second = "We need to parse this - \"foo:=\\\"quux\\\"; print\" and this as well \"four\"";
        System.out.println(first);
//        System.out.println(second);

        // First
        Pattern pattern = Pattern.compile("(?<=[?]).+"); // ?<=[? any symbols] - that puts the line after "?"
        Matcher matcher = pattern.matcher(first);
        while (matcher.find()) {
            System.out.println("\n" + matcher.group());
        }



    }
}
