package leetcode.Remove_Linked_List_Elements;

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while(true){
            if(head != null && head.val == val){
                head = head.next;
            }
            else{
                break;
            }

        }
        if(head == null)
            return head;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
        //递归方法实现，内存使用比上面方法大
//        if(head == null)
//            return null;
//        head.next = removeElements(head.next, val);
//
//        return head.val == val ? head.next : head;
    }

}