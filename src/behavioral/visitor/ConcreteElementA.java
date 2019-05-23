package behavioral.visitor;

public class ConcreteElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String toString() {
        return "A";
    }
}
