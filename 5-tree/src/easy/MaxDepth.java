package easy;

import base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxDepth {

    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return  Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null)
            return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int level = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode treeNode = deque.pollFirst();
                if(treeNode.left != null)
                    deque.addLast(treeNode.left);
                if(treeNode.right != null)
                    deque.addLast(treeNode.right);
            }
            level++;
        }
        return level;
    }




}
