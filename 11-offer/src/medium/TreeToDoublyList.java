package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class TreeToDoublyList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * 递归写法
     */
    static Node head, tail;
    public static Node treeToDoublyList2(Node root) {
        head = tail = null;
        dfs(root);
        return head;
    }
    public static void dfs(Node root){
        if(root == null) return;
        dfs(root.left);
        Node right = root.right;
        if(head == null){
            head = root;
            tail = root;
            head.right = head.left = root;
        }else {
            root.left = tail;
            tail.right = root;
            root.right = head;
            head.left = root;
            tail = root;
        }
        dfs(right);
    }
    public static Node treeToDoublyList(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Node> nodes = new ArrayList<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node peek = stack.peek();
            // 往左到头
            while(peek.left != null){
                stack.push(peek.left);
                peek = stack.peek();
            }
            do{
                peek = stack.pop();
                nodes.add(peek);

            }while (!stack.isEmpty() && peek.right == null);
            if(peek.right != null){
                stack.push(peek.right);
            }
        }
        Node head = nodes.get(0);
        head.left = head;
        head.right = head;
        Node tail = head;
        for(int i = 1; i < nodes.size(); i++){
            Node tmp = nodes.get(i);
            tmp.left = tail;
            tail.right = tmp;
            tmp.right = head;
            head.left = tmp;
            tail = tmp;
        }
        return head;
    }
}
