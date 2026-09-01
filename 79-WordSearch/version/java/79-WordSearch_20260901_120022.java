// Last updated: 01/09/2026, 12:00:22
1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null) return head;
4
5        int length = 1;
6        ListNode dummy = head;
7
8        while (dummy.next != null) {
9            dummy = dummy.next;
10            length++;
11        }
12
13        int position = k % length;
14        if (position == 0) return head;
15
16        ListNode current = head;
17        for (int i = 0; i < length - position - 1; i++) {
18            current = current.next;
19        }
20
21        ListNode newHead = current.next;
22        current.next = null;
23        dummy.next = head;
24
25        return newHead;        
26    }
27}