package serverTest.firstVersion;

import java.io.*;
import java.net.Socket;

/**
 * Со стороны клиента нужно создать сокет с адресом для подключения и подключиться. После чего
 * можно будет слать сообщения. Пока что только в пределах одной машины, т.к. используется локальный
 * хост.
 */
public class Client {

    private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);  // обычное подключеие в рамках 1го ПК

        // Создаем ридер и принтер для клиента
        try (
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ) {
            String line;

            // оправляем первое сообщение
            System.out.println("Отправить: ");
            line = rd.readLine();
            writer.println(line);


            while(true) {
                line = serverReader.readLine();
                if (line == null) break;

                System.out.print("Пришло сообщение:\t" + line + "\n");

                System.out.println("Отправить: ");
                line = rd.readLine();
                writer.println(line);
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        } finally {
            rd.close();
        }
    }
}
