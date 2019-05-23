package behavioral.visitor;

public class ConcreteVisitorA implements Visitor
{
    public void visit(Element element)
    {
        System.out.println("Visitor A visit -->" + element.toString());
    }
}
