package multi.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:59 2019/7/30
 */
public class AtomicIntegerFieldUpdateTest {
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater
            .newUpdater(User.class,"age");

    public static void main(String[] args) {
        User conan = new User("conan",10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

    public static class User{
        private String name;
        public volatile int age;

        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return name;
        }

        public int getAge(){
            return age;
        }
    }
}
