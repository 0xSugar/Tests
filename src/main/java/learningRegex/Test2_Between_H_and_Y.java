package learningRegex;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * All words between h...y
 */

public class Test2_Between_H_and_Y {
    private static ArrayList<String> list = new ArrayList<>(500);      // list to put info from the file
    private static HashSet<String> noCopies = new HashSet<>();
    public static void main(String[] args) throws IOException {
        String path = "/Users/skul/IdeaProjects/Tests/src/com/company/LearningPatterns/MiddleText.txt"; // path to file
        BufferedReader rd = new BufferedReader(new FileReader(path));                                   // reader

        while (rd.ready()) {                                        // read the file
            list.add(rd.readLine());                                // add to ArrayList
        }
        rd.close();                                                 // close stream

        String pat = "\\bh...y\\b";                                 // pattern (\\s - space)
        Pattern patter = Pattern.compile(pat);
        Matcher matcher;

        for (String line : list) {                                  // for every line
            matcher = patter.matcher(line);
            while (matcher.find()) {                                // find matches
                String word = matcher.group();
                if (!noCopies.contains(word)) {                     // if no such file in the noCopies list
                    System.out.println(word);                       // print it and
                    noCopies.add(word);                             // add to list
                }
            }
        }
    }
}
