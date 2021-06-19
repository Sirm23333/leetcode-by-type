package medium;

import base.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum {
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> rss = new ArrayList<>();
        pathSum(root,target,new Stack<>() ,rss );
        return rss;
    }
    public static void pathSum(TreeNode root, int target, Stack<TreeNode> stack , List<List<Integer>> path) {
        if(root.right == null && root.left == null && target == root.val){
            Object[] objects = stack.toArray();
            List<Integer> rs = new ArrayList<>();
            for(Object tmp : objects){
                rs.add(((TreeNode)tmp).val);
            }
            rs.add(root.val);
            path.add(rs);
            return;
        }
        stack.push(root);
        if(root.left != null)
            pathSum(root.left , target - root.val , stack , path);
        if(root.right != null)
            pathSum(root.right , target - root.val , stack , path);
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        pathSum(n1,4);
    }
}
