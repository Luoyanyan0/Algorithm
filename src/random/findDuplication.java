package random;

/**
 * 从一个无序的数组中找出重复的数
 * 数组的长度为n，数的范围在0~n-1之间
 */
public class findDuplication {

    public static void main(String[] args) {
        int arr[] = {2,3,1,0,2,5,3};
        System.out.println(findDuplicationInRandom(arr));
    }

    // 改变了数组的做法
    public static int findDuplicationInRandom(int[] arr){
        int duplication = 0;
        for (int i = 0; i < arr.length; i++){
            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    duplication = arr[i];
                    return duplication;
                }else{
                    // 交换   注意这里的交换
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                }
            }
        }
        return -1;
    }


    // 不改变数组的做法
    // 二分查找，找到一个中间的数，将数组按大小分为两部分
    // 比如0~7之间数，就找3，将数组分成1~3,4~7 分别数出两部分的长度
    // 如果1~3之间数的长度大于3，那说明这之间肯定有重复的数
    // 但是这种方法还是存在缺陷，比如1~3之间的数字是1,1,1这样就没法识别出来1重复了
}

