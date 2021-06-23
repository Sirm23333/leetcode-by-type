package medium;

import java.util.Arrays;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if(len < 2) return true;
        int[] inorder = Arrays.copyOf(postorder,len);
        Arrays.sort(inorder);
        return verifyPostorder(postorder, 0 , len - 1 , inorder , 0 , len - 1);
    }
    // post [4, 6, 7, 5]
    // in   [4, 5, 6, 7]
    private boolean verifyPostorder(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if(postStart == postEnd && inStart == inEnd && postorder[postStart] == inorder[inStart])
            return true;
        if(postStart > postEnd || inStart > inEnd)
            return true;
        int rootValue = postorder[postEnd]; // 5
        int rootIdxInInOrder = inStart; // 1
        for(;rootIdxInInOrder <= inEnd;rootIdxInInOrder++){
            if (inorder[rootIdxInInOrder] == rootValue)
                break;
        }
        if(rootIdxInInOrder > inEnd)
            return false;
        // 右子树数量
        int rightSum = inEnd - rootIdxInInOrder; // 2
        // 左子树数量
        int leftSum = rootIdxInInOrder - inStart; // 1
        return verifyPostorder(postorder , postEnd  - rightSum , postEnd - 1 , inorder , rootIdxInInOrder + 1 , inEnd ) &&
                verifyPostorder(postorder , postStart , postStart + leftSum - 1 , inorder , inStart , rootIdxInInOrder - 1);
    }
    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if(start >= end)
            return true;
        int rootValue = postorder[end];
        int rightIdx = start;
        for(;rightIdx < end; rightIdx++){
            if(postorder[rightIdx] > rootValue){
                break;
            }
        }
        for(int i = rightIdx; i < end ;i++){
            if(postorder[i] < rootValue)
                return false;
        }
        return verifyPostorder(postorder , start , rightIdx - 1) && verifyPostorder(postorder , rightIdx , end - 1);
    }
}
