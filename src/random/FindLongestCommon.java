package random;

import java.util.*;


/**
 * 3个顾客，每个顾客买4个产品，输出所有顾客买的最多的产品
 * 3,4
 * {{5,1,6,7},
 * {7,5,1,6},
 * {6,7,1,5}}
 */
public class FindLongestCommon {
    public static void main(String[] args) {
        int N = 3, M =4;
        List<List<Integer>> productList = new ArrayList<>();
        List<Integer> product1 = new ArrayList<>();
        product1.add(5);
        product1.add(1);
        product1.add(6);
        product1.add(7);

        List<Integer> product2 = new ArrayList<>();
        product2.add(7);
        product2.add(5);
        product2.add(1);
        product2.add(6);

        List<Integer> product3 = new ArrayList<>();
        product3.add(6);
        product3.add(7);
        product3.add(1);
        product3.add(5);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        List<Integer> list = findLongestCommon(N,M,productList);
        for (Integer a : list){
            System.out.println(a);
        }


    }
    public static List<Integer> findLongestCommon(int N, int M, List<List<Integer>> productList){
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> coutMap = new HashMap<>();
        for (int i = 0; i < productList.size(); i++){
            List<Integer> product = productList.get(i);
            for (int j = 0; j < product.size(); j++){
                int currentNum = product.get(j);
                if (coutMap.containsKey(currentNum)){
                    int count = coutMap.get(currentNum);
                    coutMap.put(currentNum,++count);
                }else{
                    coutMap.put(currentNum,1);
                }
            }
        }

        list = findMostCurrent(coutMap);
        return list;
    }

    /**
     * 找到countMap中出现次数最多的所有数字
     * @param countMap
     * @return
     */
    public static List<Integer> findMostCurrent(Map<Integer,Integer> countMap){
        List<Integer> list = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        for (Integer key : countMap.keySet()){
            valueList.add(countMap.get(key));
        }

        int maxNum = getMaxNumFromList(valueList);

        // 遍历countMap，找到值等于maxNum的键放入list中
        for (Integer key : countMap.keySet()){
            if (countMap.get(key) == maxNum){
                list.add(key);
            }
        }
    return list;
    }

    private static int getMaxNumFromList(List<Integer> valueList) {
        Integer[] valueArray = new Integer[valueList.size()];
        valueArray = valueList.toArray(valueArray);
        // 得到value中最大的数
        int maxNum = valueArray[0];
        for (int i = 1; i < valueArray.length; i++){
            if (valueArray[i] > maxNum){
                maxNum = valueArray[i];
            }
        }
        return  maxNum;
    }
}
