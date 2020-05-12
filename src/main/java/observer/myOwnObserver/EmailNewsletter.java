package observer.myOwnObserver;

import java.util.*;

public class EmailNewsletter implements Publisher {
    private String newsLetterName;
    private ArrayList<Subscriber> subscribers = new ArrayList<>();
    private Map<String, String> news = new LinkedHashMap<>();

    public EmailNewsletter(String newsLetterName) {
        this.newsLetterName = newsLetterName;
    }

    public EmailNewsletter(String newsLetterName, Subscriber...subscribers) {
        this.newsLetterName = newsLetterName;
        Collections.addAll(this.subscribers, subscribers);
    }

    public String getNewsLetterName() {
        return newsLetterName;
    }
        public Map<String, String> getAllNews() {
        return news;
    }

    public void newRelease(String title, String text) {
        news.put(title, text);
        for (Subscriber subscriber : subscribers) {
            subscriber.notifyMe(newsLetterName, title, text);
        }
    }

    public void addSubscribers(Subscriber...subscribers) {
        Collections.addAll(this.subscribers, subscribers);
    }

    public void removeSubscriber(Subscriber subscriber) {
        removeSubscribers(subscriber);
    }

    public void removeSubscriber(int id) {
        if (id >= subscribers.size())
            throw new NotExistSubscriber();
        subscribers.remove(id);
    }

    public void removeSubscribers(Subscriber...subscribers) {
        if(isExistSubscribers(subscribers)) {
            for (Subscriber subscriber : subscribers) {
                this.subscribers.remove(subscriber);
            }
        } else {
            throw new NotExistSubscriber();
        }
    }

    public boolean isExistSubscriber(Subscriber subscriber) {
        return isExistSubscribers(subscriber);
    }

    public boolean isExistSubscribers(Subscriber...subscribers) {
        for (Subscriber subscriber : subscribers) {
            if (!this.subscribers.contains(subscriber)) // если есть - все ок
                return false;                           // если нет - вернет false
        }
        return true;
    }

    public int getSubscribersNumber() {
        return subscribers.size();
    }
}
