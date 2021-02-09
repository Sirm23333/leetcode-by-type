package easy;

import java.util.Stack;

/**
 *剑指 Offer 06. 从尾到头打印链表
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while(p != null){
            stack.push(p.val);
            p = p.next;
        }
        int[] rs = new int[stack.size()];
        for(int i = 0; i < rs.length; i++){
            rs[i] = stack.pop();
        }
        return rs;
    }
}
