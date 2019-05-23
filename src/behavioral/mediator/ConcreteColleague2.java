package behavioral.mediator;

public class ConcreteColleague2 extends Colleague
{
    public void receive()
    {
        System.out.println("Colleague2 received!");
    }
    public void send()
    {
        System.out.println("Colleague2 called!");
        mediator.relay(this);
    }
}
