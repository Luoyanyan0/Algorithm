package test;

/**
 * @Author: yanyan.luo
 * @Description:数组中长度超过一半的数
 * @Date: Created in 11:50 2019/7/2
 */
public class MoreThanHalf {
    public static void main(String[] args) {
        int array[] = {1,2,3,2,2,2,5,2,5};
        System.out.println(moreThanHalf(array));
    }
    public static int moreThanHalf(int array[]){
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++){
            if (times == 0){
                result = array[i];
                times = 1;
            }

            if (array[i] == result){
                times ++;
            }else {
                times --;
            }
        }
        return result;
    }
}
