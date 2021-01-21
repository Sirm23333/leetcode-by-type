package easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class HasCycle {

    /**
     * 哈希表存储已经访问的节点
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode tmp = head;
        while(tmp != null){
            if(!visited.add(tmp))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode fast = head.next , slow = head;
        while (fast != null && fast.next != null  && slow != fast){
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast != null && fast.next != null;
    }

}
