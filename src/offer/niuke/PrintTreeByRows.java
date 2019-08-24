package offer.niuke;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yanyan.luo
 * @Description: 按层打印二叉树，每行输出一层
 * @Date: Created in 10:48 2019/8/7
 */
public class PrintTreeByRows {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> layer = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null){
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(pRoot);
        int start = 0; int end = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            layer.add(temp.val);
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
            }
        }
        return list;

    }
}
