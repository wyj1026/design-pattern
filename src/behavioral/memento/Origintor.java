package behavioral.memento;

public class Origintor {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento create() {
        return new Memento(state);
    }

    public void restore(Memento m) {
        this.state = m.getState();
    }

    public void print() {
        System.out.println("Current state: " + state);
    }
}
