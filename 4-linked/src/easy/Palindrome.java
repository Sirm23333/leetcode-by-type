package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Palindrome {

    /**
     * 使用栈+两次遍历
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while(tmp != null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        tmp = head;
        while(tmp != null){
            if(tmp.val != stack.pop().val)
                return false;
            tmp = tmp.next;
        }
        return true;

    }

    /**
     * 转为list+双指针
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            list.add(tmp);
            tmp = tmp.next;
        }
        int i = 0 , j = list.size() - 1;
        while(i < j){
            if(list.get(i++).val != list.get(j--).val)
                return false;
        }
        return true;

    }

    /**
     * 翻转后半段+比较
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        if(head == null)
            return true;
        // 中间节点
        ListNode midNode = getMidNode(head);
        // 翻转后半段
        ListNode rightHead = reverse(midNode.next);
        ListNode tmpI = head , tmpJ = rightHead;
        boolean rs = true;
        while(tmpJ != null){
            if(tmpI.val != tmpJ.val){
                rs = false;
                break;
            }
            tmpI = tmpI.next;
            tmpJ = tmpJ.next;
        }
        // 还原
        reverse(rightHead);
        return rs;
    }

    /**
     * 获得中间节点
     * @param head
     * @return
     */
    public ListNode getMidNode(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode fast = head , slow = head;
        while(fast.next != null){
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head , tmp;
        while(head.next != null){
            tmp = head.next;
            head.next = tmp.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }


}
