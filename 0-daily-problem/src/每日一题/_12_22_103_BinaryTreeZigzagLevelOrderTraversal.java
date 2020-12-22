package 每日一题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class _12_22_103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> rss = new ArrayList<>();
        boolean ac = true;
        TreeNode tmpNode ;
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> rs = new ArrayList<>();
            if(ac){
                for(int i = 0; i < size; i++){
                    tmpNode = queue.pollFirst();
                    rs.add(tmpNode.val);
                    if(tmpNode.left != null)
                        queue.addLast(tmpNode.left);
                    if(tmpNode.right != null)
                        queue.addLast(tmpNode.right);
                }
            }else {
                for(int i = 0; i < size; i++){
                    tmpNode = queue.pollLast();
                    rs.add(tmpNode.val);
                    if(tmpNode.right != null)
                        queue.addFirst(tmpNode.right);
                    if(tmpNode.left != null)
                        queue.addFirst(tmpNode.left);
                }
            }
            ac = !ac;
            rss.add(rs);
        }
        return rss;

    }
}
