package designpattern;

import java.util.HashSet;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/30 14:54
 * @Description:单例模式
 */
public class Singleton {
    /**
     * 私有构造函数
     */
    private Singleton(){

    }

    /**
     * 私有静态的实例对象
     */
    private static Singleton instance = new Singleton();

    /**
     * 公有的静态方法，获取实例对象
     * @return
     */
    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet();
        set.add("b");
        set.add("c");
        set.add("a");

        for (String i : set){
            System.out.println(i);
        }
    }
}
