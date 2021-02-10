package easy;

import base.TreeNode;

import java.util.*;

/**
 *剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 */
public class LowestCommonAncestor {
    /**
     * 递归方式
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);
        if(left == null && right == null)
            return null;
        if(left != null && right != null) // 左右子树都不是null，肯定是左右各是pq的祖先，则root就是最近公共祖先
            return root;
        return left == null ? right : left;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode , TreeNode> fMap = new HashMap<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode peek = deque.poll();
                if(peek.left != null){
                    deque.addLast(peek.left);
                    fMap.put(peek.left , peek);
                }
                if(peek.right != null){
                    deque.addLast(peek.right);
                    fMap.put(peek.right , peek);
                }
            }
        }
        Set<TreeNode> visited = new HashSet<>();
        visited.add(p);
        TreeNode tmp = p;
        while(tmp != root){
            tmp = fMap.get(tmp);
            visited.add(tmp);
        }
        visited.add(tmp);
        tmp = q;
        while(!visited.contains(tmp))
            tmp = fMap.get(tmp);
        return tmp;
    }
}
