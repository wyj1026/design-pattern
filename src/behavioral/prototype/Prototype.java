package behavioral.prototype;

public class Prototype implements Cloneable {
    private int value;

    public Prototype(int value) {
        this.value = value;
    }

    public void print() {
        System.out.println(value);
    }

    public Prototype clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }
}
