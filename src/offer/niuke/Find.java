package offer.niuke;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/9 23:34
 * @Description:在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {

    public static void main(String[] args) {
        int array[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 4;
        System.out.println(Find(target,array));
    }

    public static boolean Find(int target, int [][] array) {
        int rowTag = 0;
        int colTag = array[0].length - 1;
        while (rowTag < array.length && colTag >= 0){

            if (array[rowTag][colTag] == target){
                return true;
            }

            while (rowTag < array.length && colTag >= 0 &&
                    array[rowTag][colTag] > target){
                colTag --;
            }

            while (rowTag < array.length && colTag >= 0 &&
                    array[rowTag][colTag] < target){
                rowTag ++;
            }
        }
        return false;
    }
}
