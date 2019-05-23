package behavioral.observer;

public class ConcreteSubject extends Subject {
    public void notifyAllObservers() {
        for (Observer observer: list) {
            observer.response();
        }
    }
}
