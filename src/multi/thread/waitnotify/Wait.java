package multi.thread.waitnotify;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 14:56 2019/7/24
 */
public class Wait implements Runnable {
    @Override
    public void run() {
        synchronized (WaitNotify.lock) {
            while (WaitNotify.flag){
                System.out.println(Thread.currentThread()+"flag is true. wait @"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    WaitNotify.lock.wait();
                } catch (InterruptedException e) {

                }
            }

            System.out.println(Thread.currentThread()+"flag is false. running @"+
                    new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }
}
