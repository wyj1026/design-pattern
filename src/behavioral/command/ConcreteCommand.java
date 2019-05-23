package behavioral.command;

public class ConcreteCommand implements Command {
    private Recever r = new Recever();

    public void doIt() {
        r.ation();
    }
}
