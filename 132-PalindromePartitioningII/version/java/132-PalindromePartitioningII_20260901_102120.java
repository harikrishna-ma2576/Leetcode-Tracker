// Last updated: 01/09/2026, 10:21:20
1class Solution {
2    public int minCut(String s) {
3        int n = s.length();
4        boolean[][] isPalindrome = new boolean[n][n];
5        int[] minCuts = new int[n];
6        // Step 1
7        for (int end = 0; end < n; end++) {
8            for (int start = 0; start <= end; start++) {
9                if (s.charAt(start) == s.charAt(end) &&
10                    (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
11                    isPalindrome[start][end] = true;
12                }
13            }
14        }
15        // Step 2:
16        for (int i = 0; i < n; i++) {
17            if (isPalindrome[0][i]) {
18                minCuts[i] = 0; // the whole substring is a palindrome
19            } else {
20                int min = i;
21                for (int j = 0; j < i; j++) {
22                    if (isPalindrome[j + 1][i]) {
23                        min = Math.min(min, minCuts[j] + 1);
24                    }
25                }
26                minCuts[i] = min;
27            }
28        }
29        return minCuts[n - 1];
30    }
31}