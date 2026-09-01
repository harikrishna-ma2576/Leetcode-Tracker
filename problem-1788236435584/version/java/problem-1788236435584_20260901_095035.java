// Last updated: 01/09/2026, 09:50:35
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6## *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
18        final var res = new ArrayList<List<Integer>>();
19        dfs(res, new ArrayList<Integer>(), root, targetSum, 0);
20        return res;
21    }
22
23    public void dfs(final List<List<Integer>> arr, final List<Integer> tempBox, final TreeNode node, final int targetSum, final int currentSum) {
24        if (node == null) return;
25
26        tempBox.add(node.val);
27        if (node.left != null) {
28            dfs(arr, tempBox, node.left, targetSum, currentSum + node.val);
29            tempBox.removeLast();
30        }
31        if (node.right != null) {
32            dfs(arr, tempBox, node.right, targetSum, currentSum + node.val);
33            tempBox.removeLast();
34        }
35        if (node.left == null && node.right == null && targetSum == currentSum + node.val) {
36            arr.add(new ArrayList<>(tempBox));
37            return;
38        }
39    }
40}