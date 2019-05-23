package behavioral.state;

public class ConcreteStateB extends State {
    public void handle(Context t) {
        System.out.println("Current state: B");
        t.setState(new ConcreteStateA());
    }
}
