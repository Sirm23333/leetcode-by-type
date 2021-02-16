package easy;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 */
public class DeleteLinkedNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head != null && head.val == val)
            return head.next;
        ListNode tmp = head;
        while(tmp.next != null){
            if(tmp.next.val == val){
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
        return head;
    }
}
