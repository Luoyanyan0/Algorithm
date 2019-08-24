package multi.thread;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:26 2019/7/24
 */
public class TimeWaiting implements Runnable {

    @Override
    public void run() {
        while (true){
            SleepUtils.second(100);
        }
    }
}
