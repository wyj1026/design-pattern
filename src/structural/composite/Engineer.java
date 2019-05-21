package structural.composite;

public class Engineer extends Employee {

    public Engineer(String name) {
        this.setName(name);
    }

    @Override
    public void display(int index) {
        for(int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("worker：" + this.getName());
    }
}
