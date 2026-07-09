// Last updated: 09/07/2026, 15:17:12
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Check if there are at least k nodes
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have k nodes, reverse them
        if (count == k) {
            curr = reverseKGroup(curr, k); // process remaining list

            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }

        return head;
    }
}