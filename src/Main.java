import behavioral.abstractfactory.AndroidFactory;
import behavioral.abstractfactory.IosFactory;
import behavioral.abstractfactory.SystemFactory;
import behavioral.factory.JpgReaderFactory;
import behavioral.factory.ReaderFactory;

public class Main {

    public static void main(String[] args) {
        // Factory Method
        ReaderFactory r = new JpgReaderFactory();
        r.getReader().read();

        // Abstract Factory Method
        SystemFactory systemFactory = new IosFactory();
        systemFactory.createOperationController().control();
        systemFactory.createInterfaceController().display();
        systemFactory = new AndroidFactory();
        systemFactory.createOperationController().control();
        systemFactory.createInterfaceController().display();
    }
}
