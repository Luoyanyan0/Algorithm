package test;

import java.util.Arrays;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/4/8 17:38
 * @Description:排序算法
 */
public class Sort {
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1,0,0,0};
        quickSort(arr,0,7);
        for (int a : arr){
            System.out.print(a+"   ");
        }
    }

    public static void quickSort(int arr[],int low,int high){
        if (low < high){
            int pivotpos = Partition(arr,low,high);
            quickSort(arr,low,pivotpos - 1);
            quickSort(arr,pivotpos+1,high);
        }

    }

    public static int Partition(int arr[],int low, int high){
        int pivot = arr[low];
        while (low < high){
            while (low < high && arr[high] >= pivot){
                --high;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot){
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
