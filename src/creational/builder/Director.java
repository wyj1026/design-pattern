package creational.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }


    public Production construct(){
        builder.buildPart1();
        builder.buildPart2();

        return builder.build();
    }

}