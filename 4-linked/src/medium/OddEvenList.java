package medium;

import easy.ListNode;

/**
 *奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode oddHead = head.next;
        ListNode evenList = head;
        ListNode oddList = oddHead;
        ListNode p = oddList.next; // 遍历指针
        boolean even = true; // true为偶数  false为基数
        while (p != null){
            if(even){
                evenList.next = p;
                evenList = evenList.next;
            }else {
                oddList.next = p;
                oddList = oddList.next;
            }
            even = !even;
            p = p.next;
        }
        oddList.next = null;
        evenList.next = oddHead;
        return head;
    }
}
