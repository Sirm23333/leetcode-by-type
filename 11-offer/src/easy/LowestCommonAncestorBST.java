package easy;

import base.TreeNode;

/**
 *剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode rs = root;
        TreeNode min = p.val > q.val ? q : p;
        TreeNode max = p.val > q.val ? p : q;
        while(rs.val < min.val || rs.val > max.val){
            if(rs.val < min.val)
                rs = rs.right;
            else
                rs = rs.left;
        }
        return rs;
    }
}
