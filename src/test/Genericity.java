package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanyan.luo
 * @Description:当泛型遇上重载
 * @Date: Created in 15:40 2019/7/2
 */
public class Genericity {

    /*public static void method(List<String> list){
        System.out.println("List<String> list");
    }

    public static void method(List<Integer> list){
        System.out.println("List<Integer> list");
    }*/

    /*public static String method(List<String> list){
        System.out.println("List<String> list");
        return "";
    }

    public static int method(List<Integer> list){
        System.out.println("List<Integer> list");
        return 1;
    }

    public static void main(String[] args) {
        method(new ArrayList<String>());
        method(new ArrayList<Integer>());
    }*/


    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g == (a+b));
        System.out.println(g.equals(a+b));
    }

}
