package multi.thread.selfdefine.condition;

import multi.thread.SleepUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 16:08 2019/7/27
 */
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock = new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run(){
                while (true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i = 0; i < 10; i++){
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
