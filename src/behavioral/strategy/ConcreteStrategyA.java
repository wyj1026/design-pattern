package behavioral.strategy;

public class ConcreteStrategyA implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("Concrete A is called!");
    }
}
