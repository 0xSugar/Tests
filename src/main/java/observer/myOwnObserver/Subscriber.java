package observer.myOwnObserver;

import java.util.Objects;

public class Subscriber implements Notifiable {
    private String name;
    private String email;
    private String phoneNumber;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriber)) return false;
        Subscriber that = (Subscriber) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber);
    }

    @Override
    public void notifyMe(String newsLetter ,String title, String text) {
        if (Math.random() > 0.5) {
            System.out.println("Новость из " + newsLetter + ". " + name + " " + ((Math.random() < 0.5) ? "прочитал" : "прочитала") + " новость. Тема: " + title);
        }
    }
}
