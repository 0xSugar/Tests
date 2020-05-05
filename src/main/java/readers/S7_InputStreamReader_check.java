package readers;

import java.io.IOException;
import java.io.InputStreamReader;

public class S7_InputStreamReader_check {
    public static void main(String[] args) throws IOException {
        Character name;
        int check;
        do {
            InputStreamReader isr = new InputStreamReader(System.in);
            name = (char) isr.read();
            System.out.println(name);
            check = (int) name;
        } while (!(check == 10));
    }
}