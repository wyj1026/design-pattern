import behavioral.chain.ConcreteHandler1;
import behavioral.chain.ConcreteHandler2;
import behavioral.chain.Handler;
import behavioral.command.Command;
import behavioral.command.ConcreteCommand;
import behavioral.command.Invoker;
import behavioral.mediator.*;
import behavioral.observer.ConcreteObserver1;
import behavioral.observer.ConcreteObserver2;
import behavioral.observer.ConcreteSubject;
import behavioral.state.ConcreteStateA;
import behavioral.strategy.ConcreteStrategyA;
import behavioral.strategy.ConcreteStrategyB;
import behavioral.strategy.Context;
import behavioral.template.AbstractClass;
import behavioral.template.ConcreteClass;
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
import structural.adapter.Adapter;
import structural.adapter.Target;
import structural.bridge.AbstractRole;
import structural.bridge.ConcreteImplementorA;
import structural.bridge.Implementor;
import structural.bridge.RoleA;
import structural.composite.Engineer;
import structural.composite.Leader;
import structural.decorator.Component;
import structural.decorator.ConcreteComponent;
import structural.decorator.ConcreteDecorator;
import structural.decorator.Decorator;
import structural.facade.Facade;
import structural.flyweight.FlyweightFactory;
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

        // Adapter
        Target t = new Adapter();
        t.request();

        // Bridge
        Implementor a = new ConcreteImplementorA();
        AbstractRole role = new RoleA(a);
        role.operation();

        // Decorator
        Component c = new ConcreteComponent();
        c.operation();
        Decorator decorator = new ConcreteDecorator(c);
        decorator.operation();

        // Facade
        Facade f = new Facade();
        f.method();

        // Composite
        Leader l1 = new Leader("A");
        Leader l2 = new Leader("B");
        l1.add(l2);
        l2.add(new Engineer("W1"));
        l2.add(new Engineer("W2"));
        l1.display(0);

        // Flyweight
        FlyweightFactory factory = new FlyweightFactory();
        factory.getFlyWeight("a").operation();
        factory.getFlyWeight("b").operation();
        factory.getFlyWeight("a").operation();

        // Template method
        AbstractClass aa = new ConcreteClass();
        aa.templateMethod();

        // Strategy
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.strategyMethod();
        context.setStrategy(new ConcreteStrategyB());
        context.strategyMethod();

        // Command
        Command cmd  = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        invoker.call();

        // Chain
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.setNext(h2);
        h1.handleRequest("one");
        h1.handleRequest("t");
        h1.handleRequest("two");

        // State
        behavioral.state.Context context1 = new behavioral.state.Context();
        context1.setState(new ConcreteStateA());
        context1.handle();
        context1.handle();
        context1.handle();

        // Observer
        ConcreteSubject subject = new ConcreteSubject();
        subject.add(new ConcreteObserver1());
        subject.add(new ConcreteObserver2());
        subject.notifyAllObservers();

        // Mediator
        Mediator mediator = new ConcreteMediator();
        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();
        mediator.register(c1);
        mediator.register(c2);
        c1.send();
        c2.send();
    }
}
