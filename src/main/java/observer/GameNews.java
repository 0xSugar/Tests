package observer;

import java.util.Observable;

public class GameNews extends Observable {
    @Override
    public void notifyObservers(Object arg) {
        this.setChanged();
        super.notifyObservers(arg);
    }
}
