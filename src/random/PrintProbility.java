package random;

import org.junit.Test;

import java.util.*;

/**
 * @Author: yanyan.luo
 * @Description: n个骰子的点数
 * @Date: Created in 13:38 2019/7/18
 */
public class PrintProbility {
    @Test
    public void test(){
        int number = 2;
        printProbility(number);
    }

    int g_maxValue = 6;
    public void printProbility(int number){
        if (number < 1){
            return;
        }

        int maxSum = number * g_maxValue;
        int pProbility[] = new int[maxSum - number + 1];
        Probility(number,pProbility);

//        double total = Math.pow(g_maxValue,number);
        for (int i = 0; i < pProbility.length; i++){
            double ratio = pProbility[i];
            System.out.println(ratio);
        }

    }

    private void Probility(int number, int[] pProbility){
        for (int i = 1; i <= g_maxValue; i++){
            Probility(number,number,i,pProbility);
        }
    }

    private void Probility(int original, int current, int sum, int[] pProbility){
        if (current == 1){
            pProbility[sum - original]++;
        }else {
            for (int i = 1; i <= g_maxValue; i++){
                Probility(original,current - 1,sum + i,pProbility);
            }
        }
    }

    @Test
    public void test3(){
        int[] numbers = {1,0,0,4,6};
        System.out.println(isContinus(numbers));
    }

    public boolean isContinus(int[] numbers){
        if (numbers.length <= 0){
            return false;
        }
        // 将数组排序
        Arrays.sort(numbers);

        int countOf0 = 0;
        int countOfGap = 0;

        // 找到数组中0的个数，因为数组已排序，故0在数组的最前方
        int small = 0;
        for (; numbers[small] == 0; small++){
            countOf0 ++;
        }

        //找到数组中的间隔数
        int big = small + 1;
        while (big < numbers.length){
            // 如果有对子，就不是顺子
            if (numbers[small] == numbers[big]){
                return false;
            }

            countOfGap += (numbers[big] - numbers[small] - 1);
            small = big;
            big = small + 1;
        }

        if (countOfGap <= countOf0){
            return true;
        }
        return false;

    }

    @Test
    public void test4(){
       int n = 5;
       int m = 3;
        System.out.println(LastRemaining_Solution(n,m));
    }

    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }

    @Test
    public void test5(){
        int numbers[] = {9,11,8,5,7,12,16,14};
        System.out.println(maxDiff(numbers));
    }

    public int maxDiff (int numbers[]){
        if (numbers.length < 2){
            return -1;
        }
        int min = numbers[0];
        int maxDiff = numbers[1] - numbers[0];
        for (int i = 2; i < numbers.length; i++){
            // 找到i-1个数字中的最小值，就存在最大差值
            int current = numbers[i-1];
            if (current < min){
                min = current;
            }
            if (numbers[i] - min > maxDiff){
                maxDiff = numbers[i] - min;
            }
        }
        return maxDiff;
    }

    @Test
    public void  test6(){
        int A[] = {0,1,2,3};
        System.out.println(multiply(A));
    }

    //如果可以使用除法的话 B[i] = A[0]*...*A[n-1]/A[i]
    public int[] multiply(int[] A) {
        //B[i] = C[i] * D[i]
        //创建数组B存储结果
        int B[] = new int[A.length];
        //说明A中的元素不止一个
        if(A.length > 1){
            //B0中A0是1 --> C0  令B[0]的初始值是1
            //这里都是先初始化B的值作为C的值，后面再用B的初始值乘以D的值就是最终的结果
            B[0] =  1;
            //C[i] = C[i-1] * A[i-1] 所以i必须从1开始
            for(int i = 1 ; i < A.length ;i++){
                B[i] = B[i-1] * A[i-1];  //C[1] = C[0] * A[0]
            }
            //这里B[n-1]=C[n-1]=C[n-2]*A[n-2] 因为B[n-1]的最后一位An-1的值是1
            //Bn-1中An-1等于1-->Dn-1
            int temp = 1;
            //因为D[i] = D[i+1] * A[i+1] 所以i只能从length-2开始
            //这里B[0]=D[0]=D[1]*A[1] 因为B0的第一位A0是1
            for(int i = A.length - 2 ; i >= 0 ; i--){
                temp *= A[i+1];   //D[n-2] = D[n-1] * A[n-1]
                B[i] *= temp;     //B[n-2] = C[n-2] * D[n-2]
            }
        }
        return B;
    }
}
