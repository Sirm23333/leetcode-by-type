package medium;

import base.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InorderTraversal {

    /**
     * 中序遍历(递归)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> tree = inorderTraversal(root.left);
        tree.add(root.val);
        tree.addAll(inorderTraversal(root.right));
        return tree;
    }

    /**
     * 中序遍历(非递归)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if(root == null)
            return rs;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            // 向左到头
            TreeNode peek = stack.peek();
            while(peek.left != null){
                stack.add(peek.left);
                peek = stack.peek();
            }
            // 访问最左，如果右边没有则一直访问
            do{
                peek = stack.pop();
                rs.add(peek.val);
            }while (!stack.isEmpty() && peek.right == null);
            // 右子树入栈
            if(peek.right != null)
                stack.add(peek.right);
        }
        return rs;
    }


}
