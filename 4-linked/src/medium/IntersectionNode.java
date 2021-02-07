package medium;

import easy.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class IntersectionNode {
    /**
     * 哈希记录a存在的所有节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode a = headA , b = headB;
        while(a != null){
            set.add(a);
            a = a.next;
        }
        while (b != null){
            if(set.contains(b))
                return b;
            b = b.next;
        }
        return null;
    }

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA , b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
