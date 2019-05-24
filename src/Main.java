import behavioral.chain.ConcreteHandler1;
import behavioral.chain.ConcreteHandler2;
import behavioral.chain.Handler;
import behavioral.command.Command;
import behavioral.command.ConcreteCommand;
import behavioral.command.Invoker;
import behavioral.mediator.*;
import behavioral.memento.Origintor;
import behavioral.memento.Taker;
import behavioral.observer.ConcreteObserver1;
import behavioral.observer.ConcreteObserver2;
import behavioral.observer.ConcreteSubject;
import behavioral.state.ConcreteStateA;
import behavioral.strategy.ConcreteStrategyA;
import behavioral.strategy.ConcreteStrategyB;
import behavioral.strategy.Context;
import behavioral.template.AbstractClass;
import behavioral.template.ConcreteClass;
import behavioral.visitor.*;
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
        /*
        Factory Method
        用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
        在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；
         */
        ReaderFactory r = new JpgReaderFactory();
        r.getReader().read();

        /*
        Abstract Factory Method
        可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
        当增加一个新的产品族时不需要修改原代码，满足开闭原则。
         */
        SystemFactory systemFactory = new IosFactory();
        systemFactory.createOperationController().control();
        systemFactory.createInterfaceController().display();
        systemFactory = new AndroidFactory();
        systemFactory.createOperationController().control();
        systemFactory.createInterfaceController().display();

        /*
        Singleton
        单例类只有一个实例对象；
        该单例对象必须由单例类自行创建；
        单例类对外提供一个访问该单例的全局访问点；
         */
        Singleton.getInstance().sayHi();

        /*
        Builder
        各个具体的建造者相互独立，有利于系统的扩展。
        客户端不必知道产品内部组成的细节，便于控制细节风险。
        */
        Builder builder = new BuilderA();
        Director director = new Director(builder);
        director.construct().print();

        /*
        Prototype
        用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
        原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。
        */
        Prototype p = new Prototype(100);
        try {
            p.clone().print();
        }
        catch (Exception e) {}

        /*
        Proxy
        代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
        代理对象可以扩展目标对象的功能；
        代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度；
        */
        Net net = new ChinnessNetwork(new WorldNetwork());
        net.access("www.google.com");
        net.access("www.abc.com");

        /*
        Adapter
        客户端通过适配器可以透明地调用目标接口。
        复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
        将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
         */
        Target t = new Adapter();
        t.request();

        /*
        Bridge
        由于抽象与实现分离，所以扩展能力强；
        其实现细节对客户透明。
         */
        Implementor a = new ConcreteImplementorA();
        AbstractRole role = new RoleA(a);
        role.operation();


        /*
        Decorator
        采用装饰模式扩展对象的功能比采用继承方式更加灵活。
        可以设计出多个不同的具体装饰类，创造出多个不同行为的组合。
         */
        Component c = new ConcreteComponent();
        c.operation();
        Decorator decorator = new ConcreteDecorator(c);
        decorator.operation();

        /*
        Facade
        降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类。
        对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易。
        降低了大型软件系统中的编译依赖性，简化了系统在不同平台之间的移植过程，因为编译一个子系统不会影响其他的子系统，也不会影响外观对象。
         */
        Facade f = new Facade();
        f.method();

        /*
        Composite
        组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码；
        更容易在组合体内加入新的对象，客户端不会因为加入了新的对象而更改源代码，满足“开闭原则”；
         */
        Leader l1 = new Leader("A");
        Leader l2 = new Leader("B");
        l1.add(l2);
        l2.add(new Engineer("W1"));
        l2.add(new Engineer("W2"));
        l1.display(0);

        /*
        Flyweight
        相同对象只要保存一份，这降低了系统中对象的数量，从而降低了系统中细粒度对象给内存带来的压力。
         */
        FlyweightFactory factory = new FlyweightFactory();
        factory.getFlyWeight("a").operation();
        factory.getFlyWeight("b").operation();
        factory.getFlyWeight("a").operation();

        /*
        Template method
        它封装了不变部分，扩展可变部分。它把认为是不变部分的算法封装到父类中实现，而把可变部分算法由子类继承实现，便于子类继续扩展。
        它在父类中提取了公共的部分代码，便于代码复用。
        部分方法是由子类实现的，因此子类可以通过扩展方式增加相应的功能，符合开闭原则。
         */
        AbstractClass aa = new ConcreteClass();
        aa.templateMethod();

        /*
        Strategy
        多重条件语句不易维护，而使用策略模式可以避免使用多重条件语句。
        策略模式提供了一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，从而避免重复的代码。
        策略模式可以提供相同行为的不同实现，客户可以根据不同时间或空间要求选择不同的。
        策略模式提供了对开闭原则的完美支持，可以在不修改原代码的情况下，灵活增加新算法。
        策略模式把算法的使用放到环境类中，而算法的实现移到具体策略类中，实现了二者的分离。
         */
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.strategyMethod();
        context.setStrategy(new ConcreteStrategyB());
        context.strategyMethod();

        /*
        Command
        降低系统的耦合度。命令模式能将调用操作的对象与实现该操作的对象解耦。
        增加或删除命令非常方便。采用命令模式增加与删除命令不会影响其他类，它满足“开闭原则”，对扩展比较灵活。
        可以实现宏命令。命令模式可以与组合模式结合，将多个命令装配成一个组合命令，即宏命令。
        方便实现 Undo 和 Redo 操作。命令模式可以与后面介绍的备忘录模式结合，实现命令的撤销与恢复。
         */
        Command cmd  = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        invoker.call();

        /*
        Chain
        降低了对象之间的耦合度。该模式使得一个对象无须知道到底是哪一个对象处理其请求以及链的结构，发送者和接收者也无须拥有对方的明确信息。
        增强了系统的可扩展性。可以根据需要增加新的请求处理类，满足开闭原则。
        增强了给对象指派职责的灵活性。当工作流程发生变化，可以动态地改变链内的成员或者调动它们的次序，也可动态地新增或者删除责任。
        责任链简化了对象之间的连接。每个对象只需保持一个指向其后继者的引用，不需保持其他所有处理者的引用，这避免了使用众多的 if 或者 if···else 语句。
        责任分担。每个类只需要处理自己该处理的工作，不该处理的传递给下一个对象完成，明确各类的责任范围，符合类的单一职责原则。
         */
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.setNext(h2);
        h1.handleRequest("one");
        h1.handleRequest("t");
        h1.handleRequest("two");

        /*
        State
        状态模式将与特定状态相关的行为局部化到一个状态中，并且将不同状态的行为分割开来，满足“单一职责原则”。
        减少对象间的相互依赖。将不同的状态引入独立的对象中会使得状态转换变得更加明确，且减少对象间的相互依赖。
        有利于程序的扩展。通过定义新的子类很容易地增加新的状态和转换。
         */
        behavioral.state.Context context1 = new behavioral.state.Context();
        context1.setState(new ConcreteStateA());
        context1.handle();
        context1.handle();
        context1.handle();

        /*
        Observer
        降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。
        目标与观察者之间建立了一套触发机制。
         */
        ConcreteSubject subject = new ConcreteSubject();
        subject.add(new ConcreteObserver1());
        subject.add(new ConcreteObserver2());
        subject.notifyAllObservers();

        /*
        Mediator
        降低了对象之间的耦合性，使得对象易于独立地被复用。
        将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。
         */
        Mediator mediator = new ConcreteMediator();
        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();
        mediator.register(c1);
        mediator.register(c2);
        c1.send();
        c2.send();

        /*
        Visitor
        扩展性好。能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。
        复用性好。可以通过访问者来定义整个对象结构通用的功能，从而提高系统的复用程度。
        灵活性好。访问者模式将数据结构与作用于结构上的操作解耦，使得操作集合可相对自由地演化而不影响系统的数据结构。
        符合单一职责原则。访问者模式把相关的行为封装在一起，构成一个访问者，使每一个访问者的功能都比较单一。
         */
        Structure s = new Structure();
        s.add(new ConcreteElementA());
        s.add(new ConcreteElementB());
        s.accept(new ConcreteVisitorA());
        s.accept(new ConcreteVisitorB());

        /*
        Memento
        提供了一种可以恢复状态的机制。当用户需要时能够比较方便地将数据恢复到某个历史的状态。
        实现了内部状态的封装。除了创建它的发起人之外，其他对象都不能够访问这些状态信息。
        简化了发起人类。发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，并由管理者进行管理，这符合单一职责原则。
         */
        Origintor origintor = new Origintor();
        Taker taker = new Taker();
        origintor.setState("0");
        origintor.print();
        taker.setMemento(origintor.create());
        origintor.setState("1");
        origintor.print();
        origintor.restore(taker.getMemento());
        origintor.print();
    }
}
