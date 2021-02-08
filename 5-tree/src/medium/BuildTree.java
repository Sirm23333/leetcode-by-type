package medium;

import easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class BuildTree {
    private Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i],i);
        return buildTree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int preStart , int preEnd ,
                              int[] inorder , int inStart , int inEnd) {
        TreeNode root = new TreeNode(preorder[preStart]);
        int tmp = map.get(preorder[preStart]);
        root.left = tmp == inStart ? null : buildTree(preorder , preStart + 1 , preStart + tmp - inStart , inorder , inStart , tmp - 1);
        root.right = tmp == inEnd ? null : buildTree(preorder , preStart + tmp - inStart + 1 , preEnd , inorder ,  tmp + 1 , inEnd);
        return root;
    }
}
