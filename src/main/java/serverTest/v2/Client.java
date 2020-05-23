package serverTest.v2;

import java.io.*;
import java.net.Socket;

/**
 * Тут тоже мало чего изменилось, просто дополнительный поток для чтения и вывода полученной строки
 */

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);

        try (
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))
                ) {
            ReaderThread rt = new ReaderThread(socket);

            String line;
            while(true) {
                line = rd.readLine();
                if (line.equals("exit")) return;
                writer.println(line);
                writer.flush();
            }
        }

    }
}
