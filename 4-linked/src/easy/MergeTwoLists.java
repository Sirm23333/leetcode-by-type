package easy;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    /**
     * 直接迭代拼接
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = new ListNode() , tmp = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tmp.next = l1;
                tmp = l1;
                l1 = l1.next;
            }else {
                tmp.next = l2;
                tmp = l2;
                l2 = l2.next;
            }
        }
        if(l1 == null)
            tmp.next = l2;
        else if(l2 == null)
            tmp.next = l1;
        return head.next;
    }
    /**
     * 递归拼接
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next , l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

}
