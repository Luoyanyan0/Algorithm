package multi.thread.shutdown;

/**
 * @Author: yanyan.luo
 * @Description: 安全的终止线程
 * @Date: Created in 14:27 2019/7/24
 */
public class Runner implements Runnable {
    private long i;
    private volatile boolean on = true;
    @Override
    public void run() {
        while (on && !Thread.currentThread().isInterrupted()){
            i++;
        }
        System.out.println(Thread.currentThread().getName()+"  count i = " + i);
    }

    public void cancel(){
        on = false;
    }
}
