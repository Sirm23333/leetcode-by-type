package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CopyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node,Node> nodeMap = new HashMap<>();
        Node newHead = new Node(head.val);
        nodeMap.put(head,newHead);
        Node oldTmp = head;
        while(oldTmp != null){
            Node oldNext = oldTmp.next;
            Node oldRandom = oldTmp.random;
            Node newTmp = nodeMap.get(oldTmp);
            Node newNext = nodeMap.get(oldNext);
//            Node newRandom = nodeMap.get(oldRandom); // 注意这一句的位置，有可能oldRandom会在下面的if中put
            if(oldNext != null && newNext == null){
                newNext = new Node(oldNext.val);
                nodeMap.put(oldNext,newNext);
            }
            Node newRandom = nodeMap.get(oldRandom);
            if(oldRandom != null && newRandom == null){
                newRandom = new Node(oldRandom.val);
                nodeMap.put(oldRandom,newRandom);
            }
            newTmp.next = newNext;
            newTmp.random = newRandom;
            oldTmp = oldNext;
        }
        return newHead;
    }

    /**
     * 插入+拆分
     * @param head
     * @return
     */
    public static Node copyRandomList2(Node head) {
        if (head == null)
            return null;
        Node tmp = head;
        while(tmp != null){
            Node newTmp = new Node(tmp.val);
            newTmp.next = tmp.next;
            tmp.next = newTmp;
            tmp = newTmp.next;
        }
        tmp = head;
        while(tmp != null){
            tmp.next.random = tmp.random == null ? null : tmp.random.next;
            tmp = tmp.next.next;
        }
        // 拆分
        tmp = head;
        Node newHead = head.next;
        Node newTmp = head.next;
        while(tmp != null){
            tmp.next = newTmp.next;
            tmp = tmp.next;
            newTmp.next = tmp == null ? null : tmp.next;
            newTmp = newTmp.next;
        }
        return newHead;
    }
}
