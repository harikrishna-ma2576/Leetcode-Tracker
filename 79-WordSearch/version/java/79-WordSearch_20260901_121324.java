// Last updated: 01/09/2026, 12:13:24
1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        boolean[] dp = new boolean[s.length() + 1];
4        dp[0] = true;
5
6        for (int i = 1; i <= s.length(); i++) {
7            for (String word : wordDict) {
8                int len = word.length();
9
10                if (i >= len && dp[i - len]
11                        && s.substring(i - len, i).equals(word)) {
12                    dp[i] = true;
13                    break;
14                }
15            }
16        }
17
18        return dp[s.length()];
19    }
20}