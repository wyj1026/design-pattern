package behavioral.singleton;

public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton (){}

    public static Singleton getInstance() {

        return instance;

    }

    public void sayHi() {
        System.out.println("I'm a singleton!");
    }

}
