package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Observer> list = new ArrayList<>();

    public void add(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer) {
        list.remove(observer);
    }

    public abstract void notifyAllObservers();
}
