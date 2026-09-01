// Last updated: 01/09/2026, 12:20:54
1public class Solution {
2    public ListNode detectCycle(ListNode head) {
3        ListNode slow = head;
4        ListNode fast = head;
5
6        while (fast != null && fast.next != null) {
7            slow = slow.next;
8            fast = fast.next.next;
9
10            if (slow == fast) {
11                slow = head;
12
13                while (slow != fast) {
14                    slow = slow.next;
15                    fast = fast.next;
16                }
17
18                return slow;
19            }
20        }
21
22        return null;
23    }
24}