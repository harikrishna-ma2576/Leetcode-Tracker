// Last updated: 15/09/2026, 16:12:07
1class Solution {
2public:
3    char findTheDifference(string s, string t) {
4        char r=0;
5        for(char c:s) r ^=c;
6        for(char c:t) r ^=c;
7        return r;
8    }
9};