package test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 11:56 2019/7/23
 */
public class FinalExample {
    int i;
    final int j;

    static FinalExample obj;

    public FinalExample(){
        i = 1;
        j = 2;
    }

    public static void write(){
        obj = new FinalExample();
    }

    public static void read(){
        FinalExample object = obj;
        int a = object.i;
        System.out.println(a);
        int b = object.j;
        System.out.println(b);
    }

}
