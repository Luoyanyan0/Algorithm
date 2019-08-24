package virtual.machine;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:40 2019/8/8
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length->"+oom.stackLength);
            throw e;
        }
    }
}
