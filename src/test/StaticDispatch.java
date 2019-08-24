package test;

/**
 * @Author: yanyan.luo
 * @Description: 方法静态分派，虚拟机在重载时是通过参数的静态类型而不是实际类型作为判断依据的
 * @Date: Created in 20:17 2019/6/30
 */
public class StaticDispatch {
    static abstract class Human{
    }

    static class Man extends Human{
    }

    static class Woman extends Human{
    }

    public void sayHello(Human guy){
        System.out.println("hello,guy");
    }

    public void sayHello(Man guy){
        System.out.println("hello,gentalman");
    }

    public void sayHello(Woman guy){
        System.out.println("hello,lady");
    }

    public static void main(String[] args) {
        // Human是静态类型，Man和Woman是实际类型
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }

}
