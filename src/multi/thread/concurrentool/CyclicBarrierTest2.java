package multi.thread.concurrentool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: yanyan.luo
 * @Description: CyclicBarrier (int parties,Runnable barrierAction)
 * 用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景
 * @Date: Created in 11:22 2019/7/31
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {

        }
        System.out.println(2);
    }

    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
