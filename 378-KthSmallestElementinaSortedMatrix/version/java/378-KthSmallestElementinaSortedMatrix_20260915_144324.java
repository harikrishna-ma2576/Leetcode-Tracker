// Last updated: 15/09/2026, 14:43:24
1class Solution {
2    public static int counting(int matrix[][], int target) {
3        int count = 0;
4
5        for (int i = 0; i < matrix.length; i++) {
6            for (int j = 0; j < matrix[0].length; j++) {
7                if (matrix[i][j] <= target) {
8                    count++;
9                }
10            }
11        }
12
13        return count;
14    }
15
16    public int kthSmallest(int[][] matrix, int k) {
17        int n = matrix.length;
18
19        int low = matrix[0][0];
20        int high = matrix[n - 1][n - 1];
21
22        while (low < high) {
23            int mid = low + (high - low) / 2;
24
25            int count = counting(matrix, mid);
26
27            if (count >= k) {
28                high = mid;
29            } else {
30                low = mid + 1;
31            }
32        }
33
34        return low;
35    }
36}