package test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 14:54 2019/7/23
 */
public class ThreadTest implements Runnable {
    @Override
    public void run() {
        FinalExample.write();
    }
}
