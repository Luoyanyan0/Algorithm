package virtual.machine;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 13:09 2019/8/9
 */
public class ReferenceCountGC {
    public Object instance = null;

    private static final int _1MB = 1024*1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountGC objA = new ReferenceCountGC();
        ReferenceCountGC objB = new ReferenceCountGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
