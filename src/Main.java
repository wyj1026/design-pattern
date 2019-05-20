import behavioral.factory.JpgReaderFactory;
import behavioral.factory.ReaderFactory;

public class Main {

    public static void main(String[] args) {
        ReaderFactory r = new JpgReaderFactory();
        r.getReader().read();
    }
}
