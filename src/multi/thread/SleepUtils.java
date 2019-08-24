package multi.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:28 2019/7/24
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }
}
