// Last updated: 01/09/2026, 12:22:49
1class Solution {
2    public void reorderList(ListNode head) {
3        if (head == null || head.next == null)
4            return;
5
6        ListNode slow = head;
7        ListNode fast = head;
8
9        while (fast.next != null && fast.next.next != null) {
10            slow = slow.next;
11            fast = fast.next.next;
12        }
13
14        ListNode second = reverse(slow.next);
15        slow.next = null;
16
17        ListNode first = head;
18
19        while (second != null) {
20            ListNode temp1 = first.next;
21            ListNode temp2 = second.next;
22
23            first.next = second;
24            second.next = temp1;
25
26            first = temp1;
27            second = temp2;
28        }
29    }
30
31    private ListNode reverse(ListNode head) {
32        ListNode prev = null;
33
34        while (head != null) {
35            ListNode next = head.next;
36            head.next = prev;
37            prev = head;
38            head = next;
39        }
40
41        return prev;
42    }
43}