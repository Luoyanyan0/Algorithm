package multi.thread.interrupted;

import multi.thread.SleepUtils;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 11:20 2019/7/24
 */
public class SleepRunner implements Runnable {
    @Override
    public void run() {
        while (true){
            SleepUtils.second(10);
        }
    }
}
