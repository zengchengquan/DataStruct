import LinkedList.ListNode;

/**
 * Created by zeng.chengquan on 2018/5/21 0021.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next:head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        int flag = 0;
        while (!(l1==null&&l2==null)){
            int val = l1.val+l2.val;
            if(val>=10){
                val = val%10;
                flag = 1;
            }
            new ListNode(val).next = l1;
        }
        return l1;
    }
}
