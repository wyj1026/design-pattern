package behavioral.mediator;

public class ConcreteColleague1 extends Colleague
{
    public void receive()
    {
        System.out.println("Colleague1 received!");
    }
    public void send()
    {
        System.out.println("Colleague1 called!");
        mediator.relay(this);
    }
}
