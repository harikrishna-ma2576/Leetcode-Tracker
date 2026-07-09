// Last updated: 09/07/2026, 15:14:47
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int m = q.size();
            List<Integer> collections = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                TreeNode curr = q.poll();

                if (leftToRight) {
                    collections.add(curr.val);
                } else {
                    collections.add(0, curr.val);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            ans.add(collections);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}