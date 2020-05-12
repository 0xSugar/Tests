package observer.myOwnObserver;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        EmailNewsletter emailNewsletter = new EmailNewsletter("Новости Мардильчика");
        emailNewsletter.addSubscribers(
                new Subscriber("Krolik"),
                new Subscriber("3ai4ik"),
                new Subscriber("Крокодил"),
                new Subscriber("Pantera")
        );

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Введите заголовок");
            String title = rd.readLine();
            if (title.isEmpty()) break;

            System.out.println("Введите текст");
            String text = rd.readLine();

            emailNewsletter.newRelease(title, text);
        }
        rd.close();
    }
}