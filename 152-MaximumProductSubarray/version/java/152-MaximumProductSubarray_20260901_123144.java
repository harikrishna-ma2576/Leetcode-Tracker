// Last updated: 01/09/2026, 12:31:44
1class Solution {
2    public int maxProduct(int[] nums) {
3        int max = nums[0];
4        int min = nums[0];
5        int answer = nums[0];
6
7        for (int i = 1; i < nums.length; i++) {
8            int num = nums[i];
9
10            if (num < 0) {
11                int temp = max;
12                max = min;
13                min = temp;
14            }
15
16            max = Math.max(num, max * num);
17            min = Math.min(num, min * num);
18
19            answer = Math.max(answer, max);
20        }
21
22        return answer;
23    }
24}