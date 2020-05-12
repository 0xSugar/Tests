package observer;

import java.util.Observable;
import java.util.Observer;

public class Gamer implements Observer {
    private static long total_players;
    private long id;
    private String name;

    public Gamer(String name) {
        this.name = name;
        id = ++total_players;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this + " получил сообщение - " + arg);
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
