package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 19:42 2019/8/4
 */
public class GenerateParenthesis {

    @Test
    public void generateParenthesis(){
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    /**
     * lNumber 已使用左括号的数量    rNumber 已使用的右括号的数量
     * @param n  括号的对数
     * lNumber > n  || lNumber > n || rNumber > lNumber 错误，直接返回
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        list = generateParenthesisCore("",list,n,0,0);
        return list;
    }

    private List<String> generateParenthesisCore(String letter,List<String> list, int n, int lNumber, int rNumber) {
        if (lNumber > n || rNumber > n || rNumber > lNumber){
            return list;
        }

        if (lNumber == n && rNumber == n){
            list.add(letter);
        }

        if (lNumber <= n && rNumber <= n && rNumber <= lNumber){
            generateParenthesisCore(letter+"(",list,n,lNumber+1,rNumber);
            generateParenthesisCore(letter+")",list,n,lNumber,rNumber+1);
        }
        return list;
    }
}
