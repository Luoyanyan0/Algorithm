package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 两个字符串的乘积
 * @Date: Created in 9:52 2019/8/12
 */
public class Multiply {
    @Test
    public void multiply(){
        String num1 = "401716832807512840963";
        String num2 = "167141802233061013023557397451289113296441069";
        System.out.println(multiply(num1,num2));
    }

    public String multiply(String num1, String num2) {
        return String.valueOf(Long.valueOf(num1) * Long.valueOf(num2));
    }
}
