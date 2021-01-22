package easy;

import java.util.List;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ValidBST {

    /**
     * 直接判断
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        boolean left = isValidBST(root.left);
        if(left){
            boolean right = isValidBST(root.right);
            if(right){
                TreeNode tmp = root.left;
                while(tmp != null && tmp.right != null){
                    tmp = tmp.right;
                }
                if(tmp == null || root.val > tmp.val){
                    tmp = root.right;
                    while(tmp != null && tmp.left != null){
                        tmp = tmp.left;
                    }
                    if(tmp == null || root.val < tmp.val)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * 优雅写法
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null)
            return true;
        boolean left = isValidBST2(root.left);
        boolean right = isValidBST2(root.right);
        TreeNode leftMax = getRight(root.left);
        TreeNode rightMin = getLeft(root.right);
        return left && right && (leftMax == null || leftMax.val < root.val) && (rightMin == null || rightMin.val > root.val);
    }
    public TreeNode getRight(TreeNode root){
        if(root == null)
            return null;
        TreeNode tmp = root;
        while(tmp.right != null){
            tmp = tmp.right;
        }
        return tmp;
    }
    public TreeNode getLeft(TreeNode root){
        if(root == null)
            return null;
        TreeNode tmp = root;
        while(tmp.left != null){
            tmp = tmp.left;
        }
        return tmp;
    }



    /**
     * 中序遍历 （递增）
     * @param root
     * @return
     */
    // val为int时，一定想着用long表示最大最小值
    private long max = Long.MIN_VALUE;
    public boolean isValidBST3(TreeNode root) {
        if(root == null)
            return true;
        if(isValidBST3(root.left)){
            if(max < root.val)
                max = root.val;
            else
                return  false;
            return isValidBST3(root.right);
        }
        return false;
    }


}
