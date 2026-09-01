// Last updated: 01/09/2026, 09:52:46
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length(), n = t.length();
4        int[][] dp = new int[m + 1][n + 1];
5        for (int i = 0; i < m; i++) dp[i][0] = 1;
6        for (int i = 1; i <= m; i++) {
7            for (int j = 1; j <= n; j++) {
8                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
9                else dp[i][j] = dp[i - 1][j];
10            }
11        }
12        return dp[m][n];
13    }
14}