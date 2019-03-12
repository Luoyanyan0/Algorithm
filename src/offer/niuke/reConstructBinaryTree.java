package offer.niuke;



/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/10 10:58
 * @Description:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class reConstructBinaryTree {
    // 递归
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null){
            return null;
        }
        return reConstructBinaryTree(pre,0,pre.length - 1,in,0,in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int pStart, int pEnd,
                                           int[] in, int iStart, int iEnd) {
        // 将先序的第一个节点作为根
        TreeNode root = new TreeNode(pre[pStart]);
        // 根据根节点的值将左右子树分隔开  求出左右子树的长度
        int lLen = 0,rLen = 0,i = 0;
        for (i = iStart; in[i] != root.val; i++){
        }
        lLen = i - iStart;
        rLen = iEnd - i;
        // 左子树存在
        if (lLen > 0){
            root.left = reConstructBinaryTree(pre,pStart + 1,pStart+lLen,
                    in,iStart,iStart+lLen - 1);
        }else{
            root.left = null;
        }

        // 右子树存在
        if (rLen > 0){
            root.right = reConstructBinaryTree(pre,pStart + lLen + 1,pEnd,
                    in,iStart + lLen + 1, iEnd);
        }else{
            root.right = null;
        }
        return root;

    }
}
