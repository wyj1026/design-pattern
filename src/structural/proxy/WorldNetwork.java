package structural.proxy;

public class WorldNetwork implements Net {

    @Override
    public void access(String domain) {
        System.out.println("Access：" + domain);
    }

}