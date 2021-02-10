package easy;

/**
 *剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA , b = headB;
        while(a != b){
            if(a == null) a = headB;
            else a = a.next;
            if(b == null) b = headA;
            else b = b.next;
        }
        return a;
    }
}
