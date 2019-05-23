package behavioral.chain;

public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String req) {
        if (req.equals("two")) {
            System.out.println("Handler 2 is handling!");
        }
        else {
            if (getNext() != null) {
                getNext().handleRequest(req);
            }
            else {
                System.out.println("No one is handling!");
            }
        }
    }
}
