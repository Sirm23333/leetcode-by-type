package easy;

/**
 * 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseList {
    /**
     * 迭代方式
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode oldHead = head , newHead = head , tmp;
        while(oldHead.next != null){
            tmp = oldHead.next;
            oldHead.next = tmp.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    /**
     * 递归方式
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode tmp = head.next;
        ListNode newHead = reverseList2(head.next);
        head.next = null;
        tmp.next = head;
        return newHead;
    }


}
