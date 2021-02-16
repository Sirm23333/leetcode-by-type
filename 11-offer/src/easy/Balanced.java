package easy;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Balanced {
    Map<TreeNode,Integer> map = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return isBalanced(root.right) && isBalanced(root.left) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }
    public int height(TreeNode root){
        if(map.get(root) != null)
            return map.get(root);
        if(root == null)
            return 0;
        int h = Math.max(height(root.left) , height(root.right)) + 1;
        map.put(root,h);
        return h;
    }
}
