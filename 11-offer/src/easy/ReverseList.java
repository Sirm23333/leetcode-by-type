package easy;

/**
 *剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseList {
    /**
     * 非递归写法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode h = head;
        ListNode i = head;
        while((i = head.next) != null){
            head.next = i.next;
            i.next = h;
            h = i;
        }
        return h;
    }

    /**
     * 递归写法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode listNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
}
