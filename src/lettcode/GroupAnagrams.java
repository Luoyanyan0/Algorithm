package lettcode;

import org.junit.Test;

import java.util.*;

/**
 * @Author: yanyan.luo
 * @Description:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @Date: Created in 11:33 2019/8/17
 */
public class GroupAnagrams {

    @Test
    public void testMap() {
        Map<String,List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        map.put("1",list1);
        map.put("2",list2);

        List<List<Integer>> newList = new ArrayList<>();
        newList.addAll(map.values());

        System.out.println(newList);
    }


    @Test
    public void groupAnagrams(){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
       for (String word : strs) {
           char[] charr = word.toCharArray();
           Arrays.sort(charr);

           String key = String.valueOf(charr);
           map.putIfAbsent(key,new ArrayList<>());

           map.get(key).add(word);
       }

       List<List<String>> list = new ArrayList<>();
       list.addAll(map.values());
       return list;
    }
}
