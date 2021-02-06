package medium;

import easy.ListNode;

/**
 *两数相加
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvw73v/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode() , tmpRs = rs;
        ListNode tmp1 = l1 , tmp2 = l2;
        int carry = 0;
        while(tmp1 != null && tmp2 != null){
            int add = tmp1.val + tmp2.val + carry;
            tmpRs.next = new ListNode(add % 10 );
            tmpRs = tmpRs.next;
            carry = add / 10;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        while(tmp1 != null){
            int add = tmp1.val +  carry;
            tmpRs.next = new ListNode(add % 10);
            tmpRs = tmpRs.next;
            carry = add / 10;
            tmp1 = tmp1.next;
        }
        while(tmp2 != null){
            int add = tmp2.val +  carry;
            tmpRs.next = new ListNode(add % 10);
            tmpRs = tmpRs.next;
            carry = add / 10;
            tmp2 = tmp2.next;
        }
        if(carry > 0)
            tmpRs.next = new ListNode(carry);
        return rs.next;
    }
}
