// Last updated: 09/07/2026, 15:14:29
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    public static void helper(TreeNode root, List<Integer> ans){
        if (root == null){
            return;
        }
        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.val);
    }
}