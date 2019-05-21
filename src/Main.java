import creational.abstractfactory.AndroidFactory;
import creational.abstractfactory.IosFactory;
import creational.abstractfactory.SystemFactory;
import creational.builder.Builder;
import creational.builder.BuilderA;
import creational.builder.Director;
import creational.factory.JpgReaderFactory;
import creational.factory.ReaderFactory;
import creational.prototype.Prototype;
import creational.singleton.Singleton;
import structural.proxy.ChinnessNetwork;
import structural.proxy.Net;
import structural.proxy.WorldNetwork;

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

        // Prototype
        Prototype p = new Prototype(100);
        try {
            p.clone().print();
        }
        catch (Exception e) {}

        // Proxy
        Net net = new ChinnessNetwork(new WorldNetwork());
        net.access("www.google.com");
        net.access("www.abc.com");
    }
}
