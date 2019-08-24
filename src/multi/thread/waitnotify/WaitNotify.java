package multi.thread.waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 14:55 2019/7/24
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread notifyThread = new Thread(new Notify(),"notifyThread");
        notifyThread.start();
    }
}
