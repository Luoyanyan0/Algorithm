package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/4/9 15:36
 * @Description:在一个字符串中，每段范围内出现次数最多的字符，
 * 如果出现字符频率相同，按照字母表的顺序输出最前面的一个字符
 * "dddhppr" 2  [[1,4],[5,7]]  dp
 * "cabcac"  3  [[1,6],[1,3],[2,5]]
 */
public class OccurUsuallyChar {

    public static void main(String[] args) {
        String str = "cabcac";
        int parts = 3;
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> partList1 = new ArrayList<>();
        partList1.add(1); partList1.add(6);

        List<Integer> partList2 = new ArrayList<>();
        partList2.add(1); partList2.add(3);

        List<Integer> partList3 = new ArrayList<>();
        partList3.add(2); partList3.add(5);

        list.add(partList1);
        list.add(partList2);
        list.add(partList3);

        System.out.println(occurUsuallyChars(str,parts,list));

    }

    public static String occurUsuallyChars(String str, int parts, List<List<Integer>> partRanges){
        char[] charArray = str.toCharArray();
        // 存放每个范围每个字符出现的次数
        List<Map<Character,Integer>> mapList = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (List<Integer> range : partRanges){
            Map<Character,Integer> countMap = new HashMap<>();
            // 找出范围的起始和终止位置
            for (int i = range.get(0) - 1; i <= range.get(1) - 1 ; i++){
                // 在range范围内遍历字符串，找到出现次数最多的字符
                if (countMap.containsKey(charArray[i])){
                    int count = countMap.get(charArray[i]);
                    countMap.put(charArray[i],++count);
                }else{
                    countMap.put(charArray[i],1);
                }
            }
            mapList.add(countMap);
        }
        // 找到每个map中最大的value
        List<Integer> maxValueList = findMaxValue(mapList);

        for (int i = 0; i < maxValueList.size(); i++){
            Map<Character,Integer> map = mapList.get(i);
            Character terminalChar = 'z';
            for (Character key : map.keySet()){
                if (map.get(key).equals(maxValueList.get(i))){
                    if (key - 'a' < terminalChar - 'a'){
                        terminalChar = key;
                    }
                }
            }
            chars.add(terminalChar);
        }
        String str1 = "";
        for (Character c : chars){
            str1 += c;
        }
        return str1;

    }

    private static List<Integer> findMaxValue(List<Map<Character, Integer>> mapList) {
        List<Integer> list = new ArrayList<>();
        for (Map<Character,Integer> map : mapList){
            int maxValue = -1;
            for (Character key : map.keySet()){
                if (map.get(key) > maxValue){
                    maxValue = map.get(key);
                }
            }
            list.add(maxValue);
        }
        return list;
    }
}
