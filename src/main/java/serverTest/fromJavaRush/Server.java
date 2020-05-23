package serverTest.fromJavaRush;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Сделано по инструкции JavaRush
 */

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                entry.getValue().send(message);
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Не получилось отправить сообщение");
        }
    }


    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт: ");
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("Сервер запущен");
        try {
            while (true) {
                Socket newSocket = serverSocket.accept();
                new Handler(newSocket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Произошла ошибка: ");
            e.printStackTrace();
            serverSocket.close();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установленно новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            String name = null;
            try (Connection connection = new Connection(socket)) {
                name = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(connection, name);
                serverMainLoop(connection, name);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным сервером");
            }
            if (name != null) {
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                String name;                                            // чего не сделаешь, раз валидатор не понимает isBlank && strip
                if (message.getType() == MessageType.USER_NAME && (!message.getData().isEmpty() || !message.getData().trim().equals(""))) {
                    name = message.getData();
                    if (!connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message messageToSend = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(messageToSend);
                } else {
                    ConsoleHelper.writeMessage("Ошибка");
                }
            }
        }
    }
}
