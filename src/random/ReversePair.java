package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 逆序对
 * @Date: Created in 10:58 2019/7/9
 */
public class ReversePair {
    @Test
    public void test(){
        int[] array = {7,5,6,4};
        System.out.println(InversePairs(array));
    }


    public int InversePairs(int[] array) {
        if(array.length <= 0) {return 0;}
        int copy[] = new int[array.length];
        for(int i = 0 ; i < array.length ; i++) {
            copy[i] = array[i];
        }
        int count = inverseCore(array, copy, 0, array.length - 1)%1000000007;
        return count;
    }

    public int inverseCore(int[] array,int[] copy,int start,int end){
        if(start == end){
            copy[start] = array[start];
            return 0 ;
        }

        int length = (end - start)/2;
        int left = inverseCore(copy, array, start, start + length);
        int right = inverseCore(copy, array, start + length + 1, end);

        //i初始化为前半段的最后一个下标
        int i = start + length ;
        //j初始化为后半段的最后一个下标
        int j = end;
        //记录copy数组的下标
        int indexOfCopy = end;
        //记录逆序对的数量
        int count = 0;
        while(i >= start && j >= start+length+1){
            if(array[i] > array[j]){
                copy[indexOfCopy--] = array[i--];
                count += j - start - length;
                if(count > 1000000007)
                    count = count%1000000007;
            }else{
                copy[indexOfCopy--] = array[j--];
            }
        }
        for(; i >= start;--i)
            copy[indexOfCopy--] = array[i];
        for(; j >= start+length+1;--j)
            copy[indexOfCopy--] = array[j];

        return (left + right + count)%1000000007;
    }
}
