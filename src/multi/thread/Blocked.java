package multi.thread;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:27 2019/7/24
 */
public class Blocked implements Runnable {
    @Override
    public void run() {
        synchronized (Blocked.class){
            while (true){
                SleepUtils.second(100);
            }
        }
    }
}
