package easy;

import base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorTree {
    /**
     * 递归写法
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null)
            return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeNode peek , tmp;
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                peek = deque.pollFirst();
                tmp = peek.left;
                peek.left = peek.right;
                peek.right = tmp;
                if(peek.left != null)
                    deque.addLast(peek.left);
                if(peek.right != null)
                    deque.addLast(peek.right);
            }
        }
        return root;
    }
}
