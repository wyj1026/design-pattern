package creational.builder;

public class BuilderA implements Builder {
    private Production production = new Production();

    @Override
    public void buildPart1() {
        production.setPart1("This is part1 of Lamborghini");
    }

    @Override
    public void buildPart2() {
        production.setPart2("This is part2 of Lamborghini");
    }

    @Override
    public Production build() {
        return production;
    }
}
