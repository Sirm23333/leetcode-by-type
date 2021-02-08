package easy;


import base.TreeNode;

import java.util.*;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Symmetric {

    /**
     * 递归写法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }
    public boolean isSymmetric(TreeNode left , TreeNode right){
        if(left == null && right == null)
            return true;
        else if(left != null && right != null)
            return left.val == right.val && isSymmetric(right.left , left.right) && isSymmetric(right.right , left.left);
        else
            return false;
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        if(root.left == null || root.right == null || root.left.val != root.right.val)
            return false;
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(root.left);
        queue2.add(root.right);
        TreeNode tmp1 , tmp2;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            tmp1 = queue1.poll();
            tmp2 = queue2.poll();

            if(tmp1.left == null && tmp2.right == null);
            else if(tmp1.left == null || tmp2.right == null || tmp1.left.val != tmp2.right.val)
                return false;
            else {
                queue1.add(tmp1.left);
                queue2.add(tmp2.right);
            }

            if(tmp1.right == null && tmp2.left == null);
            else if(tmp1.right == null || tmp2.left == null || tmp1.right.val != tmp2.left.val)
                return false;
            else {
                queue1.add(tmp1.right);
                queue2.add(tmp2.left);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
