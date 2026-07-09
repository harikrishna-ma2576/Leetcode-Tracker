// Last updated: 09/07/2026, 15:13:38
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=node;
            node=curr;
            curr=next;
        }
        return node;
    }
}