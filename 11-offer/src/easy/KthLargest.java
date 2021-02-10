package easy;

import base.TreeNode;

/**
 *剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class KthLargest {
    int rs , k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        againstInorder(root);
        return rs;
    }
    public void againstInorder(TreeNode root){
        if(root == null)
            return;
        againstInorder(root.right );
        if(k == 0)
            return;
        rs = root.val;
        k--;
        againstInorder(root.left);
    }
}
