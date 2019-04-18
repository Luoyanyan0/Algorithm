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

    @Test
    public void countSum(){
        int row = 325;
        int col = 255;
        int countSum = 0;
        while (row > 0){
            countSum += row % 10;
            row = row / 10;
        }
        while (col > 0){
            countSum += col % 10;
            col = col / 10;
        }
        System.out.println(countSum);
    }
}
