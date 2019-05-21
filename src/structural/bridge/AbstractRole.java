package structural.bridge;

public abstract class AbstractRole  {
    private Implementor implementor;

    public AbstractRole(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        this.implementor.OperationImpl();
    }
}
