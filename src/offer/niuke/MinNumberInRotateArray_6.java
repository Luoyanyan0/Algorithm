package offer.niuke;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/10 16:59
 * @Description:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray_6 {
    public static void main(String[] args) {
        int array[] = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }

        int low = 0;
        int high = array.length - 1;
        // 要保证移动过元素
        while (array[low] >= array[high]){
            int mid = (low + high)/2;
            // mid low high 位置处的数字全部相等
            if (array[mid] == array[low] &&
                    array[mid] == array[high]){
                return findMinByOrder(array);
            }

            if (high - low == 1){
                return array[high];
            }
            // 另一种情况
            // mid在前面递增的数组
            if (array[mid] >= array[low]){
                low = mid;
                // mid在后面递增的数组
            }else if(array[mid] <= array[high]){
                high = mid;
            }

        }
        return 0;
    }

    public static int findMinByOrder(int[] array){
        int minNum = array[0];
        for (int i = 1; i < array.length;i++){
            if (array[i] < minNum){
                minNum = array[i];
            }
        }
        return minNum;
    }

}
