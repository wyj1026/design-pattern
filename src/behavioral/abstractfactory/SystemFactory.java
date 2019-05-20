package behavioral.abstractfactory;

public interface SystemFactory {
    public OperationController createOperationController();
    public UiController createInterfaceController();
}
