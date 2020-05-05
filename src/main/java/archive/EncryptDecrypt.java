package archive;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Only for English.
 */

public class EncryptDecrypt {
    public static void main(String[] args) throws IOException {
        /*
        Тут реализована передача в аргументах, тип:
        -e fileOne outputFile
        [-e / -d] зашифрировать / расшифрировать
        fileOne - какой файл
        outputFile - результат

        // проверка, что аргументов -3, первым аргуменом [-e или -d] и 2й & 3й аргумент не пустые
        if (args.length != 3 || (!(args[0].equals("-e") || args[0].equals("-d"))
                && args[1] != null && !(args[1].isEmpty())
                && args[2] != null && !(args[2].isEmpty()))) {
            System.out.println("Wrong command");
            return;
        }

        if (args[0].equals("-e")) {
            forBoth(args[1], args[2]);
        } else if (args[0].equals("-d")) {
            forBoth(args[1], args[2]);
        } else {
            System.out.println("Wrong command");
        }

         */ // реализация передачи пути к файлу аргументами при запуске

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файл, который нужно зашифровать или расшифровать:");
        String file = rd.readLine();

        // Парсинг места
        Pattern pat = Pattern.compile("(.+)\\.txt");
        Matcher mat = pat.matcher(file);
        String path = null;
        if (mat.find()) {
            path = mat.group(1);
        }
        System.out.println("Результат появится в тоже же папке с названием имя_res.txt");

        if (path == null || path.isEmpty()) {
            System.out.println("Не определен путь, введите путь к файлу, куда будет сохранен результат:");
            path = rd.readLine();
        }

        forBoth(file, path + "_res.txt");


    }

