package multi.thread.reentrantlock;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yanyan.luo
 * @Description: 测试观察公平和非公平在获取锁时候的区别
 * @Date: Created in 16:41 2019/7/27
 */
public class FairAndUnfairTest {


    private static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair){
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    @Test
    public void fair() throws Exception{
        testLock(fairLock);
    }

    @Test
    public void unfair() throws Exception{
        testLock(unfairLock);
    }

    public void testLock(Lock lock) throws Exception{
        // 启动5个job
        for (int i = 0; i < 5; i++){
            Thread thread = new Thread(new Job(lock)){
                @Override
                public String toString() {
                    return getName();
                }
            };
            thread.setName(""+i);
            thread.start();
        }
        Thread.sleep(11000);
    }

    private static class Job extends Thread{
        private Lock lock;

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() +":" + ((ReentrantLock2)lock).getQueuedThreads());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public Job(Lock lock){
            this.lock = lock;
        }

    }

}
