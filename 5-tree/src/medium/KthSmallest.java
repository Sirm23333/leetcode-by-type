package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /**
     * 非递归写法
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while(!stack.isEmpty()){
            // 左到头
            TreeNode peek = stack.peek();
            while(peek.left != null){
                stack.push(peek.left);
                peek = peek.left;
            }
            // 访问
            do{
                peek = stack.pop();
                sum++;
                if(sum == k)
                    return peek.val;
            }while (!stack.isEmpty() && peek.right == null);
            // 右入栈
            if(peek.right != null)
                stack.push(peek.right);
        }
        return 0;
    }

}
