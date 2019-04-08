package random;

/**
 * 一个有序的数组，一个数会出现多次，找到数组中这个数的起始位置和终止位置
 * 比如 {1,3,5,8,8,8,8,9}   8
 * 输出  3,6
 */
public class findBeginAndEnd {

    public static void main(String[] args) {
        int arr[] = {1,8,8,8,8,8,8};
        System.out.println(findBegin(arr,8,0,6));
        System.out.println(findEnd(arr,8,0,6));
    }

    public static int findBegin(int arr[],int target,int low, int high){
        while(low <= high){
            int mid = (low + high)/2;
            if (target > arr[mid]) {
                low = mid + 1;
            }else if(target < arr[mid]){
                high = mid - 1;
            }else{
                if (mid == low || (mid - 1 >= low && arr[mid - 1] != target)){
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }



    public static int findEnd(int arr[],int target,int low, int high){
        while(low <= high){
            int mid = (low + high)/2;
            if (target > arr[mid]) {
                low = mid + 1;
            }else if(target < arr[mid]){
                high = mid - 1;
            }else{
                // mid是边界   mid不是边界，但是mid+1的值不等于target
               if (mid == high || (mid + 1 <= high && arr[mid + 1] != target)){
                   return mid;
               }
               low = mid + 1;
            }
        }
        return -1;
    }


}