    private static void forBoth(String input, String output) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));

        while (rd.ready()) {
            wr.write(change((char) rd.read()));
        }

        rd.close();
        wr.close();
    }

    private static char change(char c) {
        if(c == '\u203D') {
            return '\n';
        }
        if(c == '\n') {         // перевод строки
            return '\u203D';
        }
        if(c == 'A') {
            return '\u03B1';
        }
        if(c == 'B') {
            return '\u03AC';
        }
        if(c == 'C') {
            return '\u01E0';
        }
        if(c == 'D') {
            return '\u1EAB';
        }
        if(c == 'E') {
            return '\u03ED';
        }
        if(c == 'F') {
            return '\u099A';
        }
        if(c == 'G') {
            return '\u2693';
        }
        if(c == 'H') {
            return '\u2694';
        }
        if(c == 'I') {
            return '\u269B';
        }
        if(c == 'J') {
            return '\u2623';
        }
        if(c == 'K') {
            return '\u231A';
        }
        if(c == 'L') {
            return '\u231B';
        }
        if(c == 'M') {
            return '\u2690';
        }
        if(c == 'N') {
            return '\u2721';
        }
        if(c == 'O') {
            return '\u269D';
        }
        if(c == 'P') {
            return '\u26B9';
        }
        if(c == 'Q') {
            return '\u2735';
        }
        if(c == 'R') {
            return '\u2749';
        }
        if(c == 'S') {
            return '\u274B';
        }
        if(c == 'T') {
            return '\u273A';
        }
        if(c == 'U') {
            return '\u2739';
        }
        if(c == 'V') {
            return '\u2738';
        }
        if(c == 'W') {
            return '\u2736';
        }
        if(c == 'X') {
            return '\u2326';
        }
        if(c == 'Y') {
            return '\u232B';
        }
        if(c == 'Z') {
            return '\u2327';
        }
        if(c == 'a') {
            return '\u2A0E';
        }
        if(c == 'b') {
            return '\u2A0F';
        }
        if(c == 'c') {
            return '\u2A10';
        }
        if(c == 'd') {
            return '\u2A11';
        }
        if(c == 'e') {
            return '\u2A12';
        }
        if(c == 'f') {
            return '\u2A13';
        }
        if(c == 'g') {
            return '\u2A14';
        }
        if(c == 'h') {
            return '\u2A15';
        }
        if(c == 'i') {
            return '\u2A16';
        }
        if(c == 'j') {
            return '\u2A17';
        }
        if(c == 'k') {
            return '\u2177';
        }
        if(c == 'l') {
            return '\u2178';
        }
        if(c == 'm') {
            return '\u2179';
        }
        if(c == 'n') {
            return '\u217A';
        }
        if(c == 'o') {
            return '\u217B';
        }
        if(c == 'p') {
            return '\u217C';
        }
        if(c == 'q') {
            return '\u217D';
        }
        if(c == 'r') {
            return '\u217E';
        }
        if(c == 's') {
            return '\u217F';
        }
        if(c == 't') {
            return '\u2185';
        }
        if(c == 'u') {
            return '\u2186';
        }
        if(c == 'v') {
            return '\u2657';
        }
        if(c == 'w') {
            return '\u2658';
        }
        if(c == 'x') {
            return '\u24FF';
        }
        if(c == 'y') {
            return '\u2776';
        }
        if(c == 'z') {
            return '\u2777';
        }
        if(c == '!') {
            return '\u2778';
        }
        if(c == '-') {
            return '\u2779';
        }
        if(c == '=') {
            return '\u277A';
        }
        if(c == '_') {
            return '\u277B';
        }
        if(c == '.') {
            return '\u277C';
        }
        if(c == ',') {
            return '\u277D';
        }
        if(c == '?') {
            return '\u277E';
        }
        if(c == '@') {
            return '\u2489';
        }
        if(c == '#') {
            return '\u248A';
        }
        if(c == '$') {
            return '\u248B';
        }
        if(c == '%') {
            return '\u248C';
        }
        if(c == '^') {
            return '\u248D';
        }
        if(c == '&') {
            return '\u248E';
        }
        if(c == '*') {
            return '\u248F';
        }
        if(c == '(') {
            return '\u2490';
        }
        if(c == ')') {
            return '\u2491';
        }
        if(c == '\u0020') {     // пробел
            return '\u212F';
        }
        if(c == '\uE00D') {     // перенос каретки
            return '\u24D0';
        }
        if(c == '\u24D0') {
            return '\uE00D';
        }
        if(c == '\u212F') {
            return '\u0020';
        }
        if (c == '\u03B1') {
            return 'A';
        }
        if (c == '\u03AC') {
            return 'B';
        }
        if (c == '\u01E0') {
            return 'C';
        }
        if (c == '\u1EAB') {
            return 'D';
        }
        if (c == '\u03ED') {
            return 'E';
        }
        if (c == '\u099A') {
            return 'F';
        }
        if (c == '\u2693') {
            return 'G';
        }
        if (c == '\u2694') {
            return 'H';
        }
        if (c == '\u269B') {
            return 'I';
        }
        if (c == '\u2623') {
            return 'J';
        }
        if (c == '\u231A') {
            return 'K';
        }
        if (c == '\u231B') {
            return 'L';
        }
        if (c == '\u2690') {
            return 'M';
        }
        if (c == '\u2721') {
            return 'N';
        }
        if (c == '\u269D') {
            return 'O';
        }
        if (c == '\u26B9') {
            return 'P';
        }
        if (c == '\u2735') {
            return 'Q';
        }
        if (c == '\u2749') {
            return 'R';
        }
        if (c == '\u274B') {
            return 'S';
        }
        if (c == '\u273A') {
            return 'T';
        }
        if (c == '\u2739') {
            return 'U';
        }
        if (c == '\u2738') {
            return 'V';
        }
        if (c == '\u2736') {
            return 'W';
        }
        if (c == '\u2326') {
            return 'X';
        }
        if (c == '\u232B') {
            return 'Y';
        }
        if (c == '\u2327') {
            return 'Z';
        }
        if (c == '\u2A0E') {
            return 'a';
        }
        if (c == '\u2A0F') {
            return 'b';
        }
        if (c == '\u2A10') {
            return 'c';
        }
        if (c == '\u2A11') {
            return 'd';
        }
        if (c == '\u2A12') {
            return 'e';
        }
        if (c == '\u2A13') {
            return 'f';
        }
        if (c == '\u2A14') {
            return 'g';
        }
        if (c == '\u2A15') {
            return 'h';
        }
        if (c == '\u2A16') {
            return 'i';
        }
        if (c == '\u2A17') {
            return 'j';
        }
        if (c == '\u2177') {
            return 'k';
        }
        if (c == '\u2178') {
            return 'l';
        }
        if (c == '\u2179') {
            return 'm';
        }
        if (c == '\u217A') {
            return 'n';
        }
        if (c == '\u217B') {
            return 'o';
        }
        if (c == '\u217C') {
            return 'p';
        }
        if (c == '\u217D') {
            return 'q';
        }
        if (c == '\u217E') {
            return 'r';
        }
        if (c == '\u217F') {
            return 's';
        }
        if (c == '\u2185') {
            return 't';
        }
        if (c == '\u2186') {
            return 'u';
        }
        if (c == '\u2657') {
            return 'v';
        }
        if (c == '\u2658') {
            return 'w';
        }
        if (c == '\u24FF') {
            return 'x';
        }
        if (c == '\u2776') {
            return 'y';
        }
        if (c == '\u2777') {
            return 'z';
        }
        if (c == '\u2778') {
            return '!';
        }
        if (c == '\u2779') {
            return '-';
        }
        if (c == '\u277A') {
            return '=';
        }
        if (c == '\u277B') {
            return '_';
        }
        if (c == '\u277C') {
            return '.';
        }
        if (c == '\u277D') {
            return ',';
        }
        if (c == '\u277E') {
            return '?';
        }
        if (c == '\u2489') {
            return '@';
        }
        if (c == '\u248A') {
            return '#';
        }
        if (c == '\u248B') {
            return '$';
        }
        if (c == '\u248C') {
            return '%';
        }
        if (c == '\u248D') {
            return '^';
        }
        if (c == '\u248E') {
            return '&';
        }
        if (c == '\u248F') {
            return '*';
        }
        if (c == '\u2490') {
            return '(';
        }
        if (c == '\u2491') {
            return ')';
        }
        if (c == '1') {
            return '\uAAF1';
        }
        if (c == '2') {
            return '\u1362';
        }
        if (c == '3') {
            return '\u00A1';
        }
        if (c == '4') {
            return '\u07F9';
        }
        if (c == '5') {
            return '\u1944';
        }
        if (c == '6') {
            return '\u00B7';
        }
        if (c == '7') {
            return '\u2024';
        }
        if (c == '8') {
            return '\u2018';
        }
        if (c == '9') {
            return '\u0022';
        }
        if (c == '0') {
            return '\u1361';
        }
        if (c == '\uAAF1') {
            return '1';
        }
        if (c == '\u1362') {
            return '2';
        }
        if (c == '\u00A1') {
            return '3';
        }
        if (c == '\u07F9') {
            return '4';
        }
        if (c == '\u1944') {
            return '5';
        }
        if (c == '\u00B7') {
            return '6';
        }
        if (c == '\u2024') {
            return '7';
        }
        if (c == '\u2018') {
            return '8';
        }
        if (c == '\u0022') {
            return '9';
        }
        if (c == '\u1361') {
            return '0';
        }
        return c;
    }
}
