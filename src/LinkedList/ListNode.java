package LinkedList;

/**
 * Created by zeng.chengquan on 2018/5/30 0030.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1 ; i < arr.length ; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList.ListNode: ");
        ListNode cur = this;
        while (cur!=null){
            sb.append(cur.val+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String args[]){
        int [] nums = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(nums);
        System.out.println(head);
    }
}
