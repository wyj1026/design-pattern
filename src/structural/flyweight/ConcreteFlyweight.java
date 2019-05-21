package structural.flyweight;

public class ConcreteFlyweight extends Flyweight {
    private String string;

    public ConcreteFlyweight(String str) {
        System.out.println("New Flyweight!");
        string = str;
    }

    public void operation() {
        System.out.println("Concrete---Flyweight : " + string);
    }
}