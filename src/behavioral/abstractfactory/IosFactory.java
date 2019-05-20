package behavioral.abstractfactory;

public class IosFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new IosOpertionController();
    }

    @Override
    public UiController createInterfaceController() {
        return new IosUiController();
    }
}
