package observer;

import java.util.*;

public class EmailNewsletter {
    private String newsLetter;
    private ArrayList<Subscriber> subscribers = new ArrayList<>();
    private HashMap<String, String> news = new HashMap<>();

    public EmailNewsletter(String newsLetter) {
        this.newsLetter = newsLetter;
    }

    public EmailNewsletter(String newsLetter, Subscriber...subscribers) {
        this.newsLetter = newsLetter;
        Collections.addAll(this.subscribers, subscribers);
    }

    public String getNewsLetter() {
        return newsLetter;
    }


    public void newRelease(String title, String text) {

    }
}
