package behavioral.state;

public class ConcreteStateA extends State {
    public void handle(Context t) {
        System.out.println("Current state: A");
        t.setState(new ConcreteStateB());
    }
}
