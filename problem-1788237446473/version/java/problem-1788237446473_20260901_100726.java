// Last updated: 01/09/2026, 10:07:26
1class Solution {
2    public boolean isPalindrome(String s) {
3        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
4        int left = 0;
5        int right = s.length() - 1;
6
7        while (left < right) {
8            if (s.charAt(left) != s.charAt(right)) {
9                return false;
10            }
11            left++;
12            right--;
13        }
14        return true;        
15    }
16}