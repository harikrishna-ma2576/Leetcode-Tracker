// Last updated: 01/09/2026, 09:53:32
1class Solution {
2    public Node connect(Node root) {
3        if(root == null) return null;
4        Queue<Node> q = new LinkedList<>();
5        q.offer(root);
6        while(!q.isEmpty()) {
7            Node rightNode = null;
8            for(int i = q.size(); i > 0; i--) {
9                Node cur = q.poll();
10                cur.next = rightNode;
11                rightNode = cur;
12                if(cur.right != null) {
13                    q.offer(cur.right);
14                    q.offer(cur.left);
15                }
16            }
17        }
18        return root;        
19    }
20}