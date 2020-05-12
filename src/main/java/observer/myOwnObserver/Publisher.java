package observer.myOwnObserver;

import java.util.*;

public interface Publisher {
    Map<String, String> getAllNews();

    void newRelease(String title, String text);

    void addSubscribers(Subscriber...subscriber);

    void removeSubscriber(Subscriber subscriber);

    void removeSubscriber(int id);

    void removeSubscribers(Subscriber...subscribers);

    boolean isExistSubscribers(Subscriber...subscribers);

    int getSubscribersNumber();
}
