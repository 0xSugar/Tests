package learningRegex;

import java.io.*;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Imagine we have some URLs file and we need to parse 'breakpoints'.
 * At first we need to pasre all main words and print it.
 * Second - if it has keywords like 'winner' or 'magic' we need to call suitable method
 *
 * URLs for example
 * somesite.com/someway/orsomthelse/andwehere/index.html?utm_name=Dogma&utm_class=Siggr&winner=gaga&magic=3.18
 * what we need to get:
 * utm_name utm_class winner magic
 * Winner is gaga
 * Magic is 3.18
 *
 * Or, URL:
 * somesite.com/index.html?name=hora&list=hoho&age=182&fira=sil
 * name list age fira
 *
 * Let's begin!
 */
public class Test4_LogParser {
    public static void main(String[] args) throws IOException {
        String path = "/Users/skul/IdeaProjects/Tests/src/com/company/LearningPatterns/FileWithURLs.txt";
        BufferedReader rd = new BufferedReader(new FileReader(path));
        HashSet<String> set = new HashSet<>();
        while(rd.ready()) {                             // we can combine adding to set and checking the pattern
            set.add(rd.readLine());                     // but let's do it separate
        }

        /*  First pattern
        [?&]                - start from ? or &
        \\w+     - then goes any letters or numbers, But not & . _ = & ? or # (java stops when sees it)

            Second pattern
        (winner|magic)      - starts with 'winter' or 'magic' (group_1)
        =                   - then goes '='
        ([a-zA-Z.0-9]+)     - then goes any letter/number/point (group_2)
            Explaining -> ^[0-9]+\.{1}[0-9]+$
        ^$                  - matches should be from beginning of the line to the its end, it means
                              match shout full line. ^ - start of the matches, $ - its end
        [0-9]+              - there should be at least one number
        \.{1}               - after there should be Only one point
        [0-9]+              - there should be at least one number
        $                   - end of the match
         */
        Pattern patternOne = Pattern.compile("[?&]([\\w]+)");
        Pattern patternTwo = Pattern.compile("(winner|magic)=([a-zA-Z.0-9]+)");
        Matcher matcher;

        for (String line : set) {                       // for every line (URL)
            System.out.print("Took new URL, found words: ");
            // First round
            matcher = patternOne.matcher(line);
            while(matcher.find()) {
                System.out.print("\"" + matcher.group(1) + "\" ");
            }
            System.out.println();
            // Second round
            matcher = patternTwo.matcher(line);
            while (matcher.find()) {
                String key = matcher.group(1);          // we put get winner or magic word
                String var = matcher.group(2);          // and it's value
                if (var.matches("\\d+")) {             // if there's only numbers
                    callMePlz(key, Integer.parseInt(var));
                } else if (var.matches("^[0-9]+\\.[0-9]+$")) {
                    callMePlz(key, Double.parseDouble(var));
                } else {
                    callMePlz(key, var);
                }
            }
            System.out.println();
        }

    }

    public static void callMePlz (String line, String value) {
        String correctCase = line.substring(0,1).toUpperCase() + line.substring(1);     // change 1st letter to UpperCase (magic -> Magic)
        System.out.printf("%s is %s%n", correctCase, value);
    }
    public static void callMePlz (String line, double numb) {
        String correctCase = line.substring(0,1).toUpperCase() + line.substring(1);
        System.out.printf("%s is %.2f%n", correctCase, numb);
    }
    public static void callMePlz (String line, int numb) {
        String correctCase = line.substring(0,1).toUpperCase() + line.substring(1);
        System.out.printf("%s is %d%n", correctCase, numb);
    }
}
