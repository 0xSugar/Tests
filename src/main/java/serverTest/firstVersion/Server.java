package serverTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Сторона сервера. В чем суть - создать сам сервер, к которому смогут подключаться клиенты. Создаем на
 * порте 8080. После чего создаем Socket - в него мы "вложим" клиента, который будет подключаться к нам.
 * После чего они смогу слать друг другу сообщения. Т.е. проге (этой) нужно 3 потока... первый читает
 * переданную информацию от клиента (ридер), второй читает с клавиатуры и третий принтер, что отправляет
 * написанную строку клиенту.
 */

public class Server {

    private static final BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // создания "сервера" на порте 8080

        try (   // открываем потоки
                // Сокет для клиента.. будет ждать подлючения
                Socket clientSocket = serverSocket.accept();
                // Поток для передачи информации клиенту
                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                // Поток для получения информации ОТ клиента
                BufferedReader messageReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
            System.out.println("Подключение от " + clientSocket.getRemoteSocketAddress().toString());

            String line;

            while(true) {   // считываем строку
                line = messageReader.readLine();
                if (line == null) break;    //

                System.out.print("Пришло сообщение:\t" + line + "\n");

                System.out.print("Ответить: ");
                printWriter.println(rd.readLine());
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        } finally {
            rd.close();
        }
    }
}
