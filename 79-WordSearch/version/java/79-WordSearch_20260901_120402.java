// Last updated: 01/09/2026, 12:04:02
1class Solution {
2    public void setZeroes(int[][] matrix) {
3        int rows = matrix.length;
4        int cols = matrix[0].length;
5
6        boolean firstRowHasZero = false;
7        boolean firstColHasZero = false;
8
9        // Check if the first row contains zero
10        for (int c = 0; c < cols; c++) {
11            if (matrix[0][c] == 0) {
12                firstRowHasZero = true;
13                break;
14            }
15        }
16
17        // Check if the first column contains zero
18        for (int r = 0; r < rows; r++) {
19            if (matrix[r][0] == 0) {
20                firstColHasZero = true;
21                break;
22            }
23        }
24
25        // Use the first row and column as markers
26        for (int r = 1; r < rows; r++) {
27            for (int c = 1; c < cols; c++) {
28                if (matrix[r][c] == 0) {
29                    matrix[r][0] = 0;
30                    matrix[0][c] = 0;
31                }
32            }
33        }
34
35        // Set the marked rows to zero
36        for (int r = 1; r < rows; r++) {
37            if (matrix[r][0] == 0) {
38                for (int c = 1; c < cols; c++) {
39                    matrix[r][c] = 0;
40                }
41            }
42        }
43
44        // Set the marked columns to zero
45        for (int c = 1; c < cols; c++) {
46            if (matrix[0][c] == 0) {
47                for (int r = 1; r < rows; r++) {
48                    matrix[r][c] = 0;
49                }
50            }
51        }
52
53        // Set the first row to zero if needed
54        if (firstRowHasZero) {
55            for (int c = 0; c < cols; c++) {
56                matrix[0][c] = 0;
57            }
58        }
59
60        // Set the first column to zero if needed
61        if (firstColHasZero) {
62            for (int r = 0; r < rows; r++) {
63                matrix[r][0] = 0;
64            }
65        }        
66    }
67}