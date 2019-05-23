package behavioral.observer;

public class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("Observer 1 responsed!");
    }
}
