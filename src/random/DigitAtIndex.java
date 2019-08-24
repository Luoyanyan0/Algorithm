package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 012345678910  任意第N位对应的数 第0位是0
 * @Date: Created in 19:18 2019/7/4
 */
public class DigitAtIndex {

    @Test
    public void test(){
        System.out.println(digitAtIndex(17));
    }

    public int digitAtIndex(int index){
        int digit = 1;
        while (true){
            // digit代表数字的位数
            // 求digit位的数字有多少个
           int number = getNumberOfDigit(digit);
           if (number * digit > index){
               return getNumber(index,digit);
           }
           index -= (number * digit);
           digit ++;
        }
    }

    private int getNumber(int index, int digit) {
        // 找到对应digit位数起始的数   比如digit=2 得到10
        int number = getBeginNumber(digit) + index / digit;
        int numberLeft = index % digit;
        if (numberLeft > 0){
            return Integer.valueOf(String.valueOf(number).substring(numberLeft-1,numberLeft));
        }else if(numberLeft == 0){
            String result = String.valueOf(number -1);
            return Integer.valueOf(result.substring(result.length() - 1));
        }
        return -1;
    }

    private int getBeginNumber(int digit) {
        // 0是第0位，
        if (digit == 1){
            return 1;
        }
        int result = 1;
        for (int i = 1; i < digit; i++){
            result *= 10;
        }
        return result;
    }

    private int getNumberOfDigit(int digit) {
        if (digit == 1){
            return 9 ;
        }
        int result = 1;
        for (int i = 1; i < digit; i++){
            result *= 10;
        }
        return result*9;
    }
}
