package serverTest.v2;

import java.io.*;
import java.net.Socket;

public class ReaderThread extends Thread {
    private Socket socket;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.setDaemon(true);
        setPriority(MIN_PRIORITY);
        this.start();
    }

    @Override
    public void run() {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line;
            while(true) {
                line = rd.readLine();

                if (line != null) {
                    System.out.println(line);
                }

                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        }
    }
}
