package creational.factory;

public class PngReader implements Reader{
    @Override
    public void read() {
        System.out.print("read png\n");
    }
}
