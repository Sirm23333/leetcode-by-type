package medium;

import base.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 */
public class Connect {
    /**
     * 层次遍历
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null)
            return null;
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                Node first = deque.pollFirst();
                if(first.left != null) deque.addLast(first.left);
                if(first.right != null) deque.addLast(first.right);
                first.next = i == size - 1 ? null : deque.getFirst();
            }
        }
        return root;
    }

    /**
     * 利用父层的next指针
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if(root == null)
            return null;
        root.next = null;
        Node preLevel = root;
        Node curLevel = root.left;
        while (curLevel != null){
            while(preLevel != null){
                preLevel.left.next = preLevel.right;
                preLevel.right.next = preLevel.next == null ? null : preLevel.next.left;
                preLevel = preLevel.next;
            }
            preLevel = curLevel;
            curLevel = curLevel.left;
        }
        return root;
    }

}
