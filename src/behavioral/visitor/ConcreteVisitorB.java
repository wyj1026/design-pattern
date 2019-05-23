package behavioral.visitor;

public class ConcreteVisitorB implements Visitor
{
    public void visit(Element element)
    {
        System.out.println("Visitor B visit -->" + element.toString());
    }
}
