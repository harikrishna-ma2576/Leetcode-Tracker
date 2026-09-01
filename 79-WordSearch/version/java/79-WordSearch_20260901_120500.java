// Last updated: 01/09/2026, 12:05:00
1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4        int totalCandies = n;
5        int i = 1;
6
7        while (i < n) {
8            if (ratings[i] == ratings[i - 1]) {
9                i++;
10                continue;
11            }
12
13            int currentPeak = 0;
14            while (i < n && ratings[i] > ratings[i - 1]) {
15                currentPeak++;
16                totalCandies += currentPeak;
17                i++;
18            }
19
20            if (i == n) {
21                return totalCandies;
22            }
23
24            int currentValley = 0;
25            while (i < n && ratings[i] < ratings[i - 1]) {
26                currentValley++;
27                totalCandies += currentValley;
28                i++;
29            }
30
31            totalCandies -= Math.min(currentPeak, currentValley);
32        }
33
34        return totalCandies;        
35    }
36}