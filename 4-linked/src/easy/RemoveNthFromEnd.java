package easy;

/**
 * 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head , right = head;
        for(int i = 0; i < n; i++)
            right = right.next;
        // 如果right为空，则说明n==链表长度，即删除的是头节点
        if(right == null)
            return head.next;
        while (right.next != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }

}
