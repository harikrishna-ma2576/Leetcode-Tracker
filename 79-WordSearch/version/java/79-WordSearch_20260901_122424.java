// Last updated: 01/09/2026, 12:24:24
1class Solution {
2    public List<Integer> preorderTraversal(TreeNode root) {
3        List<Integer> result = new ArrayList<>();
4        preorder(root, result);
5        return result;
6    }
7
8    private void preorder(TreeNode root, List<Integer> result) {
9        if (root == null)
10            return;
11
12        result.add(root.val);
13        preorder(root.left, result);
14        preorder(root.right, result);
15    }
16}