package structural.proxy;

import java.util.HashSet;
import java.util.Set;

public class ChinnessNetwork implements Net {

    private Set<String> disable;

    private Net internet;

    public ChinnessNetwork(Net internet) {
        this.internet = internet;
        this.disable = new HashSet<>();
        this.disable.add("www.google.com");
        this.disable.add("www.facebook.com");
    }

    @Override
    public void access(String domain) {
        if (disable.contains(domain)) {
            System.out.println("Forbidden：" + domain);
        }
        else {
            internet.access(domain);
        }
    }
}
