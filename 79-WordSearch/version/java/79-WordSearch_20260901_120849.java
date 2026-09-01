// Last updated: 01/09/2026, 12:08:49
1class Solution {
2    public Node copyRandomList(Node head) {
3        if (head == null) {
4            return null;
5        }
6
7        // Step 1: Create copy nodes
8        Node curr = head;
9
10        while (curr != null) {
11            Node copy = new Node(curr.val);
12            copy.next = curr.next;
13            curr.next = copy;
14            curr = copy.next;
15        }
16
17        // Step 2: Set random pointers
18        curr = head;
19
20        while (curr != null) {
21            if (curr.random != null) {
22                curr.next.random = curr.random.next;
23            }
24            curr = curr.next.next;
25        }
26
27        // Step 3: Separate original and copied lists
28        curr = head;
29        Node newHead = head.next;
30
31        while (curr != null) {
32            Node copy = curr.next;
33            curr.next = copy.next;
34
35            if (copy.next != null) {
36                copy.next = copy.next.next;
37            }
38
39            curr = curr.next;
40        }
41
42        return newHead;
43    }
44}