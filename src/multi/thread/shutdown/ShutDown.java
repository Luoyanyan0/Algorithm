package multi.thread.shutdown;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 14:29 2019/7/24
 */
public class ShutDown {
    public static void main(String[] args) {
        Runner one = new Runner();
        Thread countThread = new Thread(one,"countThread");
        countThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countThread.interrupt();

        Runner two = new Runner();
        Thread countThread2 = new Thread(two,"countThread2");
        countThread2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        two.cancel();
    }
}
