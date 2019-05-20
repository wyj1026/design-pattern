package behavioral.abstractfactory;

public class AndroidFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new AndroidOpertionController();
    }

    @Override
    public UiController createInterfaceController() {
        return new AndroidUiController();
    }
}
