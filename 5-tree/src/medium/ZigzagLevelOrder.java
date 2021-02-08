package medium;

import base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rss = new ArrayList<>();
        if(root == null)
            return rss;
        boolean order = true; // 当前层自左向右为true
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> rs = new ArrayList<>();
            // order 为true时  从前面出 先左后右从后面入
            // order 为false时 从后面出 先右后左从前面入
            TreeNode tmp = null;
            if(order){
                for(int i = 0; i < size; i++){
                    tmp = deque.pollFirst();
                    rs.add(tmp.val);
                    if (tmp.left != null)
                        deque.addLast(tmp.left);
                    if(tmp.right != null)
                        deque.addLast(tmp.right);
                }
            }else{
                for(int i = 0; i < size; i++){
                    tmp = deque.pollLast();
                    rs.add(tmp.val);
                    if(tmp.right != null)
                        deque.addFirst(tmp.right);
                    if (tmp.left != null)
                        deque.addFirst(tmp.left);
                }
            }
            order = !order;
            rss.add(rs);
        }
        return rss;
    }


}
