package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Memory_WriteTextUntillExit { //не работает

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        while (1<2) {
            System.out.print("Введи текст: ");
            String line = rd.readLine();
            if (line.equals("exit")) {
                break;
            } else System.out.println("Зачем ты написал: " + line + "??? (exit для выхода).");
        }
    }
}
