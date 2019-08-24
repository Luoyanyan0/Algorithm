package multi.thread.waitnotify;

import multi.thread.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 14:56 2019/7/24
 */
public class Notify implements Runnable{
    @Override
    public void run() {
        synchronized (WaitNotify.lock){
            System.out.println(Thread.currentThread()+"hold lock. notify @"+
                    new SimpleDateFormat("HH:mm:ss").format(new Date()));
            WaitNotify.lock.notifyAll();
            WaitNotify.flag = false;
            SleepUtils.second(5);
        }

        synchronized (WaitNotify.lock){
            System.out.println(Thread.currentThread()+"lock hold again. sleep @"+
                    new SimpleDateFormat("HH:mm:ss").format(new Date()));
            SleepUtils.second(5);
        }
    }
}
