// Last updated: 01/09/2026, 12:18:23
1class Solution {
2    public List<String> wordBreak(String s, List<String> wordDict) {
3        Set<String> set = new HashSet<>(wordDict);
4        Map<Integer, List<String>> memo = new HashMap<>();
5        return dfs(s, 0, set, memo);
6    }
7
8    private List<String> dfs(String s, int start, Set<String> set,
9                             Map<Integer, List<String>> memo) {
10        if (memo.containsKey(start))
11            return memo.get(start);
12
13        List<String> result = new ArrayList<>();
14
15        if (start == s.length()) {
16            result.add("");
17            return result;
18        }
19
20        for (int end = start + 1; end <= s.length(); end++) {
21            String word = s.substring(start, end);
22
23            if (set.contains(word)) {
24                for (String next : dfs(s, end, set, memo)) {
25                    result.add(word + (next.isEmpty() ? "" : " " + next));
26                }
27            }
28        }
29
30        memo.put(start, result);
31        return result;
32    }
33}