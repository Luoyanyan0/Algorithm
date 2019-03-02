package simple.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class SortAndSearch {

    @Test
    public void test1(){
        int arr[] = {3,5,1,4,2};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public void quickSort(int arr[],int low, int high){
        if (low < high){
            int pivotpos = Partition(arr,low,high);
            quickSort(arr,low,pivotpos - 1);
            quickSort(arr,pivotpos + 1, high);
        }
    }

    private int Partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while(low < high){
            while(low < high && arr[high] >= pivot)
                -- high;
            arr[low] = arr[high];
            while(low < high && arr[low] <= pivot)
                ++ low;
            arr[high] =arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
