package test;

import org.junit.Test;

public class Test1 {

    synchronized void setA() throws Exception{
        Thread.sleep(1000);
        System.out.println("A");
        setB();
    }

    synchronized void setB() throws Exception{
        Thread.sleep(1000);
        System.out.println("B");
    }

    @Test
    public void test1() {
        try {
            setA();
            setB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
