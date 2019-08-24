package random;

import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 16:10 2019/8/11
 */
public class Main2 {
    public static void main(String[] args) {
        /*Scanner sca = new Scanner(System.in);
        int L = sca.nextInt();
        int N = sca.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++){
            numbers[i] = sca.nextInt();
        }*/

        int L = 1000;
        int N = 4;
        int numbers[] = {1,4,998,995};

        int[] flag = new int[L];

        int finalSum = Integer.MAX_VALUE;
        // 以i作为基准比较
        for (int i = 0; i < N; i++){
            int tag = numbers[i];
            int sum = 0;
            for (int j = 0; j < N; j++){
                // 有两种方式到指定数的位置
                int strategy1;
                int strategy2;
                if (j == i){
                    strategy1 = 0;
                    strategy2 = 0;
                    flag[numbers[i]] = 1;
                } else {
                    strategy1 = getAbs(numbers[j],tag) - 1;
                    strategy2 = L - numbers[j] + tag - 1;
                    int index;
                    if (strategy1 < strategy2){
                        index = numbers[i] + 1;
                        if (flag[index] == 0){
                            flag[index] = 1;
                        } else {
                            strategy1 = strategy1 + 1;
                        }
                    } else {
                        index = (numbers[j] + strategy2)%L;
                        if (flag[index] == 0){
                            flag[index] = 1;
                        } else {
                            strategy2 = strategy2 - 1;
                        }
                    }
                }

                int tempSum = strategy1 < strategy2 ? strategy1 : strategy2;
                sum += tempSum;
            }
            if (sum < finalSum){
                finalSum = sum;
            }
        }
        System.out.println(finalSum);
    }

    private static int getAbs(int n1, int n2){
        int number = n1 - n2;
        return number > 0 ? number : -number;
    }

    private static int preIndex(int index,int L){
        if (index == 0){
            return L - 1;
        }
        return index - 1;
    }
}
