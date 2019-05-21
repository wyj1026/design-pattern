package structural.facade;

public class Facade {
    private SubSystem01 obj1=new SubSystem01();
    private SubSystem02 obj2=new SubSystem02();
    private SubSystem03 obj3=new SubSystem03();

    public void method()
    {
        obj1.method1();
        obj2.method2();
        obj3.method3();
    }

    class SubSystem01
    {
        public  void method1()
        {
            System.out.println("method1!");
        }
    }

    class SubSystem02
    {
        public  void method2()
        {
            System.out.println("method2!");
        }
    }

    class SubSystem03
    {
        public  void method3()
        {
            System.out.println("method3！");
        }
    }
}
