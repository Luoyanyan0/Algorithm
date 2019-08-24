package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 15:11 2019/8/1
 */
public class letterCombinations {
    @Test
    public void letterCombinations(){
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0){
            return list;
        }
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        list = generate("",digits,mapping,list);
        return list;
    }

    private List<String> generate(String s, String digits, String[] mapping, List<String> list) {
        if (s.length() == digits.length()){
            list.add(s);
        }else {
            String value = mapping[digits.charAt(s.length())-'0'];
            for (int i = 0; i < value.length(); i++){
                generate(s+ value.charAt(i),digits,mapping,list);
            }
        }
        return list;
    }


}
