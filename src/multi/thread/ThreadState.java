package multi.thread;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:22 2019/7/24
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"BlockedThread-2").start();
    }
}
