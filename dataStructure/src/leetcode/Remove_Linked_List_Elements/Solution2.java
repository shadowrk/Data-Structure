package leetcode.Remove_Linked_List_Elements;

public class Solution2 {
    /**
     * 使用虚拟头结点解决问题
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return dummyNode.next;
    }
}
