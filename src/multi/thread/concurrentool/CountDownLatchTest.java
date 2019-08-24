package multi.thread.concurrentool;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:59 2019/7/31
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        // 主线程等待，让上面的线程先执行完操作
        c.await();
        System.out.println("3");
    }
}
