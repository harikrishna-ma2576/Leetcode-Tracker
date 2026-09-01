// Last updated: 01/09/2026, 10:11:11
1class Solution {
2    public int sumNumbers(TreeNode root) {
3        return dfs(root, 0);        
4    }
5
6    private int dfs(TreeNode node, int num) {
7        if (node == null) {
8            return 0;
9        }
10        
11        num = num * 10 + node.val;
12        
13        if (node.left == null && node.right == null) {
14            return num;
15        }
16        
17        return dfs(node.left, num) + dfs(node.right, num);
18    }    
19}