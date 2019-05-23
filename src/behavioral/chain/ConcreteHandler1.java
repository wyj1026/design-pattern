package behavioral.chain;

public class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(String req) {
        if (req.equals("one")) {
            System.out.println("Handler 1 is handling!");
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
