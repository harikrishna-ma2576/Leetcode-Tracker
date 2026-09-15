// Last updated: 15/09/2026, 09:15:10
1class Solution {
2    public int longestSubstring(String s, int k) {
3        if (s == null || s.length() == 0) return 0;
4        if (k<2) return s.length();
5        return helper(s, 0, s.length(), k);
6    }
7
8    public int helper(String s, int l, int r, int k) {
9        if (l>=r) return 0;
10        
11        // build freq map
12        int[] freq = new int[26];
13        for (int i=l; i<r; i++) freq[s.charAt(i)-'a']++;
14        
15        // check if valid
16        boolean valid = true;
17        for (int i=0; i<26 && valid; i++) if (freq[i] > 0 && freq[i] < k) valid = false;
18        if (valid) return r-l;
19        
20        // if not for each invalid character start a new split search
21        int best = 0, start=l;
22        for (int i=l; i<r; i++) {
23            if (freq[s.charAt(i) -'a'] < k) {
24                best = Math.max(best, helper(s, start, i, k));
25                start = i+1;
26            }
27        }
28        best = Math.max(best, helper(s, start, r, k));
29        return best;
30    }
31}