package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 1~N中1的个数
 * @Date: Created in 11:13 2019/7/4
 */
public class NumberOf1Between1AndN {

    @Test
    public void test(){
        int n = 21345;
        System.out.println(numberOf1Betweent1AndN(n));
    }

    public int numberOf1Betweent1AndN(int n){
        char[] charN = String.valueOf(n).toCharArray();
        return numberOf1(charN,0);
    }

    public int numberOf1(char[] charN,int index){
        int length = charN.length - index;
        // 递归，数组的长度是不变的，需要及时调整index的位置，以及index定位的有效数组长度
        if (length <= 0 || charN[index] < '0' || charN[index] > '9'){
            return 0;
        }
        int first = charN[index] - '0';
        if (length == 1 && first == 0){
            return 0;
        }

        if (length == 1 && first > 0){
            return 1;
        }

        // 最高位的1  21345 万位的1
        int numFirstDigit = 0;
        // 分两种情况，一种是万位开始>1，一种是=1
        if (first > 1){
            numFirstDigit = powerBase10(charN.length - index - 1);
        }else if(first == 1){
            numFirstDigit = Integer.valueOf(String.valueOf(charN).substring(index+1)) + 1;
        }

        // 1346~21345 除了最高位以外其他4位数中1的个数
        int numberOtherDigits = first * (length - 1) * powerBase10(length - 2);

        // 1~1345
        int numberRecursive = numberOf1(charN,index+1);

        return numFirstDigit + numberOtherDigits + numberRecursive;

    }

    public int powerBase10(int n){
        int result = 1;
        for (int i = 0; i < n; i++){
            result *= 10;
        }
        return result;
    }
}
