// Last updated: 10/10/2026, 16:12:12
1/**
2 * Using Reservoir Sampling
3 *
4 * Suppose the indexes of the target element in array are from 1 to N. You have
5 * already picked i-1 elements. Now you are trying to pick ith element. The
6 * probability to pick it is 1/i. Now you do not want to pick any future
7 * numbers.. Thus, the final probability for ith element = 1/i * (1 - 1/(i+1)) *
8 * (1 - 1/(i+2)) * .. * (1 - 1/N) = 1 / N.
9 *
10 * Time Complexity:
11 * 1) Solution() Constructor -> O(1)
12 * 2) pick() -> O(N)
13 *
14 * Space Complexity: O(1)
15 *
16 * N = Length of the input array.
17 */
18class Solution {
19
20    int[] nums;
21    Random random;
22
23    public Solution(int[] nums) {
24        this.nums = nums;
25        this.random = new Random();
26    }
27
28    public int pick(int target) {
29        int idx = -1;
30        int count = 0;
31        for (int i = 0; i < nums.length; i++) {
32            if (nums[i] == target) {
33                count++;
34                if (random.nextInt(count) == 0) {
35                    idx = i;
36                }
37            }
38        }
39
40        return idx;
41    }
42}