// Last updated: 09/07/2026, 15:12:29
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        
        fast = head ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow ;
    }
}
