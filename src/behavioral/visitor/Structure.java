package behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Structure {
    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        for (Element e: list) {
            e.accept(visitor);
        }
    }

    public void add(Element e) {
        list.add(e);
    }
}
