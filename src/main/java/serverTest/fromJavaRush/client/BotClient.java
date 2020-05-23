package serverTest.fromJavaRush.client;

import serverTest.fromJavaRush.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
        for (int i = 0; i < 100; i++) {
            System.out.println(botClient.getUserName());
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message == null) return;

            String[] parts = message.split(": ");
            if (parts.length != 2) {
                return;
            }
//            super.processIncomingMessage(message);
            String name = parts[0];
            String command = parts[1].trim();

            SimpleDateFormat sdf;
            switch (command) {
                case "дата":
                    sdf = new SimpleDateFormat("d.MM.YYYY");
                    break;
                case "день":
                    sdf = new SimpleDateFormat("d");
                    break;
                case "месяц":
                    sdf = new SimpleDateFormat("MMMM");
                    break;
                case "год":
                    sdf = new SimpleDateFormat("YYYY");
                    break;
                case "время":
                    sdf = new SimpleDateFormat("H:mm:s");
                    break;
                case "час":
                    sdf = new SimpleDateFormat("H");
                    break;
                case "минуты":
                    sdf = new SimpleDateFormat("m");
                    break;
                case "секунды":
                    sdf = new SimpleDateFormat("s");
                    break;
                default:
                    return;
            }
            Date date = Calendar.getInstance().getTime();
            sendTextMessage(String.format("Информация для %s: %s", name, sdf.format(date)));
        }
    }
}
