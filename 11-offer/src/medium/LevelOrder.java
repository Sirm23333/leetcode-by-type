package medium;

import base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> rs = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode peek = queue.poll();
            if(peek.left != null)
                queue.add(peek.left);
            if(peek.right != null)
                queue.add(peek.right);
            rs.add(peek.val);
        }
        int[] rss = new int[rs.size()];
        int i = 0;
        for(int r : rs){
            rss[i++] = r;
        }
        return rss;
    }
}
