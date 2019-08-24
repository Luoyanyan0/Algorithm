package random;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yanyan.luo
 * @Description: 根据树的前序中序序列构造一棵树
 * @Date: Created in 10:27 2019/8/23
 */
public class ConstructorTreeByPreMedian {

    @Test
    public void constructorTree () {
        int[] pre = {1,2,4,5,3,6};
        int[] in = {4,2,5,1,6,3};
        TreeNode root = constructorTree(pre, in);
        List<Integer> list = traverseTreeByLevel(root);
        for (Integer a : list) {
            System.out.print(a+"  ");
        }

    }

    public TreeNode constructorTree(int[] pre, int[] in) {
         if (pre.length == 0 || in.length == 0) {
             return null;
         }

         TreeNode root = null;
         root = constructTreeCore(pre, in, 0, pre.length-1, 0, in.length-1);

         return root;
    }

    private TreeNode constructTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart==preEnd && inStart==inEnd) {
            return root;
        }
        // 找到root在中序中的位置
        int rootIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int leftLength = rootIndex - inStart;
        int rightLength = inEnd - rootIndex;
        if (leftLength > 0) {
            root.left = constructTreeCore(pre, in, preStart + 1, preStart + leftLength,
                    inStart, inStart + leftLength - 1);
        } else {
            root.left = null;
        }
        if (rightLength > 0) {
            root.right = constructTreeCore(pre, in, preEnd - rightLength + 1, preEnd,
                    inEnd - rightLength + 1, inEnd);
        } else {
            root.right = null;
        }
        return root;
    }


    private List<Integer> traverseTreeByLevel (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            list.add(tempNode.val);

            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
        return list;

    }
}
