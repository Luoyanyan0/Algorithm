package multi.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yanyan.luo
 * @Description: 演示Lock的使用规则
 * @Date: Created in 10:57 2019/7/26
 */
public class LockExample {
    public void lockExample(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try {

        }finally {
            lock.unlock();
        }
    }
}
