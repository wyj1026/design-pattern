package behavioral.factory;

public class PngReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new PngReader();
    }
}
