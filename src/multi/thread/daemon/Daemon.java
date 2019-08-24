package multi.thread.daemon;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 11:02 2019/7/24
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
}
