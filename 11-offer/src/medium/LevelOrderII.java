package medium;

import base.TreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class LevelOrderII {
    /**
     * 队列+栈
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> rss = new ArrayList<>();
        queue.add(root);
        boolean flag = true; // true为从右向左 false为从左向右
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> rs = new ArrayList<>();
            for(int i = 0 ; i < size; i++){
                TreeNode tmp = queue.poll();
                rs.add(tmp.val);
                stack.push(tmp);
            }
            if(flag){
                while(!stack.isEmpty()){
                    TreeNode tmp = stack.pop();
                    if(tmp.right != null)
                        queue.add(tmp.right);
                    if(tmp.left != null)
                        queue.add(tmp.left);
                }
            }else {
                while(!stack.isEmpty()){
                    TreeNode tmp = stack.pop();
                    if(tmp.left != null)
                        queue.add(tmp.left);
                    if(tmp.right != null)
                        queue.add(tmp.right);
                }
            }
            flag = !flag;
            rss.add(rs);
        }
        return rss;
    }

    /**
     * 双端队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> rss = new ArrayList<>();
        queue.add(root);
        boolean flag = true; // true为从右向左 false为从左向右
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> rs = new ArrayList<>();
            if(flag){
                for(int i = 0; i < size; i++){
                    TreeNode tmp = queue.pollFirst();
                    rs.add(tmp.val);
                    if(tmp.left != null)
                        queue.addLast(tmp.left);
                    if(tmp.right != null)
                        queue.addLast(tmp.right);
                }
            }else {
                for(int i = 0; i < size; i++){
                    TreeNode tmp = queue.pollLast();
                    rs.add(tmp.val);
                    if(tmp.right != null)
                        queue.addFirst(tmp.right);
                    if(tmp.left != null)
                        queue.addFirst(tmp.left);
                }
            }
            flag = !flag;
            rss.add(rs);
        }
        return rss;
    }
}
