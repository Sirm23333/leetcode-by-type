package easy;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Symmetric {
    /**
     * 层次遍历每一行都是回文
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int start = 0 ,  end = list.size() - 1;
        while(start <= end){
            int i = start , j = end;
            while(i < j){
                if((list.get(i) == null && list.get(j) != null)
                        || (list.get(i) != null && list.get(j) == null)
                        || (list.get(i) != null && list.get(j) != null && list.get(i).val != list.get(j).val))
                    return false;
                i++;
                j--;
            }
            while(start <= end){
                TreeNode peek = list.get(start);
                if(peek != null){
                    list.add(peek.left);
                    list.add(peek.right);
                }
                start++;
            }
            end = list.size() - 1;
        }
        return true;
    }
    public boolean isSymmetric2(TreeNode root){
        if(root == null)
            return true;
        if((root.left != null && root.right != null) || (root.left == null && root.right == null))
            return isSymmetric(root.left,root.right);
        return false;
    }
    public boolean isSymmetric(TreeNode node1 , TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1.val != node2.val)
            return false;
        if((node1.left != null && node2.right == null) || (node1.left == null && node2.right != null))
            return false;
        if((node1.right != null && node2.left == null) || (node1.right == null && node2.left != null))
            return false;
        return isSymmetric(node1.left , node2.right) && isSymmetric(node1.right , node2.left);
    }

}
