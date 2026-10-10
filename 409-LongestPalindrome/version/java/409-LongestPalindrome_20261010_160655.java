// Last updated: 10/10/2026, 16:06:55
1class Solution {
2    public int longestPalindrome(String s) {
3        HashMap<Character, Integer> charCount = new HashMap<>();
4
5        for (char c : s.toCharArray()) {
6            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
7        }
8
9        int length = 0;
10        boolean hasOdd = false;
11
12        for (int count : charCount.values()) {
13            if (count % 2 == 0) {
14                length += count;
15            } else {
16                length += count - 1;
17                hasOdd = true;
18            }
19        }
20
21        if (hasOdd) {
22            length += 1;
23        }
24
25        return length;      
26    }
27}