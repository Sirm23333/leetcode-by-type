package medium;

import base.TreeNode;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 前序遍历 preorder = [3,9,20,15,7] [2,3]
 * 中序遍历 inorder =  [9,3,15,20,7] [3,2]
 */
public class RebuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder , int preStart, int preEnd , int[] inorder , int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        if(preStart == preEnd){
            TreeNode treeNode = new TreeNode();
            treeNode.val = preorder[preStart];
            treeNode.right = null;
            treeNode.left = null;
            return treeNode;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.val = preorder[preStart];
        int idx = getIdx(inorder, inStart, inEnd, treeNode.val);
        int leftSum = idx - inStart;
        treeNode.left =  buildTree(preorder, preStart + 1 , preStart + leftSum , inorder , inStart , idx - 1);
        treeNode.right = buildTree(preorder, preStart + leftSum + 1 , preEnd , inorder , idx + 1, inEnd);
        return treeNode;
    }
    public int getIdx(int[] arr , int start, int end , int target){
        for(int i = start; i <= end; i++){
            if(arr[i] == target)
                return i;
        }
        return -1;
    }



}
