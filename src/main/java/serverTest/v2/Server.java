package serverTest.v2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Логика таже самая, только теперь за вывод будут отвечать не основной блок напрямую, а
 * созданный класс - ReaderThread во втором потоке.
 *
 * Тут будет только один ридер - что бы отправить сообщения с консоли, и один ридер, что бы
 * считать и вывести
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        try (
                Socket client = serverSocket.accept();
                PrintWriter writer = new PrintWriter(client.getOutputStream());
                BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
                ) {
            System.out.println("Подключился " + client.getRemoteSocketAddress().toString());

            ReaderThread rt = new ReaderThread(client); // если есть сообщения - будет считывать и выводить
            // теперь нам остается только печатать то, что хотим

            String line;
            while(true) {
                line = rd.readLine();
                if (line.equals("exit")) break;
                writer.println(line);
                writer.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
