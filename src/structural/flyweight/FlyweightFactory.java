package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap();

    public Flyweight getFlyWeight(String target) {
        Flyweight flyweight = flyweights.get(target);
        if (flyweight == null) {
            Flyweight f = new ConcreteFlyweight(target);
            flyweights.put(target, f);
            return f;
        }
        else {
            return flyweight;
        }
    }
}
