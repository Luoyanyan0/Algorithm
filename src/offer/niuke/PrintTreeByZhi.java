package offer.niuke;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: yanyan.luo
 * @Description: 按之字形打印二叉树
 * @Date: Created in 11:26 2019/8/7
 */
public class PrintTreeByZhi {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> layer = new ArrayList<>();
        int count = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (pRoot == null){
            return list;
        }

        queue.offer(pRoot);
        int start = 0; int end = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (count % 2 == 0) {
                layer.add(temp.val);
            } else {
                layer.add(0,temp.val);
            }
            start ++;

            if (temp.left != null){
                queue.offer(temp.left);
            }

            if (temp.right != null){
                queue.offer(temp.right);
            }

            if (start == end){
                list.add(layer);
                start = 0;
                end = queue.size();
                layer = new ArrayList<>();
                count ++;
            }
        }
        return list;
    }
}
