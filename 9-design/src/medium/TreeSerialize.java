package medium;

import base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeSerialize {
    // 不能用前序+中序的方式，会用重复的val
    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root == null)
//            return null;
//        List<String> preOrder = new ArrayList<>();
//        List<String> midOrder = new ArrayList<>();
//        preOrder(root,preOrder);
//        midOrder(root,midOrder);
//        preOrder.addAll(midOrder);
//        StringBuffer sb = new StringBuffer();
//        for(String str : preOrder){
//            sb.append(str).append(",");
//        }
//        return sb.substring(0,sb.length()-1);
//    }
//
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if(data == null)
//            return null;
//        String[] datas = data.split(",");
//        int len = datas.length;
//        return genTree(datas,0,len / 2 - 1, len / 2  , len - 1);
//    }
//    private void preOrder(TreeNode root, List<String> list){
//        if(root == null)
//            return;
//        list.add(root.val+"");
//        preOrder(root.left,list);
//        preOrder(root.right,list);
//    }
//    private void midOrder(TreeNode root, List<String> list){
//        if(root == null)
//            return;
//        midOrder(root.left,list);
//        list.add(root.val+"");
//        midOrder(root.right,list);
//    }
//    private TreeNode genTree(String[] arr, int preStart , int preEnd , int midStart, int midEnd){
//        if(preStart > preEnd)
//            return null;
//        TreeNode node = new TreeNode(Integer.parseInt(arr[preStart]));
//        int idx = getIdx(arr, midStart, midEnd, node.val);
//        node.left = genTree(arr,preStart + 1 , idx - midStart + preStart , midStart , idx - 1);
//        node.right = genTree(arr, idx - midStart + preStart + 1 , preEnd , idx + 1 , midEnd);
//        return node;
//    }
//    private int getIdx(String[] arr , int start , int end , int target){
//        if(start > end)
//            return -1;
//        for(int i = start; i <= end; i++){
//            if(Integer.parseInt(arr[i]) == target)
//                return i;
//        }
//        return -1;
//    }

    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        List<TreeNode> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        list.add(root);
        int k = 0;
        while(k < list.size()){
            int size = list.size();
            for(; k < size; k++){
                TreeNode tmp = list.get(k);
                if(tmp == null){
                    sb.append("null").append(",");
                }else {
                    sb.append(tmp.val+"").append(",");
                    list.add(tmp.left);
                    list.add(tmp.right);
                }
            }
        }
        return sb.substring(0,sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        String[] split = data.split(",");
        int idx = 1;
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        list.add(root);
        int k = 0;
        while(k < list.size()){
            int size = list.size();
            for(; k < size; k++){
                TreeNode treeNode = list.get(k);
                if(treeNode != null){
                    if(idx < split.length){
                        treeNode.left = "null".equals(split[idx]) ? null : new TreeNode(Integer.parseInt(split[idx]));
                        list.add(treeNode.left);
                    }
                    idx++;
                    if(idx < split.length){
                        treeNode.right = "null".equals(split[idx]) ? null : new TreeNode(Integer.parseInt(split[idx]));
                        list.add(treeNode.right);
                    }
                    idx++;
                }

            }
        }
        return root;
    }

}
