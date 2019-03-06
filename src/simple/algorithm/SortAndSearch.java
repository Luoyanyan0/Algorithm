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

    /**
     * 因为这里最外面的while循环里面还套了两个while循环，也就是说，
     * 大的while里面的操作会随时改变low和high的值，它们的值也随时会被用到，
     * 这个时候，如果不在每个while中判断它们的大小的话，就会出现错误。
     * @param arr
     * @param low
     * @param high
     * @return
     */
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


    @Test
    public void binarySearchTest(){
        int arr[] = {0,2,3,4,6,9};
        int target = 2;
        System.out.println(binarySearch(arr,target));
    }

    /**
     * 因为这里while循环里面的条件是if，else，只执行其中之一，虽然对low和high有操作，
     * 但是操作完成之后是直接返回while循环继续判断的，所以只需要在while里面判断low和high
     * @param arr
     * @param target
     * @return
     */
    public int binarySearch(int arr[],int target){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if (target > arr[mid]){
                low = mid + 1;
            }else if(target < arr[mid]){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }


}
