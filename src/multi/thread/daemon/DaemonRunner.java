package multi.thread.daemon;

import multi.thread.SleepUtils;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 11:03 2019/7/24
 */
public class DaemonRunner implements Runnable {
    @Override
    public void run() {
        try {
            SleepUtils.second(10);
        } finally {
            System.out.println("daemonthread finally run.");
        }
    }
}
