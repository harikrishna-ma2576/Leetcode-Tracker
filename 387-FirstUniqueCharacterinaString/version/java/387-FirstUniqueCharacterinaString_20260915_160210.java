// Last updated: 15/09/2026, 16:02:10
1class Solution {
2    public int firstUniqChar(String s) {
3        Map<Character, Integer> freq = new HashMap<>();
4
5        for (char c : s.toCharArray()) {
6            freq.put(c, freq.getOrDefault(c, 0) + 1);
7        }
8
9        for (int i = 0; i < s.length(); i++) {
10            if (freq.get(s.charAt(i)) == 1) {
11                return i;
12            }
13        }
14
15        return -1;        
16    }
17}