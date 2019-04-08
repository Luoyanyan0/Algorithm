package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
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

        findLongestCommon(N,M,productList);


    }
    public static Map<Integer,Integer> findLongestCommon(int N, int M, List<List<Integer>> productList){
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
        return coutMap;
    }
}
