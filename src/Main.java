import behavioral.abstractfactory.AndroidFactory;
import behavioral.abstractfactory.IosFactory;
import behavioral.abstractfactory.SystemFactory;
import behavioral.builder.Builder;
import behavioral.builder.BuilderA;
import behavioral.builder.Director;
import behavioral.factory.JpgReaderFactory;
import behavioral.factory.ReaderFactory;
import behavioral.singleton.Singleton;

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

        // Singleton
        Singleton.getInstance().sayHi();

        // Builder
        Builder builder = new BuilderA();
        Director director = new Director(builder);
        director.construct().print();
    }
}
