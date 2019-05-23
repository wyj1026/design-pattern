package behavioral.template;

public abstract class AbstractClass {
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();

    }

    public void specificMethod() {
        System.out.println("Specific method called!");
    }

    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}
