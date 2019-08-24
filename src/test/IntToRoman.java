package test;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * @Date: Created in 19:48 2019/7/29
 */
public class IntToRoman {

    @Test
    public void intToRoman(){
        int num = 58;
        System.out.println(intToRoman(num));
    }

    public String intToRoman(int num) {
        int nummericalDigit[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String romanString[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

        StringBuilder sb = new StringBuilder();
        int maxIndex = nummericalDigit.length - 1;

        while (num > 0) {
            while (nummericalDigit[maxIndex] > num) {
                --maxIndex;
            }
            sb.append(romanString[maxIndex]);
            num -= nummericalDigit[maxIndex];
        }

        return sb.toString();
    }


    @Test
    public void romanToInt(){
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    /**
     * 罗马数字转换成阿拉伯数字
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (s.length() == 0){
            return 0;
        }
        int position = 0;
        int number = 0;
        while (position < s.length()){
            switch (s.charAt(position)) {
                case 'I' :
                    if (position + 1 < s.length() && s.charAt(position+ 1) =='V'){
                        number += 4;
                        position = position + 2;
                    } else if (position + 1 < s.length() && s.charAt(position+1) == 'X'){
                        number += 9;
                        position = position + 2;
                    } else {
                        number += 1;
                        position ++;
                    }
                    break;
                case 'V' :
                    number += 5;
                    position ++;
                    break;
                case 'X' :
                    if (position + 1 < s.length() && s.charAt(position+1) == 'L'){
                        number += 40;
                        position = position + 2;
                    } else if (position + 1 < s.length() && s.charAt(position+1) == 'C'){
                        number += 90;
                        position = position + 2;
                    } else {
                        number += 10;
                        position++;
                    }
                    break;
                case 'L' :
                    number += 50;
                    position ++;
                    break;
                case 'C' :
                    if (position + 1 < s.length() && s.charAt(position+1) == 'D'){
                        number += 400;
                        position = position + 2;
                    } else if(position + 1 < s.length() && s.charAt(position+1) == 'M'){
                        number += 900;
                        position = position + 2;
                    } else {
                        number += 100;
                        position++;
                    }
                    break;
                case 'D' :
                    number += 500;
                    position++;
                    break;
                case 'M' :
                    number += 1000;
                    position++;
                    break;
            }

        }

        return number;
    }
}
