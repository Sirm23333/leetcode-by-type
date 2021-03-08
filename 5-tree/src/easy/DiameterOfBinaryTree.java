package easy;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode,Integer > map = new HashMap<>();
        getLength(root,map);
        return diameterOfBinaryTree(root,map);
    }
    public int diameterOfBinaryTree(TreeNode root, Map<TreeNode,Integer> map){

        if(root == null)
            return 0;
        int ro = map.get(root.left) + map.get(root.right) ;
        int left = diameterOfBinaryTree(root.left , map);
        int right = diameterOfBinaryTree(root.right, map);
        return Math.max(ro,Math.max(left,right));

    }
    public int getLength(TreeNode root , Map<TreeNode , Integer> map){
        if(map.containsKey(root)){
            return map.get(root);
        }
        if(root == null)
            return 0;
        int rs = Math.max(getLength(root.left,map) , getLength(root.right,map))+1;
        map.put(root,rs);
        return rs;
    }


}
