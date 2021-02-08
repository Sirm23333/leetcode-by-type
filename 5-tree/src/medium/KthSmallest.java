package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class KthSmallest {

    /**
     * 中序遍历 递归
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,k,list);
        return list.get(k - 1);
    }
    public void inorder(TreeNode root, int k , List<Integer> list) {
        if(root == null)
            return ;
        inorder(root.left,k,list);
        if(list.size() == k)
            return;
        else {
            list.add(root.val);
            inorder(root.right,k,list);
        }
    }

}
