package multi.thread.interrupted;

import multi.thread.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 11:20 2019/7/24
 */
public class Interrupted {

    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"BusyRunner");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread:"+sleepThread.isInterrupted());
        System.out.println("busyThread:"+busyThread.isInterrupted());

        SleepUtils.second(2);

    }

}
