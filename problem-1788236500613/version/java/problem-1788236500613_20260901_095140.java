// Last updated: 01/09/2026, 09:51:40
1class Solution {
2    public void flatten(TreeNode root) {
3        TreeNode curr = root;
4        while (curr != null) {
5            if (curr.left != null) {
6                TreeNode runner = curr.left;
7                while (runner.right != null) runner = runner.right;
8                runner.right = curr.right;
9                curr.right = curr.left;
10                curr.left = null;
11            }
12            curr = curr.right;
13        }
14    }
15}