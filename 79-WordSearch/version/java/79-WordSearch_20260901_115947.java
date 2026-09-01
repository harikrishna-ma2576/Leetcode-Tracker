// Last updated: 01/09/2026, 11:59:47
1class Solution {
2    private int rows;
3    private int cols;
4    private Set<String> visited;
5
6    public boolean exist(char[][] board, String word) {
7        rows = board.length;
8        cols = board[0].length;
9        visited = new HashSet<>();
10
11        Map<Character, Integer> count = new HashMap<>();
12        for (char c : word.toCharArray()) {
13            count.put(c, count.getOrDefault(c, 0) + 1);
14        }
15
16        if (count.getOrDefault(word.charAt(0), 0) > count.getOrDefault(word.charAt(word.length() - 1), 0)) {
17            word = new StringBuilder(word).reverse().toString();
18        }
19
20        for (int r = 0; r < rows; r++) {
21            for (int c = 0; c < cols; c++) {
22                if (dfs(board, word, r, c, 0)) {
23                    return true;
24                }
25            }
26        }
27
28        return false;
29    }
30
31    private boolean dfs(char[][] board, String word, int r, int c, int k) {
32        if (k == word.length()) {
33            return true;
34        }
35
36        if (r < 0 || r >= rows || c < 0 || c >= cols || visited.contains(r + "," + c) || board[r][c] != word.charAt(k)) {
37            return false;
38        }
39
40        visited.add(r + "," + c);
41        boolean res = dfs(board, word, r + 1, c, k + 1) ||
42                      dfs(board, word, r - 1, c, k + 1) ||
43                      dfs(board, word, r, c + 1, k + 1) ||
44                      dfs(board, word, r, c - 1, k + 1);
45        visited.remove(r + "," + c);
46        return res;
47    }    
48}