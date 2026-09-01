// Last updated: 01/09/2026, 12:30:25
1class Solution {
2    public String reverseWords(String s) {
3        String[] words = s.trim().split("\\s+");
4
5        StringBuilder result = new StringBuilder();
6
7        for (int i = words.length - 1; i >= 0; i--) {
8            result.append(words[i]);
9
10            if (i != 0)
11                result.append(" ");
12        }
13
14        return result.toString();
15    }
16}