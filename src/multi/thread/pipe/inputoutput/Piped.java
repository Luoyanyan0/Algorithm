package multi.thread.pipe.inputoutput;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 15:27 2019/7/24
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);

        Thread printThread = new Thread(new Print(in),"printThread");
        printThread.start();
        int receive = 0;
        while ((receive = System.in.read()) != -1){
            out.write(receive);
        }
        out.close();
    }

    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while((receive = in.read()) != -1){
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
