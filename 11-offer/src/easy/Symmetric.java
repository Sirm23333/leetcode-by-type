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
}
