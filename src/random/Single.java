package random;

/**
 * @Author: yanyan.luo
 * @Description: 饿汉式单例模式
 * @Date: Created in 15:23 2019/8/7
 */
public class Single {
    /**
     *  不加static，getInstance中无法调用
      */
    private static Single instance = new Single();

    private Single(){

    }

    public static Single getInstance(){
        return instance;
    }
}
