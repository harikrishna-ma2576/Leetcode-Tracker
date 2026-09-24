// Last updated: 24/09/2026, 10:01:02
1class Solution {
2    public int integerReplacement(int n) {
3        long num = n; int result = 0;
4        while(num != 1) {
5            if((num & 1) == 0) num >>= 1;
6            else {
7                if(num == 3 || num % 4 == 1) num--;
8                else num++;
9            }
10            result++;
11        }
12        return result;
13    }
14}