package easy;
import java.util.*;

/**
 * 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if(root == null)
            return rs;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode peek;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                peek = queue.peek();
                if(peek.left != null)
                    queue.add(peek.left);
                if(peek.right != null)
                    queue.add(peek.right);
                tmp.add(peek.val);
                queue.poll();
            }
            rs.add(tmp);
        }
        return rs;
    }

    /**
     * 使用qeque 更快一点
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if(root == null)
            return rs;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        TreeNode peek;
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                peek = deque.peekFirst();
                if(peek.left != null)
                    deque.addLast(peek.left);
                if(peek.right != null)
                    deque.addLast(peek.right);
                tmp.add(peek.val);
                deque.pollFirst();
            }
            rs.add(tmp);
        }
        return rs;
    }

    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if(root == null)
            return rs;
        dfs(root,rs,1);
        return  rs;
    }
    public void dfs(TreeNode root , List<List<Integer>> rs , int level){
        if(root == null)
            return;
        if(rs.size() < level){
            rs.add(new ArrayList<>());
        }
        rs.get(level-1).add(root.val);
        if(root.left != null)
            dfs(root.left,rs,level+1);
        if(root.right != null)
            dfs(root.right,rs,level+1);
    }

}
