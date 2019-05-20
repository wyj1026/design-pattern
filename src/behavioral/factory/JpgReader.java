package behavioral.factory;

public class JpgReader implements Reader{
    @Override
    public void read() {
        System.out.print("read jpg\n");
    }
}
