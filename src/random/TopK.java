package random;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 19:15 2019/8/13
 */
public class TopK {

    @Test
    public void RS() {
        int[] arr = {5,3,7,1,8,2,9,4,7,2,6,6};
        int low = 0;
        int high = arr.length - 1;
        int k = 5;
        System.out.println(RS(arr,low,high,k));

    }

    public int RS(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }
        int i = partition(arr,low,high);

        int temp = arr.length - i;
        if (temp > k) {
           return RS(arr,i+1,high,k);
        } else if (temp < k){
           return RS(arr,low,i-1,k);
        } else {
            for (int m = i; m < arr.length; m++) {
                System.out.print(arr[m]+" ");
            }
            return 0;
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && pivot <= arr[high]) {
                high --;
            }
            arr[low] = arr[high];

            while (low < high && pivot >= arr[low]) {
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
