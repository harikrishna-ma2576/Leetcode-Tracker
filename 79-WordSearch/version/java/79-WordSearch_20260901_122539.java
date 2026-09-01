// Last updated: 01/09/2026, 12:25:39
1class Solution {
2    public ListNode sortList(ListNode head) {
3        if (head == null || head.next == null)
4            return head;
5
6        ListNode slow = head;
7        ListNode fast = head.next;
8
9        while (fast != null && fast.next != null) {
10            slow = slow.next;
11            fast = fast.next.next;
12        }
13
14        ListNode mid = slow.next;
15        slow.next = null;
16
17        ListNode left = sortList(head);
18        ListNode right = sortList(mid);
19
20        return merge(left, right);
21    }
22
23    private ListNode merge(ListNode a, ListNode b) {
24        ListNode dummy = new ListNode(0);
25        ListNode curr = dummy;
26
27        while (a != null && b != null) {
28            if (a.val < b.val) {
29                curr.next = a;
30                a = a.next;
31            } else {
32                curr.next = b;
33                b = b.next;
34            }
35
36            curr = curr.next;
37        }
38
39        curr.next = (a != null) ? a : b;
40
41        return dummy.next;
42    }
43}